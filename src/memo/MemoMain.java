package memo;

public class MemoMain {
    public static void main(String[] args) {
        WideOriginator wideOriginator = new WideOriginator();
        wideOriginator.setState("测试");
        WideCareTasker wideCareTasker = new WideCareTasker();
        //保持信息
        wideCareTasker.saveMemento(wideOriginator.createMemento());

        wideOriginator.setState("改变");
        System.out.println(wideOriginator.toString());
        //还原信息
        wideOriginator.restoreMemento(wideCareTasker.getWideMemento(0));
        System.out.println(wideOriginator.toString());


        //窄接口
        NarrorOriginator narrorOriginator = new NarrorOriginator();
        narrorOriginator.setState("我是窄接口");
        System.out.println(narrorOriginator.toString());

        NarrorCareTasker narrorCareTasker=new NarrorCareTasker();
        narrorCareTasker.saveMemento(narrorOriginator.createMemento());
        narrorOriginator.setState("我改变了");
        System.out.println(narrorOriginator.toString());

        narrorOriginator.restoreMemento(narrorCareTasker.getMemento(0));
        System.out.println(narrorOriginator.toString());
    }
}
