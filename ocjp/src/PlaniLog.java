import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class PlaniLog {
    private static ExecutorService executorService;
    private static ConcurrentLinkedQueue<String> concurrentLinkedQueue;
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition empty = reentrantLock.newCondition();
    public static  String path;
    public static int SIZE = 2;//以兆为单位
    static {
        executorService = Executors.newSingleThreadExecutor();
        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    }

    public static void pre() {
        if (path==null){
            throw new IllegalStateException("请先设置好 文件路径");
        }
        executorService.execute(()->{
            int counts = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (true){
                String temp = concurrentLinkedQueue.poll();
                if (temp==null){
                    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100));
                }else if (temp.length()!=0){
                    stringBuilder.append(temp).append(System.lineSeparator());
                }
                counts++;
                if (counts>10){
                    try {
                        check(path);
                        write(path,stringBuilder.toString());
                        stringBuilder.delete(0, stringBuilder.length());
                        counts = 0;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void writeLog(String content) {
        concurrentLinkedQueue.add(content);
    }

    private static File createParent(String path, boolean isFile) throws IOException {
        File file = new File(path);
        if (!file.exists()) {//不存在
            String parent = file.getParent();//得到父母，如果返回空 ，那么就到顶了
            if (parent != null) {
                createParent(parent, false);//因为是父母，所以肯定不是file；
            }
            if (isFile) {
                file.createNewFile();
            } else {
                file.mkdir();
            }
        } else if (file.isFile() != isFile) {//如果 有相同的文件夹或文件 和path重名，但类型不一样
            file.delete();//先删除
            createParent(path, isFile);//再重新进入
        }
        return file;
    }

    private static void write(String path, String content) throws IOException {
        File file = createParent(path, true);
        System.out.println("文件大小 " + (file.length() / 1024 + 1));
        FileWriter fileWriter = new FileWriter(file, true);//追加模式写入
        fileWriter.write(content);
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * 检查文件是否大于约定的
     * @param path
     */
    private static void check(String path){
        File file = new File(path);
        if (file.exists()&&(file.length()/1024*1024)>SIZE){
            file.delete();
        }
    }

}
