package flyweight;

public class GoodsImp implements Good {
    //外部状态变量
    private String name;
    //内部状态变量  不受外面干扰
    private String price;

    public GoodsImp(String name) {
        this.name = name;

    }

    @Override
    public void showPrcie() {
        switch (name) {
            case "one":
                System.out.println("价格一百");
                break;
            case "two":
                System.out.println("价格二百");
                break;
            case "three":
                System.out.println("价格三百");
                break;
            default:
                System.out.println("无此类");
                break;
        }
    }

    @Override
    public void showName() {
        System.out.println("Good Name" + name);
    }
}
