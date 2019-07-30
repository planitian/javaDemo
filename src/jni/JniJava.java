package jni;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

public class JniJava {
    static String hex="023D32203030363130353030303030300D0A";
    public static void main(String[] args) throws IOException {
        System.out.println(hexStringToBinary("32"));
        char[] chars=hex.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            System.out.println("charvalue"+chars[i]);
        }
        byte[] bytes=new byte[18];
        System.out.println(hex.substring(4,6));
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
//        objectOutputStream.write();

        bytes=toBytes(hex);
        int temp=(bytes[4] - 48) * 100000 + (bytes[5] - 48) * 10000 + (bytes[6] - 48) * 1000 + (bytes[7] - 48) * 100 + (bytes[8] - 48) * 10 + (bytes[9] - 48);
        System.out.println(bytes[0]+"  "+bytes.length+">>>>"+Integer.toBinaryString(bytes[2])+"buling   "+buling(Integer.toBinaryString(bytes[2])));

        System.out.println("重量+"+temp);
    }


    public native String  jingtai();

    public static String buling(String neirong){
        String str="00000000";
        return str.substring(neirong.length())+neirong;
    }

    public static   String toBinaryString(String hexa,int len){
        return String.format("%+d",hexa);
    }

    public static String hexStringToBinary(String hex) {
        hex = hex.toUpperCase();
        String result = "";
        int max = hex.length();
        for (int i = 0; i < max; i++) {
            char c = hex.charAt(i);
            switch (c) {
                case '0':
                    result += "0000";
                    break;
                case '1':
                    result += "0001";
                    break;
                case '2':
                    result += "0010";
                    break;
                case '3':
                    result += "0011";
                    break;
                case '4':
                    result += "0100";
                    break;
                case '5':
                    result += "0101";
                    break;
                case '6':
                    result += "0110";
                    break;
                case '7':
                    result += "0111";
                    break;
                case '8':
                    result += "1000";
                    break;
                case '9':
                    result += "1001";
                    break;
                case 'A':
                    result += "1010";
                    break;
                case 'B':
                    result += "1011";
                    break;
                case 'C':
                    result += "1100";
                    break;
                case 'D':
                    result += "1101";
                    break;
                case 'E':
                    result += "1110";
                    break;
                case 'F':
                    result += "1111";
                    break;
            }
        }
        return result;
    }

    public static byte[] toBytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }
        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }
}