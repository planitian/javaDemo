package lockTest;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMain {
    public static void main(String[] args) {
        ThreadLock one = new ThreadLock();
        ThreadLock two = new ThreadLock();
        ThreadLock three = new ThreadLock();
        Storage inner = new Storage(1);
        Lock lock = new ReentrantLock();
        one.setInner(inner);
        two.setInner(inner);
        three.setInner(inner);

        one.setLock(lock);
        two.setLock(lock);
        three.setLock(lock);

        one.start();
        two.start();
        three.start();

        try {
            Thread.sleep(1000);
            System.out.println("list"+inner.getIntegers().toString());
        } catch (InterruptedException e) {

            e.printStackTrace();
        }



        Vector<String> vector = new Vector<>(3);
        vector.add("one");
        System.out.println(vector.capacity());
        vector.addElement("two");
        System.out.println(vector.capacity());
        vector.add("three");
        vector.addElement("four");
        System.out.println(vector.get(0));
//        System.out.println(vector.);
        Iterator<String> iterator = vector.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Stack<Integer> integers = new Stack<>();
        integers.add(1);
        integers.add(2);
        System.out.println(integers.push(3));
        System.out.println(integers.pop());
        System.out.println(integers.peek());


    }
}
