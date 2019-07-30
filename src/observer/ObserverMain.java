package observer;

public class ObserverMain {
    public static void main(String[] args) {
        //面向接口 接口实例化   生成被观察者      被观察者 也可以有很多不同的实现类
        Observable observable = new ObserveableImp();

        //这是 用抽象类 实现的  被观察者

        ObservableA observableA = new AbstraOberimp();
        //生成 不同类型的观察者   观察者 也可以有很多实现类
        ObserverImp observeableImp = new ObserverImp();
        ObserverOne observerOne = new ObserverOne();

        //接口 被观察者 添加 观察者
        observable.addObserver(observerOne);
        observable.addObserver(observeableImp);

        //抽象类被观察者 添加
        observableA.addObserver(observeableImp);
        observableA.addObserver(observerOne);

        //接口被观察者 通知 观察者
        observable.notifyMessage();

        ///抽象类 观察者  通知 观察者
        observableA.notifyText();
        System.out.println("观察者 取消 观察");
        //观察者 取消 观察
        observable.removeObserver(observerOne);
        observable.notifyMessage();



        ///内置的
        InlayObservable inlayObservable=new InlayObservable();
        InlayObsever inlayObsever=new InlayObsever();
        inlayObservable.addObserver(inlayObsever);
        inlayObservable.setInner("我是内置的");
    }
}
