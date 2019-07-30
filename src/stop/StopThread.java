package stop;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StopThread {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newCachedThreadPool();
        executorService.execute(()->{
            while (true){
                System.out.println("ssssss");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Scanner scanner=new Scanner(System.in);
        String sss=scanner.next();
        if (sss.equals("sss")){
            executorService.shutdown();
        }

    }
}
