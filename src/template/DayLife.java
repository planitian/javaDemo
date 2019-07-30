package template;

//模板抽象类 定义了 逻辑顺序
public abstract class DayLife {
    //final  让子类没法重写 这个方法 保证逻辑的正确
    final void oneDay(){
        getUp();
        byBus();
        work();
        offDuty();
    }
    /*抽象方法 子类继承*/
    protected abstract void getUp();

    public abstract void byBus();

    public abstract void work();

    public abstract void offDuty();

}
