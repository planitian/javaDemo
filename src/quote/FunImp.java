package quote;

public class FunImp implements FunTest {
    public FunTest funTest;
    public FunImp(FunTest funTest) {
        this.funTest=funTest;
    }

    @Override
    public void jiSuan(Car car) {
        System.out.println("shili"+car.fanhui("hanshu"));
    }
}
