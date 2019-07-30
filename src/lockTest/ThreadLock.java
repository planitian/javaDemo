package lockTest;

import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock extends Thread {

    Lock lock;
    private Storage inner;

    public void setInner(Storage inner) {
        this.inner = inner;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public void run() {
        super.run();

            System.out.println(Thread.currentThread().getName() + "获取了锁");
                try {
//                    while (inner.getAnInt() <= 100) {
//                        int tem = inner.getAnInt();
//                        inner.setAnInt(++tem);
//                        Thread.sleep(1000);
//                        System.out.println(Thread.currentThread().getName() + "加一" + inner.getAnInt());
//                    }
                    synchronized (this){
                        for (int i = 0; i <10 ; i++) {
                            inner.getIntegers().add(i);
                            Thread.sleep(10);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "解锁");
//                    lock.unlock();
                }


            }

}
