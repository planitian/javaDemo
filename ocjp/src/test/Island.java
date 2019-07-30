package test;

import udp.Isolation;

import java.lang.ref.SoftReference;

public class Island {
    Island i;//强引用其他对象

    public static void main(String[] args) {
        Island i2 = new Island();
        Island i3 = new Island();
        Island i4 = new Island();

        i2.i = i3;//i2引用i3
        i3.i = i4;//i3引用i4
        i4.i = i2;//i4引用i2

        i2 = null;
        i3 = null;
        i4 = null;

        //这时候 就是隔离岛
        // 尽管 i2，i3，i4都被强引用了，但是线程已经无法访问到他们了
        // i2 i3 i4 都可以被回收

        //声明一个strong类的对象 strong，并且开辟一个内存空间（就叫one） 和strong联系起来
        // strong对象和one内存空间  的关系就是 strongly-reachable 强可达
        Island strong = new Island();

        //声明一个软引用对象soft，软引用的值是strong。
        //soft对象和one内存空间  的关系就是  softly-reachable 软可达
        SoftReference<Island> soft = new SoftReference<>(strong);
    }
}
