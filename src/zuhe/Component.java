package zuhe;

public interface Component {
    boolean isTree();

    boolean isLeaf();

    void outName();

    void add(Component component);

    void remote(int index);

}
