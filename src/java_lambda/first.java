package java_lambda;

import java.util.function.Supplier;

public class first {
    public static void main(String[] args) {
//        System.out.println("我出来了");
//        Supplier<Test> chiyo=Test::new;
//        chiyo.get();
//        String sss = "ssss";
//       Lam lam=() -> System.out.println(sss);
//       lam.bda();
//       lam.bda("tttt");
//        Test test = new Test();
//        String ff = "aaaa";
//        test.output(() -> {
//            System.out.println(ff);
//        });
//        test.output(new Lamimp() {
//            @Override
//            public void bda() {
//                System.out.println("我可以更改");
//            }
//        });
        String lam = "初次相识Lambda";
        new Thread(() -> System.out.println(lam)).start();
        String tradition = "传统方法";
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(tradition);
            }
        }).start();

//        Lamimp lamimp=()->System.out.println(lam);

        //接口定义的方法无参数时候，并且你想要执行操作也只有一句代码的时候
//        Lam lam1=()->System.out.println("无参数");
        //接口定义的方法有参数时候，并且你想要执行的操作也只有一句代码的时候
//        Lam lam1=(e)->System.out.println(e);//这一句还有简化版本  Lam lam1=System.out::println;
//        lam1.bda("4556");
        //接口定义的方法有参数时候，并且你想要执行的操作有很多句代码的时候
//        Lam lam1 = (String e) -> {
//            String a = e + "add";
//            System.out.println(a);
//        };
//        lam1.bda("test+");
//         AbstractLam abstractLam=()->System.out.println("ss");
       //接口定义的方法有返回值的时候
        Lam lam1=s ->{System.out.println(s);return "我是返回的数据";};
        lam1.bda("test1");
        System.out.println(lam1.bda("test2"));
    }
}
