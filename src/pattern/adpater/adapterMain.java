package pattern.adpater;

public class adapterMain {
    public static void main(String[] args) {
        ExtendAdapter extendAdapter=new ExtendAdapter();
        extendAdapter.CircleSout("我是闯进来的");
        System.out.println("<<<<<<");
        ExtendAbsAdapter extendAbsAdapter=new ExtendAbsAdapter();
        extendAbsAdapter.CircleSout("第二餐");

        System.out.println(">>>>>>>>");
        Triangle triangle=new TrianCla();
        ObjYing objYing=new ObjYing(triangle);
        objYing.CircleSout("对象引用");

    }
}
