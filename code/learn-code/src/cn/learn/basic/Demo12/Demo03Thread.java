package cn.learn.basic.Demo12;
/*
    ʹ�������ڲ��࣬ʵ�ֶ��̳߳���
    ǰ�᣺�̳л�ӿ�ʵ��
    new ���෽�����߽ӿ�(){
        ��д���󷽷�
    }
*/

public class Demo03Thread {
    public static void main(String[] args) {
        //�̳з���XXX extends Thread { public void run() {} }
        new Thread() {
            public void run() {
                System.out.println("!!!");
            }
        }.start();

        //ʵ�ֽӿڷ�ʽ XXX implement Runnable { public void run() {} }
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
