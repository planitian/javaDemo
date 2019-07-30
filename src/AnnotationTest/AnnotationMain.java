package AnnotationTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@Name(name = "annotation")
public class AnnotationMain {

    @Name(name = "ziduan")
    static String name;

    @Name(name = "method")
    public static void main(String[] args) {

        boolean is = AnnotationMain.class.isAnnotationPresent(Name.class);
        if (true){
            Name na = AnnotationMain.class.getAnnotation(Name.class);
            System.out.println(na.name());
        }
        try {
            Field name = AnnotationMain.class.getDeclaredField("name");
            Name no = name.getAnnotation(Name.class);
            System.out.println(no.name());
            Method method = AnnotationMain.class.getDeclaredMethod("main", String[].class);
            System.out.println(method.getAnnotation(Name.class).name());
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        }


        Test test = new Test();
        Name i = test.getClass().getAnnotation(Name.class);
        System.out.println(test.getClass().getDeclaredAnnotations().length);

        try {
            Field one = test.getClass().getDeclaredField("one");
            Name ii = one.getAnnotation(Name.class);
            System.out.println(ii.name());
            System.out.println(Arrays.toString(test.getClass().getDeclaredFields()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
