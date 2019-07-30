package Iterator;

import java.util.ArrayList;
import java.util.List;

public class IterataoClass<T> {
    //用于存储
    private List<T> list;
    //接口实例化
     private IteratorInner iteratorInner;
     //构造方法时候 就有一个默认的迭代器
     public IterataoClass(){
        iteratorInner=new IteratorInner();
         list = new ArrayList<>();
   }

    public void add(T t){
        list.add(t);
    }
   public void remove(int index){
       list.remove(index);
   }
   //返回迭代器接口 实例
    public IteratorTest<T> iterator(){
        return this.iteratorInner;
    }
    //内部的类
    private class IteratorInner implements IteratorTest<T>{
       int index;
        @Override
        public boolean hasNext() {
            if (index<list.size()){
                return true;
            }else {
                return false;
            }
        }

        @Override
        public T next() {
            return list.get(index++);
        }
    }
}
