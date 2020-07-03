package cn.learn.basic.Demo12.Lock;
/*
    使用JDK 1.5的接口Lock，替换同步代码块，实现线程的安全性
    Lock接口方法：
        lock()      获取锁
        unlock()    释放锁

    实现类ReentrantLock
*/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable{
    //定义出售的票源
    private int ticket = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            //调用Lock接口方法，lock获取锁
            lock.lock();
            //对票数判断，大于0，可以出售，变量--操作
            if (ticket > 0) {

                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "出售第"+ (ticket--) +"张票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放锁
                    lock.unlock();
                }
            }

        }
    }
}
