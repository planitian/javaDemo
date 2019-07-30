package one.food;

public interface Food {
    String name = "baying";

    void eat();

    static void take() {
        System.out.println(name);
    }
}
