package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InlayIterable<T> implements Iterable<T> {
    //存储数据
    private List<T> lists;
    private Iterator iterator;

    public InlayIterable() {
        this.lists = new ArrayList<>();
        iterator = new InlayIterator();
    }

    public void add(T t){
        lists.add(t);
    }

    public void remove(int index){
        lists.remove(index);
    }

    @Override
    public Iterator<T> iterator() {
        return iterator;
    }

    class InlayIterator implements Iterator<T>{
           int index;
        @Override
        public boolean hasNext() {
            if (index<lists.size()){
                return true;
            }else {
                return false;
            }
        }

        @Override
        public T next() {
            return lists.get(index++);
        }

    }
}
