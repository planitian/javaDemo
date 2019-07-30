package java_lambda;
@FunctionalInterface
public interface Lam {
    //Lambda表达式调用的方法
    String bda(String s);

    //接口的默认方法
    default void test(){
        System.out.println("我是默认的方法");
    };
    //接口的静态方法
    static void test1(){
        System.out.println("我是静态方法");
    }
}
