package flyweight;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FlyWeight {
    public static void main(String[] args) {
        Good one = FlyWeightFactory.getGood("one");
        Good two = FlyWeightFactory.getGood("two");
        Good three = FlyWeightFactory.getGood("three");

        Good temp = FlyWeightFactory.getGood("one");
        one.showPrcie();
        two.showPrcie();
        three.showPrcie();
        temp.showPrcie();
        System.out.println((one == temp));


        List<String> tt = new LinkedList<>();
        tt.add("one");
        tt.add("two");
        tt.add("three");
        System.out.println("size"+tt.size());

        tt.remove("one");
        System.out.println("size"+tt.size());

        Set<String> gg = new HashSet<>();
        gg.add("one");
        gg.add("two");
        gg.add("one");
       gg.forEach(System.out::println);
    }
}
