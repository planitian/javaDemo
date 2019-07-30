package java_foreach;

public class Test implements Comparable<Test>{
    private int shuzhi;

    public Test(int shuzhi) {
        this.shuzhi = shuzhi;
    }

    public int getShuzhi() {
        return shuzhi;
    }

    public void setShuzhi(int shuzhi) {
        this.shuzhi = shuzhi;
    }

    @Override
    public int compareTo(Test o) {
        int result=this.shuzhi-o.getShuzhi();
        if (result>0) {
            result = 1;
        } else {
            result=-1;
        }
        return result;
    }
}
