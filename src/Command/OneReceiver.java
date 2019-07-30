package Command;

public class OneReceiver implements BaseReceiver{
    @Override
    public void word() {
        System.out.println("我是具体的接受者，我做了具体的活");
    }
}
