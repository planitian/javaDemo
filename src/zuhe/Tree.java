package zuhe;

import java.util.ArrayList;
import java.util.List;

public class Tree implements Component {
    public List<Component> lists;

    public Tree() {
        this.lists = new ArrayList<>();
    }

    @Override
    public boolean isTree() {
        return true;
    }

    @Override
    public boolean isLeaf() {
      return false;
    }

    @Override
    public void outName() {
        System.out.println("我是树木");
    }

    @Override
    public void add(Component component) {
        System.out.println("添加前"+lists.size());
        lists.add(component);
        System.out.println("添加后"+lists.size());
    }

    @Override
    public void remote(int index) {
        System.out.println("index"+index+"    lists.size"+lists.size());
        lists.remove(index);
    }
}
