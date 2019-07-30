package strategy;
//不同实现类
public class PriceOne implements Price {
    @Override
    public double discount() {
        return 0.8;
    }
}
