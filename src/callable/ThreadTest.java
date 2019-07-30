package callable;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) {
//        ExecutorService executorService=Executors.newSingleThreadExecutor();
//        TestRunable one=new TestRunable();
//        one.setName("one");
//        for (int i = 0; i <10 ; i++) {
//            TestRunable testRunable=new TestRunable();
//            testRunable.setName(String.valueOf(i));
//            executorService.execute(testRunable);
//        }
//        try {
//            Thread.sleep(1000);
//            System.out.println(executorService.isShutdown());
//            executorService.shutdown();
//            Thread.sleep(1);
//            System.out.println(executorService.isTerminated());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(20,125,60,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(5));
        threadPoolExecutor.prestartCoreThread();
        for (int i = 0; i <100 ; i++) {
            threadPoolExecutor.execute(()-> System.out.println("woshi"));
            System.out.println(".getPoolSize()"+threadPoolExecutor.getPoolSize());
            System.out.println(".getTaskCount()"+threadPoolExecutor.getTaskCount());
        }
        threadPoolExecutor.shutdown();

    }



}
class TestRunable  implements Runnable{
    public void setName(String name) {
        this.name = name;
    }

    private volatile String name;

    @Override
    public void run() {
        System.out.println(name);
    }
}
