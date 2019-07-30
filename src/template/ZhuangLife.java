package template;

//模板实现类 ，实现了 具体的工作
public class ZhuangLife extends DayLife {
    @Override
    public void getUp() {
        System.out.println("起床了");
    }

    @Override
    public void byBus() {
        System.out.println("坐公交");
    }

    @Override
    public void work() {
        System.out.println("工作");
    }

    @Override
    public void offDuty() {
        System.out.println("下班");
    }
}
