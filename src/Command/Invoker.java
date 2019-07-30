package Command;
//调用者 持有一个命令角色的引用  这个类 并不是必须的  直接调用命令角色 也可以完成功能
public class Invoker {
    private BaseCommand baseCommand;

    public BaseCommand getBaseCommand() {
        return baseCommand;
    }
    //之所以用setter方法 而不用构造方法  我感觉这样 耦合程度更低
    public void setBaseCommand(BaseCommand baseCommand) {
        this.baseCommand = baseCommand;
    }

    //调用命令者的执行方法
    public void action(){
        this.baseCommand.execute();
    }
}
