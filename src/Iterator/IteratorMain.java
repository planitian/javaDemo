package Iterator;

import java.util.Iterator;

public class IteratorMain {
    public static void main(String[] args) {
        IterataoClass<String> collection = new IterataoClass<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        collection.add("four");
        IteratorTest iteratorInner= collection.iterator();
        while (iteratorInner.hasNext()){
            System.out.println(iteratorInner.next().toString());
        }

        System.out.println(">>>>>>>>>>>>>>>");

        InlayIterable<String> inlayIterable=new InlayIterable<String>();
        inlayIterable.add("one");
        inlayIterable.add("two");
        inlayIterable.add("three");

        Iterator<String> iterator=inlayIterable.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
