package callable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        FutureTask<String> stringFuture=new FutureTask<>(new Task());
//        Future<?> result= executorService.submit(stringFuture);
        Future<?> future=executorService.submit(new Task());
        try {
            System.out.println(future.get());
//            System.out.println(stringFuture.get());
//            System.out.println("Future   "+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        Future<String> ss= executorService.submit(new Task());
//        try {
//            System.out.println(ss.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }




//        FutureTask<String> stringFutureTask=new FutureTask<>(new Task());
//        Thread thread=new Thread(stringFutureTask);
//        thread.start();
//        try {
//            System.out.println(stringFutureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        FutureTask<String> futureTask=new FutureTask<String>(new Call(),"sss");
//        Thread thread1=new Thread(futureTask);
//        thread1.start();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.out.println(futureTask.isDone());
//               if (futureTask.isDone()){
//                   System.out.println("sssssssss");
//                   System.out.println(futureTask.get());
//               }
//
//
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}

class Task implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "我是线程返回的";
    }
}

class  Call implements Runnable{

    @Override
    public void run() {
        System.out.println("线程里面");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}