package cn.learn.basic.Demo12;
/*
    采用同步方法形式，解决线程的安全问题
    好处：代码简洁
    将线程共享数据，和同步，抽取到同一个方法中
    在方法的声明上，加入同步关键字synchronized

    同步方法中的对象锁，是本类的对象引用this
    如果方法是静态的，同步有锁，锁是本类自己.class
    静态方法中，同步锁，是本类类名.class属性
*/

public class Ticket implements Runnable{
    //定义出售的票源
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            payTicket();
        }
    }

    public synchronized void payTicket() {
        //对票数判断，大于0，可以出售，变量--操作
        //线程共享数据，包证安全，加入同步代码块
        //同步加入后，线程安全了，但是运行速度慢了
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
