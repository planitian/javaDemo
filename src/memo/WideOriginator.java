package memo;

//宽 发起人  就是实际应用中要保持的对象
public class WideOriginator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //产生备忘录对象  将当前信息传入备忘录对象
    public WideMemento createMemento() {
        return new WideMemento(this.state);
    }

    //还原备忘录对象   取出其中的信息
    public void restoreMemento(WideMemento memento) {
        this.state = memento.getState();
    }

    @Override
    public String toString() {
        return "WideOriginator{" +
                "state='" + state + '\'' +
                '}';
    }
}
