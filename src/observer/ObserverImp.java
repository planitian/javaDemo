package observer;

//观察者 实现类
public class ObserverImp implements Observer {
    @Override
    public void receiverText(String text) {
        //接受到信息后的具体操作方法
        System.out.println(this.getClass().getSimpleName()+" "+text);
    }
}
