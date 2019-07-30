package strategy;

public class Content {
    private Price price;

    public Content(Price price) {
        this.price = price;
    }

    void outPrice(Double price) {
        System.out.println("折扣后的价格" + this.price.discount() * price);
    }
}
