package observer;

//抽象类被观察者 子类
public class AbstraOberimp extends ObservableA {
    @Override
    void addObserver(Observer observer) {
        this.lists.add(observer);
    }

    @Override
    void removeObserver(Observer observer) {
        this.lists.remove(observer);
    }

    @Override
    void notifyText() {
        lists.forEach(observer -> System.out.println("我是被观察者 抽象类发来的"));
    }
}
