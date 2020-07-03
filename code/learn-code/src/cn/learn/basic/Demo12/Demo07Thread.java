package cn.learn.basic.Demo12;
/*
    多线程并发访问同一个数据资源
    3个线程，对同一个资源，出售
*/

public class Demo07Thread {
    public static void main(String[] args) {
        //创建Runnable接口实现对象
        Pickets p = new Pickets();

        //创建三个Thread类对象，传递Runnable接口实现类
        Thread t0 = new Thread(p);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);

        t0.start();t1.start();t2.start();

    }
}
