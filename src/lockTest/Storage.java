package lockTest;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static int value = 1;
    private int anInt;

    private List<Integer> integers = new ArrayList<>();

    public Storage(int anInt) {
        this.anInt = anInt;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }


}
