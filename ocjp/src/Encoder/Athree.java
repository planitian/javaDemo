package Encoder;

import java.io.*;

public class Athree {
    public static void main(String[] args) throws IOException {
        String path = "D:/one.txt";
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        //原始内容
        String content = "中文englis》》》》";//原始字符串  这时候 与编码格式无关 ，它可以转成任意格式的字节数组

        byte[] utfBytes = content.getBytes("UTF-8");//用UTF-8编码  把content编码成 utf格式字节数组

        byte[] gbkBytes = content.getBytes("GBK");//用GBK编码  把content编码成 gbk格式字节数组

        byte[] isoBytes = content.getBytes("ISO-8859-1");//用ISO-8859-1编码  把content编码成 iso-8859-1格式字节数组

        byte[] gb2312Bytes = content.getBytes("GB2312");//用GB2312编码  把content编码成 gb2312格式字节数组

        outputStream.write(gb2312Bytes);//将gb2312Bytes 数组写入流，这样 在txt文件中 文字是以 GB2312编码格式存储的
        outputStream.flush();
        outputStream.close();
        //以后我们从one.txt文件里面读取流，读到的也是用gb2312格式字节数组
        //这里省略从one.txt文件里面读取流 变成字节数组的过程， 读取出来的数组 是和gb2312Bytes 是一样的

        //只要字节数组编码格式，和解码格式 是相同的就不会中文乱码
        //   gb2312Bytes  用gb2312解码
        String gb2312ToGb2312 = new String(gb2312Bytes, "GB2312");
        System.out.println("gb2312ToGb2312 字节数组编码格式和解码格式相同 "+gb2312ToGb2312);

        //如果 字节数组编码格式，和解码格式 不同 就会产生中文乱码
        //gb2312编码   ISO-8859-1解码  ——》乱码
        String gb2312ToISO = new String(gb2312Bytes, "ISO-8859-1");//gb2312格式字节数组  却用ISO-8859-1的解码
        System.out.println("gb2312ToGbk 字节数组编码格式和解码格式不同 "+gb2312ToISO);//输出乱码
        System.out.println("\r\n-------修复乱码-----------");
        //下面 将乱码修复
        byte[] temp = gb2312ToISO.getBytes("ISO-8859-1");//因为上面是用ISO-8859-1解码的，所以 用ISO-8859-1编码 逆转到 原先数组 也就是gb2312Bytes数组
        System.out.println("乱码字符 ，编码后的数组，和原先gb2312数组比较     "+isEqual(temp,gb2312Bytes));//比较 乱码字符 重新编码后的数组  和 原先的gb2312Bytes数组
        System.out.println("乱码字符 ，编码后的数组，和原先iso-8859-1数组比较     "+isEqual(temp,isoBytes));//比较 乱码字符 重新编码后的数组  和 原先的gb2312Bytes数组
        System.out.println("temp 数组 解码  "+new String(temp,"GB2312"));//再用GB2312解码

        System.out.println("\r\n>>>>>>>>>>>>>>>UTF 的特殊性");

        //注意 如果 你使用UTF-8解码， 意味着 string 只能被 重新编码成 utf-8格式的原数组（解码 编码后 数组相等），不能被重新编码其他格式的数组（解码 编码后 数组不相等）
        String gb2312ToUTF= new String(gb2312Bytes, "UTF-8");//字节数组编码 和第二个参数不一致  乱码
        System.out.println("gb2312ToUTF   编码gb2312  解码UTF-8 "+gb2312ToUTF);//乱码
        byte[] gb2312ToUTFBytes = gb2312ToUTF.getBytes("UTF-8");//乱码 重新编码
        System.out.println("gbk2312原数组， 和先解码UTF-8,再编码 返回的数组比较"+isEqual(gb2312Bytes,gb2312ToUTFBytes));
        System.out.println("utf原数组， 和先解码UTF-8,再编码 返回的数组比较"+isEqual(utfBytes,gb2312ToUTFBytes));
        String one = new String(gb2312ToUTFBytes, "UTF-8");
        System.out.println("one 此时乱码字符已经不能修复 "+one);

        System.out.println("");

        //用utf编译的数组，构造GBK格式的字符串
        String o = new String(utfBytes, "GBK");
        System.out.println(o);
        //识图修复
        System.out.println(new String(o.getBytes("GBK"),"UTF-8"));

        System.out.println("\r\nBufferedReader");
        //如果在构造 InputStreamReader的时候 没有指定 解码格式  charsetName，那么会默认的使用jvm的字符编码（在IDEA中），cmd窗口会使用操作系统的字符编码。
        //现在默认的 一般都是 UTF-8
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String read = null;
        while ((read=bufferedReader.readLine())!=null){
            System.out.println("读取出来的乱码    "+read);
            //运用修复方法
            read = new String(read.getBytes(), "GB2312");
            System.out.println("依旧乱码 不可修复 "+read);
        }
        bufferedReader.close();
        inputStreamReader.close();
        System.out.println("\r\n RandomAccessFile");

        //RandomAccessFile 是用ISO-8859-1 读取的，所以可以修复
        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
        String result = null;
        while ((result=randomAccessFile.readLine())!=null){
            System.out.println("result "+result);
            //修复
            System.out.println(new String(result.getBytes("ISO-8859-1"), "gb2312"));
        }
    }

    /**
     * @param orign
     * @param target
     * @return  如果相等返回true ，其他返回false
     */
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
