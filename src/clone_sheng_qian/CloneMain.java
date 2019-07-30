package clone_sheng_qian;

import java.util.ArrayList;
import java.util.List;

public class CloneMain {
    public static void main(String[] args) throws CloneNotSupportedException {

        CloneTest cloneTest = new CloneTest.Builder(18).name("庄飞虎").lists(new ArrayList<String>() {{
            add("one");
            add("two");
        }}).Build();
        System.out.println(cloneTest.hashCode());
        CloneTest two = cloneTest.clone();
        System.out.println(two.hashCode());
        System.out.println((cloneTest.hashCode()==two.hashCode()));
        two.lists.add("third");
        System.out.println(cloneTest.toString());
        System.out.println(two.toString());

    }
}
