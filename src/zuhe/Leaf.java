package zuhe;

public class Leaf implements Component {
    @Override
    public boolean isTree() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public void outName() {
        System.out.println("我是叶子");
    }


    @Override
    public void add(Component component) {
         throw new RuntimeException("不合法的调用");
    }

    @Override
    public void remote(int index) {
        throw new RuntimeException("不合法的调用");
    }
}
