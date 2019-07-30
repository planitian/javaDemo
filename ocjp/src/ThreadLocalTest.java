import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

public class ThreadLocalTest {
    private static  final ThreadLocal<List<String>> threadLocal = new ThreadLocal<List<String>>() {
        //设定默认值，在调用remove 又调用get方法时候 ，会再次调用
        @Override
        protected List<String> initialValue() {
            return null;
        }
    };;

    private static final ThreadLocal<String> local = ThreadLocal.withInitial(() -> "默认值");
    private static final ThreadLocal<String> construct  = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "默认值";
        }
    };

    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(20000);
        ThreadLocal<List<String>> threadLocal = new ThreadLocal<List<String>>() {
            @Override
            protected List<String> initialValue() {
                return null;
            }

            @Override
            protected void finalize() throws Throwable {
                try {
                    System.out.println("threadlocal  回收了》》》》》》》》》》》》》》");
                }finally {
                    super.finalize();
                }
            }
        };
        threadLocal.remove();



        ReentrantLock reentrantLock = new ReentrantLock();
        Condition pre = reentrantLock.newCondition();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50000; i++) {
            reentrantLock.lock();
            executorService.execute(() -> {
                reentrantLock.lock();

               /* if (threadLocal.get()==null){

                }else {
                    System.out.println("线程 已经有局部变量");
                }*/
                List<String> inner = create();
                System.out.println("inner hash"+inner.hashCode());
                threadLocal.set(inner);

                System.out.println(Thread.currentThread().getName());
                pre.signal();
                reentrantLock.unlock();
            });
            System.out.println(i + "   ");
            System.runFinalization();
//            System.out.println(Thread.currentThread().getName()+"ThreadLocal " + (threadLocal.get() == null ? "回收了》》》》》》》》》" : "没有回收"));
            pre.await();
            reentrantLock.unlock();
        }

/*
        ExecutorService executorService = new ThreadPoolExecutor(10, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i <5000 ; i++) {
            executorService.execute(()->{
                threadLocal.set(create());
                synchronized (count){
                    System.out.println(Thread.currentThread().getName()+" count "+count.get());
                    count.getAndIncrement();
                }
            });
            System.out.println(i+"");
        }*/
    }

    static List<String> create() {
        return new ArrayList<String>() {
            {
                for (int i = 0; i < 100000; i++) {
                    this.add(i + "");
                }
            }

            @Override
            protected void finalize() throws Throwable {
                try {
                    System.out.println(this.hashCode()+"回收了");
                } finally {
                    super.finalize();
                }

            }
        };
    }
}
