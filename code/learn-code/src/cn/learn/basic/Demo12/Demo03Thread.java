package cn.learn.basic.Demo12;
/*
    使用匿名内部类，实现多线程程序
    前提：继承或接口实现
    new 父类方法或者接口(){
        重写抽象方法
    }
*/

public class Demo03Thread {
    public static void main(String[] args) {
        //继承方法XXX extends Thread { public void run() {} }
        new Thread() {
            public void run() {
                System.out.println("!!!");
            }
        }.start();

        //实现接口方式 XXX implement Runnable { public void run() {} }
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("###");
            }
        };
        new Thread(r).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("@@@");
            }
        }).start();
    }
}
