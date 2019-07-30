package Sort;

public class Comparable_Example implements Comparable<Comparable_Example> {
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;


    public Comparable_Example(int number) {
        this.number=number;
    }

    /**
     * @param o   就代表在排序时候，本身类的其他实例，将自身与其他实例进行比较
     * @return  返回正实数就是大于，0代表等于，负实数代表小于
     */
 @Override
    public int compareTo(Comparable_Example o) {
        return this.number-o.getNumber();
    }
}
