package bean;

public class Emplo {
    private String name;
    private int age;
    private String sex;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    private Double getPrice() {
        return price;
    }

    private void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Emplo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", price=" + price +
                '}';
    }
}
