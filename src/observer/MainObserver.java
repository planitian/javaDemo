package observer;

public class MainObserver {
    public static void main(String[] args) {
        Test test=new Test();
        TextInvalidationListenter textInvalidationListenter = new TextInvalidationListenter();
        TextInvalidationListenter textInvalidationListenter1 = new TextInvalidationListenter();
        test.addListener(textInvalidationListenter);
        test.addListener(textInvalidationListenter1);
        test.notifyall();

    }
}
