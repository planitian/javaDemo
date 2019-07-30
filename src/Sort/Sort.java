package Sort;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
//         //首先是数组排序
//        Comparable_Example[] comparable_examples=new Comparable_Example[10];
//        //随机数 随机生成0到100的int值
//        Random random=new Random();
//        for (int i = 0; i <10 ; i++) {
//              comparable_examples[i]=new Comparable_Example(random.nextInt(100));
//        }
//        //未排序前
//        System.out.println("排序前");
//        for (int i = 0; i <comparable_examples.length ; i++) {
//            System.out.println(comparable_examples[i].getNumber());
//        }
//        System.out.println("排序后");
//        Arrays.sort(comparable_examples);
//        for (int i = 0; i <comparable_examples.length ; i++) {
//            System.out.println(comparable_examples[i].getNumber());
//        }

//        //没有实现Comparable接口的类
//        Normal[] normals=new Normal[10];
//        for (int i = 0; i <10 ; i++) {
//            normals[i]=new Normal(random.nextInt(100));
//        }
//        Arrays.sort(normals);
//        for (int i = 0; i < normals.length; i++) {
//            System.out.println(normals[i].getNumber());
//
//        }

        List<Comparable_Example> comparable_exampleList=new ArrayList<Comparable_Example>();
        //随机数 随机生成0到100的int值
        Random random=new Random();
        for (int i = 0; i <10 ; i++) {
           comparable_exampleList.add(new Comparable_Example(random.nextInt(100)));
        }
        System.out.println("集合排序后");
        Collections.sort(comparable_exampleList);
         comparable_exampleList.forEach(e-> System.out.println(e.getNumber()));
    }
}
