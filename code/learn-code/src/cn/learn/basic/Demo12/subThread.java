package cn.learn.basic.Demo12;
/*
    �������࣬�̳�Thread
    ��д����run

    ��ȡ�߳����֣�����Thread����
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
