package duty;

public abstract class AbstractHander {
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    //确定自己级别  要不然会整个链表都会调用的
    private int level;
    //持有自身同一类型的  链中的下一个对象
    private AbstractHander abstractHander;

    //提供方法 设置下一个对象
    public void setAbstractHander(AbstractHander abstractHander) {
        this.abstractHander = abstractHander;
    }

    public AbstractHander(int level) {
        this.level = level;
    }

    //根据级别 确定哪一级调用
    public void grading(int level){
       if (this.level>=level){
           dispose();
       }else if(this.abstractHander!=null){
           this.abstractHander.grading(level);
       }
    }
    //做处理的方法  每个子类都不同
    public abstract void dispose();
}
