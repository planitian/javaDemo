package base.mvc;

public class Controller {
    private Model model;//model 引用
    private View view;//view引用

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    //从model 里面输出 数据
    public void outData() {
        this.view.out(this.model.read());
    }

    //往model里面 写入 数据
    public void writeData() {
        this.model.write(this.view.get());
    }
}
