package cn.learn.basic.Demo12;
/*
    通过线程休眠，出现安全问题
    解决问题：Java程序
    提供技术：同步技术
    公式：
        synchronized(任意对象){
            线程要操作的共享数据
        }
*/

public class Pickets implements Runnable {

    //定义出售的票源
    private int ticket = 100;
    private Object obj  = new Object();
    @Override
    public void run() {
        while (true) {
            //对票数判断，大于0，可以出售，变量--操作
            //线程共享数据，包证安全，加入同步代码块
            synchronized (obj) {//同步加入后，线程安全了，但是运行速度慢了
                if (ticket > 0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "出售第"+ (ticket--) +"张票");
                }
            }

        }
    }
}
