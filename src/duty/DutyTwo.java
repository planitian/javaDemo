package duty;

public class DutyTwo extends AbstractHander {
    public DutyTwo(int level) {
        super(level);
    }

    @Override
    public void dispose() {
        System.out.println("我是Two");
    }
}
