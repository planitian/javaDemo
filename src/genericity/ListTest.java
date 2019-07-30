package genericity;

public class ListTest<T extends String> {
    private T t;

    public ListTest(T t) {
        this.t = t;
    }
    public void showTest(){
        System.out.println(t.toString());
    }
}
