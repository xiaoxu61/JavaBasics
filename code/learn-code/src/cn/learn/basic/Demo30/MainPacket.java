package cn.learn.basic.Demo30;

import java.util.ArrayList;

public class MainPacket {

    public static void main(String[] args) {

        Manager manager = new Manager("群主", 100);

        People one = new People("成员A",0);
        People two = new People("成员B",0);
        People three = new People("成员C",0);

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
