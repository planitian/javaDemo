package Encoder;

import java.io.UnsupportedEncodingException;

public class Aone {
    private static void out(){
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "#配置格式:name=n";//原始字符串  这时候 与编码格式无关

        byte[] utf = str.getBytes("UTF-8");//第一个UTF格式数组

        byte[] gbk = str.getBytes("GBK");//第一个GBK格式数组

        String utfToUTF = new String(utf, "UTF-8");//用 utf-8编码构造 一个String ,因为 源数组是UTF格式数组，所以肯定不乱码
        System.out.println(utfToUTF);//构造 数组格式  和编码格式相同  不乱码

        String gbkToGBK = new String(gbk, "GBK");//用GBK编码构造一个Sting，因为,源数组是GBK格式数组，所以 不乱码
        System.out.println(gbkToGBK);//不乱码

        String gbkToUTF = new String(gbk, "UTF-8");
        System.out.println(gbkToUTF);//乱码

        byte[] UTFtoutf = gbkToUTF.getBytes("UTF-8");
        System.out.println(isEqual(utf,UTFtoutf));//和第一个UTF格式数组 不同

        byte[] UTFtogbk = gbkToUTF.getBytes("GBK");
        System.out.println(isEqual(gbk,UTFtogbk));


    /*    String content = "#配置格式:name=n";
        System.out.println("content "+content);
        byte[] gbkBytes = content.getBytes("GBK");//转成gbk格式数组  这样 下面会产生乱码
        String s = new String(gbkBytes, "UTF-8");//  这里字符串 已经乱码
        System.out.println("s "+s);
        String result = new String(s.getBytes("GBK"), "UTF-8");
        System.out.println("result "+result);*/

        String content = "#配置格式:name=n";
        System.out.println("content "+content);
        byte[] gb2312Bytes = content.getBytes("GB2312");//转成gb2312格式数组  这样 下面会产生乱码
        String s = new String(gb2312Bytes, "ISO-8859-1");//  这里字符串 已经乱码
        System.out.println("s "+s);
        String result = new String(s.getBytes("ISO-8859-1"), "GB2312");
        System.out.println("result "+result);

        //文件存的时候 String要转成byte数组写入 ，这时候 就是编码格式  数据编码格式是啥 String编码格式是啥
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
