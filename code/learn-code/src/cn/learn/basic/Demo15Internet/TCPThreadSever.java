package cn.learn.basic.Demo15Internet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPThreadSever {
    public static void main(String[] args) throws IOException {
        ServerSocket sever = new ServerSocket(8888);
        while (true) {
            //��ȡ��һ���ͻ��ˣ����뿪��һ���߳�
            Socket socket = sever.accept();
            new Thread(new UpLoad(socket)).start();
        }

    }
}
