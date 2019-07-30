package proxy;

public class RealizeSoure implements Soure {
    @Override
    public void base() {
        System.out.println("我是 base");
    }

    @Override
    public void one() {
        System.out.println("我是one");
    }
}
