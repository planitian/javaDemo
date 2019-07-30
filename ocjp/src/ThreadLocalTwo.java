import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ThreadLocalTwo {
    //静态的 延长生命周期。final  不可改变
    private static final ThreadLocal<Integer> threalLocal = ThreadLocal.withInitial(() -> {
        return 0;
    });

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger();
        new Thread(() -> {
            while (true) {
                //取出来
                int inner = threalLocal.get();
                //使用
                System.out.println(Thread.currentThread().getName() + "   " + inner);
                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
                //更新值存入
                threalLocal.set(++inner);
            }
        }, "three")/*.start()*/;

        Thread ee = new Thread(() -> {
        /*    while (true) {
                //取出来
                int inner = threalLocal.get();
                //使用
                System.out.println(Thread.currentThread().getName() + "   " + inner);
                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
                //更新值存入
                threalLocal.set(++inner);
            }*/
            try {
                byte[] bytes = new byte[1024 & 1024];
                TimeUnit.SECONDS.sleep(20);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sss>>>"+Thread.currentThread().getName());
        }, "four");
//        System.out.println(ee.isAlive());
        System.out.println(ee.getState());
        ee.run();
        System.out.println(ee.getState());
        ee.start();
        System.out.println(ee.getState());
        TimeUnit.SECONDS.sleep(5);
        System.out.println(ee.getState());
        System.out.println();

        Runnable runnable = () -> {
            System.out.println("runable "+Thread.currentThread().getName());
        };
        runnable.run();
    }
}
