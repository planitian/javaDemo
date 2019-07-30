package test;

import java.io.Serializable;

public class TranTest implements Serializable {
    int age;
    String name;
    transient Double price;

    public TranTest(int age, String name, Double price) {
        this.age = age;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "TranTest{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
