package queue;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//一个个人写的  仿 ArrayBlockingQueue  的queue
public class Zqueue<T>{
    /*存储数据的*/
    private Object[] objects;
    /*锁*/
    private ReentrantLock lock;

    private Condition full;

    private Condition empty;

    private int count;//总数

    private int takeIndex;//下一次要取出的坐标

    private int putIndex;//下一次 要存的坐标

    public Zqueue(int capacity){
        if (capacity<=0){
            throw new IllegalArgumentException();
        }
        this.objects = new Object[capacity];
        this.lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
    }

    public void add(T object) throws InterruptedException {
        final ReentrantLock lock = this.lock;
        try {
            System.out.println("put  lock  bofore");
            if (lock.tryLock()){
                System.out.println("put lock last");
                Object[] objects = this.objects;
                if (count==objects.length){
                    System.out.println("put   full.await();  brfore");

                    System.out.println("put   full.await();  last");
                }
                objects[putIndex] = Objects.requireNonNull(object);
                if (++putIndex==objects.length) putIndex = 0;
                count++;
                System.out.println("put  empty.signal();");
                empty.signal();
            }else {
                System.out.println("put 获取lock 失败");
            }
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        System.out.println("read brfore");
        lock.lock();
        System.out.println("read last");
        try {
            Object[] objects = this.objects;
            if (count==0) {
                System.out.println("read empty.await() brfore");
                empty.await();
                System.out.println("read empty.await() last ");
            }
            @SuppressWarnings("unchecked")
            T e = (T) objects[takeIndex];
            objects[takeIndex] = null;//GC
            if (++takeIndex==objects.length) takeIndex = 0;
            count--;
            System.out.println("read   full.signal()");
            full.signal();
            return e;
        }finally {
           lock.unlock();
        }
    }
}
