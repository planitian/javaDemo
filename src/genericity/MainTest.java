package genericity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainTest {
    public static   void main(String[] args) {
//        ListTest<String> tt=new ListTest<String>("sss");
//        tt.showTest();


        List<? extends Fruit> fruits=new ArrayList<Apple>((Collection<? extends Apple>) new Apple("我是子类的名字"));
        Fruit fruit=fruits.get(0);

    }
}
