package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyDongTai implements InvocationHandler {
    private Object object;

    public ProxyDongTai(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是动态代理前面");
        Object result = method.invoke(object, args);
        System.out.println("我是动态代理的后面");
        return null;
    }
}
