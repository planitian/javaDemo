package Encoder;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Atwo extends Aone {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "#配置格式:name=n";
        byte[] one = str.getBytes();//utf-8 格式数组

        byte[] GB2312 = str.getBytes("gb2312");//gb2312个数组
        //没乱码
        String strGB2312 = new String(GB2312, "gb2312");
        System.out.println("没乱码  "+strGB2312);

        byte[] two = strGB2312.getBytes("utf-8");//utf-8 格式数组
        System.out.println(isEqual(one,two));//两个相等
        String strUTF = new String(two, "utf-8");
        System.out.println(strUTF);//这个不乱码

        byte[] three = strGB2312.getBytes("gb2312");//gb2312数组
        System.out.println(isEqual(GB2312,three));//两个相等
        String strGBOne = new String(three, "utf-8");
        System.out.println(">>> "+strGBOne);//乱码

        byte[] four = strGBOne.getBytes("gb2312");//gb2312数组
        System.out.println(isEqual(three,four));//和gb2312数据比较  不相等
        System.out.println(isEqual(four,two));//和utf-8数组 比较  不相等
        System.out.println();
        String osName = System.getProperties().getProperty("os.name");
        System.out.println(osName);

    }


    static boolean  isEqual(byte[] orign,byte[] target){
        if (orign.length!=target.length){
            return false;
        }
        for (int i = 0; i <orign.length ; i++) {
            if (orign[i]!=target[i]){
                return false;
            }
        }
        return true;
    }
}
