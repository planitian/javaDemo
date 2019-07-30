package Encoder;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.AttributeView;
import java.nio.file.attribute.FileAttribute;
import java.util.Objects;

public class Afour {
    public static void main(String[] args) throws IOException {
        //创建一个path
        Path path = Paths.get("D:", "three.txt");
        //通过自带的静态方法创建，也可以通过file流得到   注意后面的动态参数
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ);
        //创建一个字节缓冲
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //清空
        byteBuffer.clear();
        //输出通道 现在 的指针位置  也可以设置position(long)
        System.out.println(fileChannel.position());
        //加锁
        fileChannel.tryLock();

        //向缓冲区写入数据
        byteBuffer.put("woshihaha还是大声道".getBytes("UTF-8"));
        byteBuffer.flip();//将limit变成position position 变成0
        byteBuffer.limit(1000);
        //这个要特别注意 ，从byteBuffer里面读数据的时候 是从缓冲字节的position 开始读的，一直到limit
        //第二个参数代表 从文件当中的那个位置写  这个不会改变文件的position位置
        fileChannel.write(byteBuffer);
        //fileChannel的position 只有read 才会变 write 不会使position
        System.out.println("文件当前位置 "+fileChannel.position());
        //清空  准备读取
        byteBuffer.clear();
        //读字节 也是从缓冲字节的postion位置开始，到limit位置结束、
        //也可以设置读取到缓冲字节的子序列
        //也可以设置从文件那个位置读
        fileChannel.read(byteBuffer);
        byte[] temp = new byte[byteBuffer.position()];
        byteBuffer.flip();//准备将byte写入到byte数组里面 从position读的
        byteBuffer.get(temp);
        System.out.println(new String(temp));
        //创建一个文件 将上面的path文件内容复制到 这个文件
        Path copyto = Paths.get("D:", "four.txt");
        FileChannel copyChannel = FileChannel.open(copyto, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ);
        fileChannel.position(0);
        //这个也会从fileChannel的position位置开始读取   下面这个方法的position 是copyChannel的position
        copyChannel.transferFrom(fileChannel, 0, fileChannel.size());
        copyChannel.close();
        fileChannel.close();
    }
}
