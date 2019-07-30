package base.mvc;

public class MvcMain {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.writeData();
        System.out.println("  ");
        controller.outData();
    }
}
