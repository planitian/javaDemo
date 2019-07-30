package genericity;

public class Apple extends Fruit {

    private String appleName;

    public Apple(String appleName) {
        super(appleName);
        this.appleName = appleName;
    }

    public String getAppleName() {

        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

}
