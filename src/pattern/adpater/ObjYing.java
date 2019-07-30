package pattern.adpater;

public class ObjYing implements CIRCLE {
    private Triangle triangle;

    public ObjYing(Triangle triangle) {
        this.triangle = triangle;
    }
    @Override
    public void CircleSout(String s) {
          triangle.TraSout();
        System.out.println("我是对象引用的参数"+s);
    }
}
