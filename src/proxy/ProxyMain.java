package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyMain {
    public static void main(String[] args) {
        Soure realizeSoure = new RealizeSoure();
        ProxySoure proxySoure = new ProxySoure((RealizeSoure) realizeSoure);
        proxySoure.base();
        proxySoure.one();
        System.out.println(">>>>>>>>>>>>>>>>>>>");
//        Soure realizeSoure1= (Soure) Proxy.newProxyInstance(realizeSoure.getClass().getClassLoader(),realizeSoure.getClass().getInterfaces(),new ProxyDongTai(realizeSoure));
        Soure realizeSoure1 = (Soure) Proxy.newProxyInstance(realizeSoure.getClass().getClassLoader(), new Class[]{Soure.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("内置的");
                Object result = method.invoke(realizeSoure, args);

                return result;
            }
        });
        realizeSoure1.one();
        realizeSoure1.base();
    }
}
