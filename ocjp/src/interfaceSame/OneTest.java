package interfaceSame;

import java.util.ArrayList;
import java.util.LinkedList;

public class OneTest implements One,Two {
    @Override
    public void aaa() {
        System.out.println("哈哈哈");
    }

   public   void tt(){
       System.out.println("  子类");
    }

    public static void main(String[] args) {
        OneTest oneTest = new OneTest();
        oneTest.aaa();
        oneTest.tt();

        One one = oneTest;
        one.aaa();
        one.tt();

        Two two = oneTest;
        two.aaa();
        System.out.println(17>>1&-1);


    }
}
