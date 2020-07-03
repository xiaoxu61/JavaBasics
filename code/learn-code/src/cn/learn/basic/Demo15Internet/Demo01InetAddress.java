package cn.learn.basic.Demo15Internet;
/*
    表示互联网中的IP地址
        java.net.InetAddress
    静态方法：
        static InetAddress getLocalHost() LocalHost本地主机
        返回本地主机，返回值InetAddress

        static InetAddress getByName(String hostName) 传递主机名，获取IP地址对象

    非静态方法：
        String getHoustAddress() 获取主机IP地址
        String getHoustName()    获取主机名
*/

import java.net.InetAddress;
import java.net.UnknownHostException;



public class Demo01InetAddress {
    public static void main(String[] args) throws UnknownHostException {
        function_1();
    }

    private static void function_1() throws UnknownHostException {
        InetAddress inet = InetAddress.getByName("DESKTOP-HR7GET6");
        System.out.println(inet);
    }

    public static void function() throws UnknownHostException {
        InetAddress inet = InetAddress.getLocalHost();
        //输出结果就是主机名，和IP地址
        String ip = inet.getHostAddress();
        String name = inet.getHostName();
        System.out.println(name +"   " + ip);
        /*System.out.println(inet);
        String hsot = inet.toString();
        String[] str = hsot.split("/");
        for (String s : str) {
            System.out.println(s);
        }*/
    }
}
