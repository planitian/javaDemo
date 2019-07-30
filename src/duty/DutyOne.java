package duty;

public class DutyOne extends AbstractHander {
    public DutyOne(int level) {
        super(level);
    }

    @Override
    public void dispose() {
        System.out.println("我是one");
    }
}
