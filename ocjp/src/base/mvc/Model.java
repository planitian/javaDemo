package base.mvc;

public class Model {
    String content = null;

    //读操作
    public String read() {
        System.out.println("成功 读取了数据");
        return this.content;
    }

    //写操作
    public void write(String content) {
        this.content = content;
        System.out.println("成功 写入了数据");
    }
}
