package singleton;

//双重锁定的 懒汉  单例模式
public class Singleton {
    private static volatile Singleton singleton;

    //将构造方法私有化
    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            //Singleton.class 是唯一的  一把锁，所以确保 同一时刻只有一个线程进入

            synchronized (Singleton.class) {
                //当前线程 释放锁后，其他等待线程进入 再判断
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
