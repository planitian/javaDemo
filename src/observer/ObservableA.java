package observer;

import java.util.ArrayList;
import java.util.List;

public  abstract class ObservableA {

    //不能定义成private  否则 子类获取不到
    protected List<Observer> lists;

    ObservableA() {
        this.lists = new ArrayList<>();
    }

    abstract void addObserver(Observer observer);

    abstract void removeObserver(Observer observer);

    abstract void notifyText();
}
