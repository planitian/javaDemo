package abstractTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class AbstractMain {
    public static void main(String[] args) {
        Son son=new Son();
        son.outSon();

        son.outFather();
        System.out.println(son.outFanhui("子类加的")+son.ss);
        son.outFather();

        String[] ss=new String[]{"sss","aaa","ddd"};
        List<String> list=Arrays.asList(ss);
        System.out.println(ss+">>>>"+list+"???"+list.toArray(ss).length);
        Integer[] fff=new Integer[]{1,5,6,9,7,4};
        Integer[] temp=son.<Integer>arraySpeDel(fff,5);
        for (int i = 0; i <temp.length ; i++) {
            System.out.println(temp[i]);

        }
        System.out.println("?????????????????????");
      Integer[] aaa=new Integer[]{1,2,3,4,6,8,9};
//        Integer[] ggg=new Integer[aaa.length+1];
//        son.arrayAdd(aaa,ggg,2);
//        for (int i = 0; i <ggg.length ; i++) {
//            System.out.println(ggg[i]);
//
//        }
       Integer[] result=son.arrayAdd(aaa,2);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);

        }

        String[] zifuc=new String[]{"ss","hhh","aaaa"};
        String[] qq=son.arrayAdd(zifuc,"tttt","gggg");
        for (int i = 0; i <qq.length ; i++) {
            System.out.println(qq[i]);
        }

        Son son1=new Son();
        son1.baseOut();
        son1.extOut();

        byte[] test=new byte[11];
        System.out.println(test.length);
        System.out.println(Integer.toBinaryString(61));
        BigDecimal result11=moneyMul(new BigDecimal(10),new BigDecimal(15),new BigDecimal(10));
        System.out.println(result11.doubleValue());

    }

    public static BigDecimal moneyMul(BigDecimal value, BigDecimal... mulValue){
        BigDecimal temp = null;
        for (int i = 0; i <mulValue.length ; i++) {
            temp=value.multiply(mulValue[i]);
            value=temp;
        }
        return temp;
    }
}



