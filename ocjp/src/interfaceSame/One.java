package interfaceSame;

public interface One {

    void aaa();
     default void tt(){
        System.out.println("hhah");
    }
}
