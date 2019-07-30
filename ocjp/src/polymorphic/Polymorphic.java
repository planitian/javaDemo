package polymorphic;

public class Polymorphic {
    public static void main(String[] args) {
        One one = new Two();
        System.out.println(one.name);
        one.out();

        Test test = new Three();
        ((Three) test).out();

        System.out.println("xor "+((2<3)^(4>3)));

        boolean t = true;
        boolean f = false;
        System.out.println("!" + (t & !f) + " " + f);
        System.out.println((true&false==false|true)+" ");
        System.out.println(((true&false)==(false|true)));
    }
}

class One{
    String name = "one";

    void out(){
        System.out.println(name);
    }
}

class Two extends One{
    String name = "two";
    void out(){
        System.out.println(name);
    }
}
 interface Test{
    static void out(){
        System.out.println("静态的 接口方法");
    }
}

class Three implements Test{
    void out(){
        System.out.println(" three的方法");
    }
}
interface I1{
    default int doStuff(){
        return 1;
    }
}

interface I2{
    default int doStuff(){
        return 2;
    }
}

class Mu implements I1,I2{
    public static void main(String[] args) {
        Mu mu = new Mu();
        System.out.println(mu.doStuff());
    }

  public int doStuff(){
      return 3;
  }
}