package memo;

import java.util.List;
import java.util.Vector;

//负责人 就是 保持备忘录对象的类
public class WideCareTasker {
    private List<WideMemento> wideMementoList = new Vector<>();

    public void saveMemento(WideMemento wideMemento) {
        wideMementoList.add(wideMemento);
    }

    public WideMemento getWideMemento(int index) {
        if (index > wideMementoList.size()) {
            throw new RuntimeException("数据越界");
        } else {
            return wideMementoList.get(index);
        }
    }
}
