package test;

public class Zhi {
    int a = 3;

    public static void main(String[] args) {
    /*    Zhi zhi = new Zhi();
             zhi.doInt(zhi);
        System.out.println(zhi.hashCode());*/

       /* for (int i = 0, y = 1;(y < 10) & (i > -10); y++, i--, System.out.println("one"), System.out.println("two")) {
            System.out.println("符合条件");
        }*/

     /*   outer:
        for (int i = 0; i < 10; i++) {
            int y = 0;
            inner:
            while (y < 10) {
                y++;
                if (y == 5) {
                    System.out.println("内部");
                    break outer;
                }
                System.out.println("y加一");
            }
        }*/

    }

    void doInt(Zhi zhi) {
        zhi = new Zhi();
        System.out.println(zhi.hashCode());
    }

    void nullThre() throws Exception{
        String s = null;
        s.length();
    }
}

