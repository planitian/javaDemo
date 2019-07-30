package abstractTest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Son extends Father implements Ext {
    private String son = "我是子类的";

    public void outSon() {
        System.out.println("我是子类输出的");
    }

    @Override
    public void outFather() {
        super.outFather();
        System.out.println("我被子类重写了");
    }

    /**
     * @param content  要删除内容的数组
     * @param specific 删除的内容
     * @return  删除指定内容后的数组
     */
    public <T> T[] arraySpeDel(T[] content, T specific) {

        int len = content.length;
        for (int i = 0; i < content.length; i++) {
            if (content[i].equals(specific)) {
                System.arraycopy(content, i + 1, content, i, len - 1 - i);
                break;
            }
        }
        return Arrays.copyOf(content, len - 1);
    }

    /**
     * @param src 源数组
     * @param specific 动态参数
     * @param <T>
     * @return   返回源数组同等类型的数组
     */
    public <T> T[] arrayAdd(T[] src,T... specific) {
        //返回类的组件类型的数组。如果这个类并不代表一个数组类，此方法返回null。
        Class<?> type=src.getClass().getComponentType();
        T[] temp= (T[]) Array.newInstance(type,src.length+specific.length);
        System.arraycopy(src, 0, temp, 0, src.length);
        for (int i = 0; i <specific.length ; i++) {
            temp[src.length+i]=specific[i];
        }
        return  temp;
    }

    @Override
    public void extOut() {
        System.out.println("SON");
    }

    @Override
    public void baseOut() {
//        super.baseOut();
        System.out.println("SONchongxie");
    }
}
