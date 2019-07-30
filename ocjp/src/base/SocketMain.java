package base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;


public class SocketMain {
    private static byte[] lenByte = new byte[4];
    static int anInt = 0;
    public static void main(String[] args) throws Exception{
            ServerSocket client = new ServerSocket(5553);
            ServerSocket server = new ServerSocket(7776);

            while (true){
                Socket clientSocket = null;
                Socket serverSocket = null;
                BufferedInputStream clientInput = null;
                BufferedOutputStream serverOutput = null;
                try {
                    serverSocket = server.accept();
                    System.out.println("serverSocket  链接");
                    clientSocket = client.accept();
                    System.out.println("clientSocket  链接");
                    clientSocket.setKeepAlive(true);
                    serverSocket.setKeepAlive(true);
                    clientSocket.setTcpNoDelay(true);
                    serverSocket.setTcpNoDelay(true);
                    clientInput = new BufferedInputStream(clientSocket.getInputStream());
                    serverOutput = new BufferedOutputStream(serverSocket.getOutputStream());
                    while (true){
                        byte[] date = readBytes(clientInput);
                        if (date==null){
                            break;
                        }
                        System.out.println(" 读取到数据"+anInt++);
                        for (int i = 0; i <date.length ; i++) {
                            System.out.println(date[i]);
                        }
                        serverOutput.write(date);
                        System.out.println("写入流");
                        serverOutput.flush();
                    }

                  /*  byte[] temp = new byte[128];
                    int len;
                    while ((len=clientInput.read(temp))!=-1){
                        System.out.println("接收到数据"+System.nanoTime());
                        serverOutput.write(temp,0,len);
//                        serverSocket.getOutputStream().write(temp,0,len);
                    }*/
                } catch (IOException e) {
                    System.out.println(e);
                } finally {
                    try {
                        clientInput.close();
                        serverOutput.close();
                        clientSocket.close();
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("  socket 链接关闭");
                }
            }
        }

    //读取一帧图像的数组
    public static byte[] readBytes(BufferedInputStream inputStream) throws Exception {
        int len = 0;
        int count = 0;
        while (count < 4) {
            len = inputStream.read(lenByte, len, 4 - len);
            if (len == -1) {
                return null;
            }
            count += len;
        }
        len = ByteUtils.ByteArrayToInt(lenByte);

      byte[] temp = Arrays.copyOf(lenByte,len+4+1);
//        byte[] temp = new byte[len + 4 + 1];
        int read = 0;
        int countByte = 0;
        while (countByte<len){
            read = inputStream.read(temp, countByte+4, len - countByte+1);
            if (read==-1){
                return null;
            }
            countByte += read;
        }
        System.out.println(" 图像数组读取 "+len+"   "+temp.length);

        return temp;
    }


}
