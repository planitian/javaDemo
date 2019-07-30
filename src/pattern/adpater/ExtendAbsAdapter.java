package pattern.adpater;

public class ExtendAbsAdapter extends abstractExtend implements CIRCLE {



    @Override
    public void CircleSout(String s) {
        this.TraSout();
        System.out.println("我是抽象类继承的，的参数"+s);
    }
}
