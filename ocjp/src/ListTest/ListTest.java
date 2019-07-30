package ListTest;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        Spliterator<String> stringSpliterator = list.spliterator();
        stringSpliterator.forEachRemaining(s -> System.out.println(s));
        System.out.println(">>>>>");
        stringSpliterator.tryAdvance(s -> System.out.println(s));


        String[] y = list.toArray(new String[0]);
        /*Object v = null;
        System.out.println(v.toString());*/
        System.out.println("(ListTest.java:23)");

    }



   static class OneList{
        private String name;

        OneList(String name) {
            this.name = name;
        }
    }
}
