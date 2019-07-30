package observer;

import java.util.ArrayList;
import java.util.List;

//接口被观察者 实现类
public class ObserveableImp implements Observable {
    //内部构造一个集合 管理 观察者
    private List<Observer> lists;

    public ObserveableImp() {
        this.lists = new ArrayList<>();//默认容量为10
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer != null) {
            lists.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer != null) {
            lists.remove(observer);
        }
    }

    @Override
    public void notifyMessage() {
        //发送信息
        lists.forEach(observer -> observer.receiverText("接口 被观察者发送的"));
    }
}
