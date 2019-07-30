package pattern.adpater.Bridge;

import pattern.adpater.TrianCla;
import pattern.adpater.Triangle;

public class BridgeMain {
    public static void main(String[] args) {
        Triangle triangle=new TrianCla();
        CirBridge cirBridge=new CirBridge(triangle);
        cirBridge.CircleSout("我是桥接模式的参数");
        cirBridge.fuse("qiaojie");
    }
}
