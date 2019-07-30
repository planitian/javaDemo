package observer;


//被观察者
public interface Observable {
    //添加观察者方法
    void addObserver(Observer observer);
     //删除观察者方法
    void removeObserver(Observer observer);
    //通知 观察者
    void notifyMessage();
}
