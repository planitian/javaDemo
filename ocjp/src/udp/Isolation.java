package udp;

public class Isolation {
    private String name;//无关Field ，可以直接忽略这个

    private Isolation other;//相互引用

    public Isolation(String name, Isolation other) {
        this.name = name;
        this.other = other;
    }
}
