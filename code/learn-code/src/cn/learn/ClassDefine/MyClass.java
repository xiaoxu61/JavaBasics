package cn.learn.ClassDefine;

public class MyClass {
    int num;//��Ա����
    static int numStatic;//��̬����
    public void method(){
        System.out.println("����һ����Ա������");
        System.out.println(num);//û����˵����Ա�������Է��ʳ�Ա����
        System.out.println(numStatic);//��Ա�������Է��ʾ�̬����
    }

    public static void methodStatic(){
        System.out.println("����һ����̬����");
        System.out.println(numStatic);//��̬�������Է��ʾ�̬����
//        System.out.println(num);//��̬����ֱ�ӷ��ʷǾ�̬������д��
    }
}
