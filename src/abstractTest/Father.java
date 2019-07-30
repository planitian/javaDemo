package abstractTest;

public abstract class Father implements Base {
    private String father="我是父类";
    public  String ss="woshigong";
    public void outFather(){
        System.out.println("父类无参数，无返回 公有");
    }

    public String outFanhui(String ss){
        return  ss+"父类加的东西";
    }

    @Override
    public void baseOut() {
        System.out.println("Father");
    }
}
