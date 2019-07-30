package enumTest;

public class EnumMain {
    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            System.out.println(Danli.INSTANCE.getContent());
        }
    }
}
