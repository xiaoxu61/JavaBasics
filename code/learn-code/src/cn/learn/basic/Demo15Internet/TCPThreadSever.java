package cn.learn.basic.Demo15Internet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPThreadSever {
    public static void main(String[] args) throws IOException {
        ServerSocket sever = new ServerSocket(8888);
        while (true) {
            //获取到一个客户端，必须开启一新线程
            Socket socket = sever.accept();
            new Thread(new UpLoad(socket)).start();
        }

    }
}
