package observer;

import java.util.Observable;

//内置被观察者 实现类
public class InlayObservable extends Observable {
    private String inner;
    public String getInner() {
        return inner;
    }
    public void setInner(String inner) {
        this.inner = inner;
        setChanged();
        notifyObservers(this.inner);
    }
}
