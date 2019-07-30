package memo;

//宽 备忘录对象
public class WideMemento {
    private String state;

    public WideMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
