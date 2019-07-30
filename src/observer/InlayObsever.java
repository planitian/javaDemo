package observer;

import java.util.Observable;
import java.util.Observer;

public class InlayObsever implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o.getClass().getSimpleName()+"  "+arg);
    }
}
