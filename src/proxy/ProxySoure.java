package proxy;

public class ProxySoure implements Soure {
    private RealizeSoure realizeSoure;

    public ProxySoure(RealizeSoure realizeSoure) {
        this.realizeSoure = realizeSoure;
    }

    @Override
    public void base() {
        System.out.println("在前面");
        realizeSoure.base();
        System.out.println("我在后面");
    }

    @Override
    public void one() {
        System.out.println("在前面");
        realizeSoure.one();
        System.out.println("我在后面");
    }
}
