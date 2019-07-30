package memo;

import java.util.LinkedList;
import java.util.List;

public class NarrorCareTasker {
    private List<NarrorInterface> narrorInterfaces = new LinkedList<>();

    public void saveMemento(NarrorInterface narrorInterface){
        narrorInterfaces.add(narrorInterface);
    }
    protected NarrorInterface getMemento(int index){
        return narrorInterfaces.get(index);
    }
}
