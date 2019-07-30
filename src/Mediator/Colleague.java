package Mediator;

//同事类抽象类
public abstract class Colleague {
    protected AbsMediator absMediator;
    //构造方法持有一个中介者的引用，用setter方法会有忘记调用的可能性
    public Colleague(AbsMediator absMediator) {
        this.absMediator = absMediator;
    }

    //得到消息
    abstract void getMessage(String message);
    //发送信息
    abstract void sendMessage(String message);
}
