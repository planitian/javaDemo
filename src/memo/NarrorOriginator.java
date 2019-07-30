package memo;

public class NarrorOriginator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public NarrorInterface createMemento() {
        return new NarrorMemento(state);
    }

    public void restoreMemento(NarrorInterface narrorInterface) {
        this.state = ((NarrorMemento) narrorInterface).getState();
    }
  //内部类  这样其他类就不能获取到备忘录对象储存的值
    private class NarrorMemento implements NarrorInterface {
        private String state;

        public NarrorMemento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    @Override
    public String toString() {
        return "NarrorOriginator{" +
                "state='" + state + '\'' +
                '}';
    }
}
