package ThreadExit;

import build.Person;
import build.Student;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        ThreadTest threadTest = new ThreadTest();
//        threadTest.start();
//        System.out.println(threadTest.getState() + "  " + threadTest.getPriority());
//        threadTest.exit = false;
//        System.out.println(threadTest.getState());
//       Callback callback=new Callback();
//        FutureTask<Boolean> futureTask=new FutureTask<>(callback);
//        new Thread(futureTask).start();
//        try {
//            Thread.sleep(10);
//            boolean ss=futureTask.get();
//            System.out.println("ss"+ss);
//            callback.exit=ss;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//        RunStart runStart = new RunStart();
//        runStart.run();
//        Thread.sleep(1000);
//        runStart.isExit=true;
//        System.out.println(runStart==null);

        Person person = new Person.Builder(1, "ss").build();
        System.out.println(person.toString());


        Student student = new Student.Builder().age(12).name("ss").sex("nan").Build();
        System.out.println(student + Day.ddd.toString());
        Day[] gg = Day.values();
        System.out.println(gg[0]);

        System.out.println(student.getClass().getSimpleName()+">>>"+student.getClass().getName()+">>>"+student.getClass().getSimpleName());
    }


    class ThreadTest extends Thread {
        volatile Boolean exit = true;

        @Override
        public void run() {
            super.run();
            while (exit) {
                System.out.println("线程还在运行");
            }
        }


    }

    class Callback implements Callable<Boolean> {
        volatile boolean exit = false;

        @Override
        public Boolean call() throws Exception {
            //代码
            System.out.println("初始操作");
            while (!exit) {
                Thread.sleep(1000);
                System.out.println("线程还在运行");
            }
            return true;
        }
    }


}

class RunStart implements Runnable {
    public volatile boolean isExit = false;
    private int n = 3;

    @Override
    public void run() {
        while (n != 0) {
            System.out.println("Runnable 在运行");
            n--;
        }
    }
}

enum Day {ss, ddd};
