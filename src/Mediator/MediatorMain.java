package Mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MediatorMain implements AbsMediator {
    //中介者要持有 不同同事类的引用 才可以通知他们改变信息
    private ColleagueA colleagueA;
    private ColleagueB colleagueB;

    //用list集合持有同事类的引用 这样的好处是，少了好多 setter方法
    private List<Colleague> colleagues;

    public MediatorMain() {
        this.colleagues = new ArrayList<>();
    }

    // 添加同事类
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    //如果不通过list集合持有同事类的引用 ，就用这种方法
    public void setColleagueA(ColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    @Override
    public void contact(String message, Colleague coll) {
        //这是 是我优化的 ，这样 不用上面分别有同事类的引用
        colleagues.forEach(colleague -> {
            if (!(colleague.getClass().getCanonicalName().equals(coll.getClass().getCanonicalName()))) {
                colleague.getMessage(message);
            }
        });
        //第二种方法
       /* if (coll instanceof ColleagueA){
            colleagueB.getMessage(message);
        }*/
    }
}
