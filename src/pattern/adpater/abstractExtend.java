package pattern.adpater;

public abstract  class  abstractExtend implements Triangle {

    @Override
    public void TraSout() {
        System.out.println("我是继承调用，在这里写具体方法");
    }
}
