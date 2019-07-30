import bean.Emplo;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class createBean {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, IntrospectionException {
        Emplo emplo=new Emplo();

        Class emp=emplo.getClass();
        Emplo  emplo1= (Emplo) emp.newInstance();
        Emplo emplo2= (Emplo) emp.getConstructor().newInstance();
        Emplo emplo3=Emplo.class.newInstance();
        System.out.println(emplo1.toString()+">>"+emplo2.toString()+">>>"+emplo3.toString());
        Field name=emp.getDeclaredField("name");
        name.setAccessible(true);

        name.set(emplo2,"我是反射来得");
        System.out.println(name.getName()+name.get(emplo2));
        Method getName=emp.getMethod("getName", (Class<?>[]) null);

        Method setName=emp.getMethod("setName", String.class);
        System.out.println("setNamede mingzi"+setName.getName()+"   "+setName.getName().startsWith("set"));
        Method getAge=emp.getDeclaredMethod("getAge");

        setName.invoke(emplo1,"我是反射的方法修改的");
        String result= (String) getName.invoke(emplo1,  null);
        getAge.setAccessible(true);
        int age= (int) getAge.invoke(emplo1, null);
        System.out.println(emplo1.getName()+age);

//        PropertyDescriptor propertyDescriptor=new PropertyDescriptor("sex",emp);
//        Method getSex=propertyDescriptor.getReadMethod();
        String pro="get"+"Sex";
        Method getSex=emp.getMethod(pro,  null);
        System.out.println(getSex.toString());
        String sex= (String) getSex.invoke(emplo3, null);
        System.out.println(sex);

       StringBuilder stringBuilder=new StringBuilder();
       stringBuilder.append("hahha");
       stringBuilder.append("fffffffff");
       stringBuilder.append(5487);
        System.out.println(stringBuilder.toString());
        System.out.println((null==null));
    }
}
