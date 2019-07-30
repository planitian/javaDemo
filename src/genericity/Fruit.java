package genericity;

public class Fruit {
    private String fruitName;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }
}
