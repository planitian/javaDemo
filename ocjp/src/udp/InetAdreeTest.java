package udp;

import java.io.IOException;
import java.net.*;

public class InetAdreeTest {
    public static void main(String[] args) {
        try {
            //接受端
            byte[] out = new byte[5];
            //这里可以不指定 要数据报包 要发送的地址 和端口， 那么下面必须要 connect方法指定 地址和端口
            DatagramPacket da = new DatagramPacket(new byte[5], 5);
            //如果不指定本地端口 ，那么会任意指定一个可以用的端口
            DatagramSocket datagramSocket = new DatagramSocket(9999);
            //注意是本地端口
            System.out.println(datagramSocket.getLocalPort());
            //会一直阻塞
            datagramSocket.receive(da);
            datagramSocket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
