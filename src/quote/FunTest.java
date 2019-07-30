package quote;
@FunctionalInterface
public interface FunTest {
    default void def(){
        System.out.println("我是默认方法");
    }

    void jiSuan(Car car);
    static void sta(Car text){
        System.out.println("我是静态的"+text);
    }
}
