package cn.learn.basic.Demo01;

public class Demo18UsePerson {
    public static void main(String[] args) {
        Demo18Person person = new Demo18Person();
        person.show();
        System.out.println("======================");

        person.setName("�޺��");
//        person.age = 20;//ֱ�ӷ���private���ݣ�����д��
        person.setAge(20);
        person.setMale(true);
        person.show();
        System.out.println("=============");
        System.out.println("������" + person.getName());
        System.out.println("���䣺" + person.getAge());
        System.out.println("�Ƿ���ү�ǣ�" + person.isMale());

    }
}
