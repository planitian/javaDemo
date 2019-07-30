package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketMain {

    public static void main(String[] args) {

        ExecutorService executorServic = Executors.newSingleThreadExecutor();
        executorServic.execute(() -> {
            try {

                ServerSocket serverSocket = new ServerSocket(9999);
                long first=0;
//                serverSocket.setSoTimeout(5000);
                Socket socket=serverSocket.accept();
                socket.setSoTimeout(30000);
                InputStream inputStream=socket.getInputStream();
                OutputStream  outputStream=socket.getOutputStream();
                first=System.currentTimeMillis();
                while (true) {
                    System.out.println("运行");
//                    if (first!=0&&(System.currentTimeMillis()-first)>5000){
//                        System.out.println("关闭了");
//                        if (inputStream!=null&&outputStream!=null){
//                            inputStream.close();
//                            outputStream.close();
//                            socket.close();
//                           socket=serverSocket.accept();
//                           inputStream=socket.getInputStream();
//                           outputStream=socket.getOutputStream();
//                           first=0;
//                        }
//
//                    }

//                    System.out.println("close"+socket.isClosed()+socket.isConnected()+serverSocket.isClosed());
                    if (!socket.isClosed()&&inputStream!=null&&inputStream.available()!=0){

                        DataInputStream input=new DataInputStream(inputStream);
                        DataOutputStream out=new DataOutputStream(outputStream);
                        out.writeUTF("我是服务器发来的数据\n");
                        out.flush();
                        String input1 = input.readUTF();
                        System.out.println("接受到的数据"+input1);
                        first=System.currentTimeMillis();
                        if (input1.equals("xintiao")){
                            System.out.println("服务器端收到心跳包  :" );
                        }else{
                            System.out.println("服务器收到的数据  :"+input1);
                        }

                    }
                    Thread.sleep(1000);




                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        });
    }
    public Socket getSocket() throws Exception{
        ServerSocket serverSocket=new ServerSocket(9999);
        return serverSocket.accept();
    };

}

class XinTiao extends TimerTask {

    @Override
    public void run() {

    }
}


