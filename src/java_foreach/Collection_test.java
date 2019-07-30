package java_foreach;

import java_lambda.Lam;
import java_lambda.Lamimp;

import java.lang.reflect.Array;
import java.util.*;

public class Collection_test {

    public static void main(String[] args) {
////        ArrayList<Test> lists=new ArrayList<>();
////        Test[] lists=new Test[]{new Test(1),new Test(3),new Test(2)};
//        Test[] lists=new Test[10];
//        List<Test> collection=new ArrayList<>();
//        for (int i = 0; i <10 ; i++) {
////            int temp=10-i;
////            System.out.println(" hhh"+temp);
////        Test test=new Test(10-i);
//            test1 test=new test1(10-i);
//           collection.add(test);
//            System.out.println(test.getShuzhi());
//        }
//        Collections.sort(collection);
//        collection.forEach((e)-> System.out.println(e.getShuzhi()));
////        for (int i = 9; i <=0 ; i--) {
////            Test  test=new Test(i);
////            test.setShuzhi(i);
////            System.out.println(test.getShuzhi());
////
////             lists[i]=test;
////            System.out.println(test.getShuzhi());
////        }
////        Arrays.sort(lists);
////        for (Test t:lists
////             ) {
////            System.out.println(t.getShuzhi());
////        }

        List<Com> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Com com = new Com(10 - i);
            lists.add(com);
        }
        Collections.sort(lists, Comparator.comparing(Com::output));
        lists.forEach(e -> System.out.println(e.output()));


        List<String> two = new ArrayList<String>() {
        };
        ArrayList<String> list = new ArrayList<String>() {{
            add("str01");
            add("str02");
        }};
        for (Iterator i=list.iterator();i.hasNext();){
            System.out.println(i.next());
        }
    }
}
