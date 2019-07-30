import bean.Emplo;

import java.lang.ref.WeakReference;

public class Weak {
    public static void main(String[] args) {

       /* WeakReference<String> first=new WeakReference<>("first");
        WeakReference<String> two=first;
        System.out.println(two.get().toString());*/

        Emplo one=new Emplo();
        one.setName("巴莹");
        one.setSex("女");

        System.out.println("1   "+one.toString()+one.hashCode());


        Emplo two=new Emplo();
        two.setName("庄飞虎");
        two.setSex("男");
        System.out.println("2     "+two.toString());

//        change(one);
//        System.out.println("2     "+one.toString());

        Change change = new Change();
        int a = change.add(one);
        int b = change.add(two);

        change.changeInfo(a);
        new Thread(()->{
            one.setSex("男");
        }).start();

        System.out.println("1     "+one.toString());

        System.out.println("1  " + (change.emplos.get(a) == one));
        System.out.println("2  "+change.emplos.get(b).hashCode());


        String baying = "巴莹";
        System.out.println(baying);
        System.out.println("巴莹");
    }


    public static void change(Emplo emplo){
        emplo.setSex("男");
    }
}
