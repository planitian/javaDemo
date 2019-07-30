package base.mvc;

public class View {
    //输出数据
    void out(String content) {
        System.out.println("view 输出 " + content);
    }

    //获取数据
    String get() {
        System.out.println("view  返回数据");
        return "view 返回的数据";
    }
}
