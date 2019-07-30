package queue;



import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 创建时间 2019/1/23
 *
 * @author plani
 */
public class BitmapQueue {
    final String TAG = "BitmapQueue";
    private ArrayBlockingQueue<Integer> queue;

    public BitmapQueue() {
        queue = new ArrayBlockingQueue<Integer>(10);
    }

    public synchronized Integer read() throws InterruptedException {
        return queue.take();
    }

    public synchronized void put(Integer image) throws InterruptedException {
        if (queue.size() == 8) {
            Integer image1 = queue.remove();
            System.out.println("移除 内部"+image1);
        }
        queue.put(image);
    }

    public static void main(String[] args) {
        Zqueue<Integer> zqueue = new Zqueue<>(10);
       new Thread(new Runnable() {
           @Override
           public void run() {
               long last = System.currentTimeMillis();
               long now = System.currentTimeMillis();
               int i = 0;
               out:
               while (true){
                   now = System.currentTimeMillis();
                   if ((now-last)>1_000){
                       last = now;
                       try {
                           System.out.println("put");
                           zqueue.add(i++);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }
       }).start();
        new Thread(() -> {
            long last = System.currentTimeMillis();
            long now = System.currentTimeMillis();
            out:
            while (true) {
                now = System.currentTimeMillis();
                if ((now - last) >5_000) {
                    last = now;
                    try {
                        System.out.println(" 读取的 "+zqueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
