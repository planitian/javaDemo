package base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import test.*;
public class BaseMain {
    public static void main(String[] args) {


        String[] src = new String[]{"one", "two", "three", "four", "five"};
        String[] temp = new String[10];
        byte[] one = new byte[]{1, 2, 5, 87,};
        byte[] two = new byte[]{7, 7, 7, 7, 7, 7};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(one);
            outputStream.write(two);
            for (byte b : outputStream.toByteArray()) {
                System.out.println(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] first = new String[]{"one","two","three"};
        String[] second = new String[]{"1","2","3","4"};
        ByteBuffer byteBufferOne = ByteBuffer.allocate(1024);

        String ss = "SPS";
        String tt = "PPS";
        String content = "fra";

            byte[] sps = ss.getBytes();
            byte[] pps = tt.getBytes();
            byte[] frame = content.getBytes();
            System.out.println(sps.length+"   "+pps.length+"   "+frame.length);
            System.out.println(new String(sps));

    }

    public static byte[] int2byte(int res) {
        byte[] targets = new byte[4];


        targets[3] = (byte) (res & 0xff);// 最低位
        targets[2] = (byte) ((res >> 8) & 0xff);// 次低位
        targets[1] = (byte) ((res >> 16) & 0xff);// 次高位
        targets[0] = (byte) (res >>> 24);// 最高位,无符号右移。
        return targets;
    }

    public static int byte2int(byte[] res) {
        int x = (res[3] & 0xff) | ((res[2] << 8) & 0xff00) // | 表示安位或
                | ((res[1] << 24) >>> 8) | (res[0] << 24);
        return x;
    }

}
