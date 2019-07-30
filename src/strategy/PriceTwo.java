package strategy;

//不同实现类
public class PriceTwo implements Price {
    @Override
    public double discount() {
        return 0.7;
    }
}
