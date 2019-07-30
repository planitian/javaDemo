package udp;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Consumer;

public class UdpOne {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    /*public static void main(String[] args) {
        try {


            //发送端
            InetAddress inetAddress = InetAddress.getLocalHost();
            byte[] out = new byte[5];
            //数据包 发送的地址 和端口 是自己指定的
            DatagramPacket outData = new DatagramPacket(out, out.length,inetAddress,9999);

            DatagramSocket socket = new DatagramSocket(4567);
            //发送不阻塞
            socket.send(outData);
            socket.close();
            String ss = "fsdf";
            out(s -> {
                System.out.println(s);
            });

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static <T> void out(Consumer<T> tConsumer) {

    }

    public static void main(String[] args) throws InterruptedException {
       /* TreeMap<Integer, Integer> test = new TreeMap<>();
        test.put(1, 1);
        test.put(5, 5);
        test.put(4, 4);
        test.put(3, 3);
        test.put(2, 2);
        test.put(2, 6);
        out(test);
        System.out.println("ss");
        SortedMap<Integer, Integer> subMap = test.tailMap(2);
        out(subMap);
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("one");
        set.add("vvv");
        set.add("tt");
        Iterator<String> iterable = set.iterator();
        while (iterable.hasNext()){
            System.out.println(iterable.next());
        }

        System.out.println(">>>>>>>>>>>>>>");
        HashSet<String> strings = new HashSet<>();
        String s = "vvvvs";
        strings.add("fff");
        strings.add("hhhh");
        strings.add("www");
        strings.add(s);
        Iterator<String> iterable1 = strings.iterator();
        while (iterable1.hasNext()){
            System.out.println(iterable1.next());
        }*/

      /*  ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(4);
        strings.add("one");
        strings.add("two");
        strings.add("ttt");
        strings.add("444");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());*/

    /*    //DelayQueue
        DelayQueue<DelayTest> delayQueue = new DelayQueue<>();
        //所有元素的getDelay方法 是同时进行运算的
        delayQueue.offer(new DelayTest("oneddddd", 6));//按照长度排序 这个在最后一位
        delayQueue.offer(new DelayTest("two", 3));//这是第一位，查询到这个时候  下面的 已经可以查询了。
        delayQueue.offer(new DelayTest("three", 1));
        delayQueue.offer(new DelayTest("four", 8));//第二位  这个要等待
        while (true) {
            DelayTest delayTest = delayQueue.take();
            if (delayTest != null) {
                System.out.println(delayTest.Id);
            }
        }*/

    /*    Object o = new Object();
        Thread thread = new Thread(runnable);
        thread.start();
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        LockSupport.parkNanos(timeUnit.convert(5L,TimeUnit.SECONDS));

        TimeUnit unit = TimeUnit.SECONDS;
        LockSupport.unpark(thread);*/

        /*System.out.println("阻塞 输出"+LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        LocalDateTime change = LocalDateTime.ofEpochSecond(1549641637413L, 0, ZoneOffset.of("+8"));
        LocalDateTime changeMilli = Instant.ofEpochMilli(1549642145662L).atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(changeMilli);
        LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));*/

       /* SynchronousQueue<Integer> integers = new SynchronousQueue<>();
        new Thread(() -> {
            while (true) {
                Integer i;
                try {
                    if ((i = integers.poll(5,TimeUnit.SECONDS)) != null) {
                        System.out.println(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; ; i++) {
                integers.offer(i);
                //阻塞五秒
                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
            }
        }).start();*/

        Object o = new Object();
//        new Thread(()->{
//            synchronized (o){
//                System.out.println(" one  得到锁 阻塞开始");
//                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(30));
//                System.out.println(" one  得到锁 阻塞结束");
//            }
//        }).start();
//        Thread.sleep(5000);
      /*  Thread one=new Thread(() -> {
            System.out.println("two  运行");
           synchronized (o){
               System.out.println("two  得到锁");
               LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(3));
           }
        });
        one.start();
        Thread.dumpStack();
        System.out.println("主线程");*/

    /*    AtomicInteger integer = new AtomicInteger(10);
        System.out.println(integer.compareAndSet(10,10));*/


    }

    static Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("线程的   "+t.getName());
            System.out.println("线程的   "+e);
        }
    };

    static <K, V> void out(Map<K, V> map) {
        for (Map.Entry<K, V> m : map.entrySet()) {
            System.out.println(m.toString());
        }
    }

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("线程运行前");
            LockSupport.park();
            System.out.println("线程运行后");
        }
    };

    static class DelayTest implements Delayed {
        private String Id;
        private long liveTime;

        /**
         * @param id
         * @param liveTime 秒
         */
        public DelayTest(String id, int liveTime) {
            Id = id;
            this.liveTime = liveTime * 1000 + System.currentTimeMillis();
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.liveTime - System.currentTimeMillis(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o instanceof DelayTest) {
                return this.Id.length() - (((DelayTest) o).Id.length());
            }
            return -1;
        }
    }
}
