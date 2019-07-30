package singleton;

//静态内部类  单例模式  饥汉
public class StaticSingleton {
    //私有化 构造方法
    private StaticSingleton() {
    }

    //私有的静态内部类  类加载器 复制加锁
    private static class SingletonHolder {
        private static StaticSingleton staticSingleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.staticSingleton;
    }

}
