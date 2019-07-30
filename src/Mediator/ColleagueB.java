package Mediator;

public class ColleagueB extends Colleague {
    public ColleagueB(AbsMediator absMediator) {
        super(absMediator);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("B 同事类接收消息 :"+message);
    }

    @Override
    public void sendMessage(String message) {
        absMediator.contact(message,this);
    }
}
