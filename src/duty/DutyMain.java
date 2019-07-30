package duty;

import build.WorkBuilder;

public  class DutyMain {
    public static void main(String[] args) {
        AbstractHander one=new DutyOne(1);
        AbstractHander two=new DutyTwo(2);
        AbstractHander three=new DutyThree(3);
        //设置下一个链表元素
        one.setAbstractHander(two);
        two.setAbstractHander(three);
        one.grading(2);

    }
}
