package pattern.adpater;

public class ExtendAdapter extends TrianCla implements CIRCLE{


    @Override
    public void CircleSout(String s) {
        this.TraSout();
        System.out.println("适配器输出的参数"+s);
    }
}
