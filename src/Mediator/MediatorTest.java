package Mediator;

public class MediatorTest {
    public static void main(String[] args) {
        MediatorMain mediatorMain = new MediatorMain();
        Colleague a = new ColleagueA(mediatorMain);
        Colleague b = new ColleagueB(mediatorMain);

        mediatorMain.addColleague(a);
        mediatorMain.addColleague(b);

        a.sendMessage("我是a  我改变了");

        b.sendMessage("我是b ，我改变了");

    }
}
