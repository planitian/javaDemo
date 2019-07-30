package observer;

//观察者实现类
public class ObserverOne implements Observer {
    @Override
    public void receiverText(String text) {
        System.out.println(this.getClass().getSimpleName()+"  "+text);
    }
}
