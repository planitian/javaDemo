package Mediator;

public class ColleagueA extends Colleague {

    public ColleagueA(AbsMediator absMediator) {
        //调用父类的构造方法
        super(absMediator);
    }

    //得到消息时候的刷新
    @Override
    public void getMessage(String message) {
        System.out.println("A 同事类 接收消息  ："+message);
    }
    //发送的时候 通过中介者的方法 发送数据，这里调用父类的成员
    @Override
    public void sendMessage(String message) {
        absMediator.contact(message,this);
    }
}
