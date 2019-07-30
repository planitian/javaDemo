package Command;

public class CommandMain {
    public static void main(String[] args) {
        //创建调用类
        Invoker invoker = new Invoker();
        //创建接受者类
        BaseReceiver receiver = new OneReceiver();
        //创建命令类
        BaseCommand command=new OneCommand(receiver);
        //调用者 设定命令类
        invoker.setBaseCommand(command);
        //执行方法
        invoker.action();
    }
}
