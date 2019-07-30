import test.Island;
import udp.Isolation;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WeakTest<T> extends WeakReference<T> {
    private String inner;

    public WeakTest(T referent, String inner) {
        super(referent);
        this.inner = inner;
    }

    public String getInner() {
        return inner;
    }

    public void setInner(String inner) {
        this.inner = inner;
    }

    public static void main(String[] args) {
        //生成引用队列
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        String strong = "Strong";
        WeakReference<String> weakReference = new WeakReference<>(null,referenceQueue);

        weakReference.enqueue();
        System.out.println("队列里面是否有数据 "+referenceQueue.poll().get());
        ///清除该引用对象，就是 弱引用对象 不再持有 引用对象的引用
        weakReference.clear();
        System.out.println("弱引用对象 是否持有 引用对象 " + weakReference.get());
        System.out.println("strong  是否被回收  " + strong);


        //创建软引用对象
        SoftReference<String> stringSoftReference = new SoftReference<>("123", referenceQueue);
        //由于不好模拟出内存耗尽，软引用回收 ，到内存耗尽，就爆了异常，还没输出日志，jvm就挂了，，， 所以调用这个方法也是一样的效果。
        // 模拟GC，将软引用对象添加到队列
        stringSoftReference.enqueue();
        System.out.println("队列里面是否有数据 " + referenceQueue.poll().get());
        //模拟GC，将软引用对象回收（其实是软引用对象内部的referent内存空间回收）
        stringSoftReference.clear();
        System.out.println("软引用对象 是否  持有 引用对象" + stringSoftReference.get());


        Island one;//声明一个Island类，此时 只是声明，没有实例
        one = new Island();//开辟一个内存空间，并将内存空间和one 建立强引用

        ReferenceQueue<String> phantomQueue = new ReferenceQueue<>();
        PhantomReference<String> stringPhantomReference = new PhantomReference<>("456", phantomQueue);
        //入列
        stringPhantomReference.enqueue();
        System.out.println(phantomQueue.poll()==null);

        System.out.println(" "+null);
    }
}
