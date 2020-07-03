package cn.learn.basic.Demo12.Lock;

import cn.learn.basic.Demo12.Ticket;

public class Demo08Thread {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        Thread t0 = new Thread(t);
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t0.start();t1.start();t2.start();
    }
}
