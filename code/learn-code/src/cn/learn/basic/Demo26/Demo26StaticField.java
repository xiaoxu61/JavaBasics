package cn.learn.basic.Demo26;
/*
���һ����Ա����ʹ����static�ؼ��֣���ô��������������ڶ����Լ��������������ڵ��࣬���������һ������
*/

import cn.learn.ClassDefine.Student;

public class Demo26StaticField {
    public static void main(String[] args) {
        Student one = new Student("����",15);
        one.setRoom("105����");
        System.out.println("������" + one.getName() + ",���䣺" + one.getAge()
                + "��ѧ�ţ�" + one.getId() + ",�༶��" + one.getRoom());

        Student two = new Student("����1",151);
        System.out.println("������" + two.getName() + ",���䣺" + two.getAge()
                + "��ѧ�ţ�" + two.getId() + ",�༶��" + two.getRoom());
    }
}
