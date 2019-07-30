package strategy;

public class StrategyMain {
    public static void main(String[] args) {
        Price one=new PriceOne();
        Price two=new PriceTwo();
        Price three=new PriceThree();
        Content content = new Content(one);
        content.outPrice(22.1);
        Content content1 = new Content(two);
        content1.outPrice(22.1);
    }
}
