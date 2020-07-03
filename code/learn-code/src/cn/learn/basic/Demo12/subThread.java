package cn.learn.basic.Demo12;
/*
    定义子类，继承Thread
    重写方法run

    获取线程名字，父类Thread方法
        String getName()
*/

public class subThread extends Thread{

    @Override
    public void run() {
        System.out.println(getName());

//        System.out.println(0/0);
//        for (int i = 0; i < 50; i++) {
//            System.out.println("run..." + i);
//        }
    }
}
