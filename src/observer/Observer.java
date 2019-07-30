package observer;

//观察者
public interface Observer {
    //观察者 接受被观察者传来的信息
    void receiverText(String text);
}
