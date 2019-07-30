package quote;

public class Car {

    public void jingtai() {
        System.out.println("我是静态的");

    }

    public void normal(String text){
        System.out.println("普通的"+text);

    }

    public String fanhui(String text){
        System.out.println("我是有返回的"+text);
        return text;
    }
}
