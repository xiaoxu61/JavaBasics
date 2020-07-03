package cn.learn.basic.Demo30;

import java.util.ArrayList;

public class MainPacket {

    public static void main(String[] args) {

        Manager manager = new Manager("Ⱥ��", 100);

        People one = new People("��ԱA",0);
        People two = new People("��ԱB",0);
        People three = new People("��ԱC",0);

        manager.show();
        one.show();
        two.show();
        three.show();
        System.out.println("==================================");

        ArrayList<Integer> redList = manager.send(20, 3);
        one.receive(redList);
        two.receive(redList);
        three.receive(redList);

        manager.show();
        one.show();
        two.show();
        three.show();

    }

}
