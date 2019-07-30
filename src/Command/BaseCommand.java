package Command;

//抽象的Command 命令类  持有Receiver的引用
public  abstract class BaseCommand {
    BaseReceiver baseReceiver;

    BaseCommand(BaseReceiver baseReceiver) {
        this.baseReceiver = baseReceiver;
    }
    //实现命令 ，调用receiver的方法 完成操作
    public abstract void execute();
}
