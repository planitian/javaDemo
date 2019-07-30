package AnnotationTest;

public class Test {
    @Name(name = "1")
    String one;

    @Name(name = "2")
    String two;

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }
}
