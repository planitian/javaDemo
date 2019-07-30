package observer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class TextInvalidationListenter implements InvalidationListener {
    @Override
    public void invalidated(Observable observable) {
        System.out.println("就这个作用？" +
                "");
    }
}
