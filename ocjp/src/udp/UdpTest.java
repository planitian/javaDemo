package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpTest {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];
        byte[] outBuffer = new byte[1024];
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        DatagramPacket datagramPacket = new DatagramPacket(buffer,0,buffer.length);
        DatagramPacket out = new DatagramPacket(outBuffer, 0, outBuffer.length);
        while (true){
            datagramSocket.receive(datagramPacket);
            InetAddress inetAddress = datagramPacket.getAddress();

            System.out.println("offset  "+datagramPacket.getOffset());
            System.out.println("length"+datagramPacket.getLength());
            System.out.println("size "+datagramPacket.getData().length);

            String s = new String(datagramPacket.getData());
            datagramPacket.setData("服务器返回".getBytes());
            out.setAddress(datagramPacket.getAddress());
            out.setPort(9998);
            datagramSocket.send(datagramPacket);
            System.out.println(s);
        }
    }
}
