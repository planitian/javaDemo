package duty;

public class DutyThree extends AbstractHander {
    public DutyThree(int level) {
        super(level);
    }

    @Override
    public void dispose() {
        System.out.println("我是Three");
    }
}
