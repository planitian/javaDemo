package observer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.List;
import java.util.Vector;

public class Test implements Observable {
    List<InvalidationListener> listeners = new Vector<>();
    @Override
    public void addListener(InvalidationListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listeners.remove(listener);
    }

    public void notifyall(){
        listeners.forEach(v->{
            v.invalidated(this);
        });
    }

}
