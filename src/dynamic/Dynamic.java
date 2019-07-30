package dynamic;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Dynamic {
    public static void main(String[] args) {
         BigDecimal one=new BigDecimal(0.345664);
         BigDecimal two=new BigDecimal(0.34);
         BigDecimal three=new BigDecimal(10);
        System.out.println(moneyMul(one,two,three).doubleValue());
        System.out.println(moneyMul1(one,two,three));
    }

    public static BigDecimal moneyMul(BigDecimal value, BigDecimal... mulValue){
        DecimalFormat fnum = new DecimalFormat("##0.00000000000000000000");
        BigDecimal temp = null;
        for (int i = 0; i <mulValue.length ; i++) {
            temp=value.multiply(mulValue[i]);
            value=temp;
        }
        return temp;
    }
    public static String moneyMul1(BigDecimal value, BigDecimal... mulValue){
        DecimalFormat fnum = new DecimalFormat("##0.00000000000000000000");
        BigDecimal temp = null;
        for (int i = 0; i <mulValue.length ; i++) {
            temp=value.multiply(mulValue[i]);
            value=temp;
        }
        return fnum.format(temp);
    }
}
