package pattern.adpater.Bridge;

import pattern.adpater.TrianCla;
import pattern.adpater.Triangle;

public class CirBridge extends CirceEx {

    public CirBridge(Triangle trianCla) {
        super(trianCla);
    }

    @Override
    public void CircleSout(String s) {
        System.out.println("因为抽象类虽然继承了接口但是没有实现我 ，所以具体类实现我了"+s);
    }
}
