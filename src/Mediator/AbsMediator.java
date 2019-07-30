package Mediator;

//中介者接口
public interface AbsMediator {

    //这个方法是 同事类调用的 用于和其他同事类进行通讯
    void contact(String message, Colleague coll);
}
