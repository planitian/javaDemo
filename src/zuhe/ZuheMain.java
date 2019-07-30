package zuhe;

import build.Person;

import java.util.HashMap;
import java.util.Map;

public class ZuheMain {
    public static void main(String[] args) {
        Tree treeOne=new Tree();
        for (int i = 0; i <10; i++) {
            treeOne.add(new Leaf());
            System.out.println(i);
        }
        System.out.println(">>>>>>>>>");
        for (int i = 9; i >-1 ; i--) {
            treeOne.isLeaf();
            treeOne.outName();
            treeOne.remote(i);
            System.out.println(i);
        }

        Map<String, String> maps = new HashMap<>();
        String result = maps.get("ss");
        System.out.println((result==null));

        Person person = new Person.Builder(11, "ss").age(18).address("ss").build();
    }
}
