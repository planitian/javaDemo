package Iterator;

//自定义的
public interface IteratorTest<T>{
    //有误下一个
    boolean hasNext();
    //下一个
    T next();
}
