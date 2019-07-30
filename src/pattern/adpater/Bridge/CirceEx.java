package pattern.adpater.Bridge;

import pattern.adpater.CIRCLE;
import pattern.adpater.TrianCla;
import pattern.adpater.Triangle;


//这是一个融合类，同时有Triangle 的应用 和实现了 目标接口
public  abstract class CirceEx implements CIRCLE {
    private Triangle trianCla; //这里接口或者几类  反正不要是具体的实现类

    public CirceEx(Triangle trianCla) {
        this.trianCla = trianCla;
    }
    //这里也可在CIRCLE的方法里面写，但这样感觉逻辑上不太通顺
    //这里定义一个方法 作为两个接口的融合，这同时引出另一种思路，也可不对Triangle进行引用，可以同时继承
    public void  fuse(String s){
        System.out.println("融合类的操作"+s);
        this.trianCla.TraSout();
        System.out.println("融合类的操作"+s);
    }
}
