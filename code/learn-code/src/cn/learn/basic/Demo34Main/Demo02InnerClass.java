package cn.learn.basic.Demo34Main;
/*
���һ��ʵ����ڲ�������һ��������ô�����һ�����ڲ�������һ����
���磺��������࣬�����ͷ�����

���ࣺ
1����Ա�ڲ���
    ��ʽ��
        ���η� class �ⲿ������ {
            ���η� class �ڲ������� {
                //....
            }
         }
     ע�⣺�����⣬������ʣ������ڣ�һ����Ҫ�����ڲ������
==========================================================
     ���ʹ�ó�Ա�ڲ��ࣺ
        1����ӷ�ʽ�����ⲿ��ķ������У�ʹ���ڲ��ࣺȻ��mainֻ�ǵ����ⲿ��ķ���
        2��ֱ�ӷ�ʽ����ʽ���ⲿ������.�ڲ������� ������  = new �ⲿ������().new �ڲ�����
2���ֲ��ڲ��ࣨ���������ڲ���)
    ���һ�����Ƕ�����һ�������ڲ�����ô�����һ���ֲ��ڲ���
    �ֲ���ֻ�е�ǰ�����ķ�������ʹ���������������������Ͳ�������

    �����ʽ��
    ���η� class �ⲿ������{
         ���η� ����ֵ���� �ⲿ�෽������(�����б�) {
             class �ֲ��ڲ������� {
                 //...
             }
          }
     }
    С��һ�����Ȩ�����η���
     public > protect > (default) > private
    ����һ�����ʱ��Ȩ�����ι���
     1���ⲿ�ࣺpublic/��defaul��
     2����Ա�ڲ��ࣺpublic/protect/��default��/private
     3���ֲ��ڲ��ࣺʲô������д

*/

public class Demo02InnerClass {

    public static void main(String[] args) {
        Body body = new Body();
        //ͨ���ⲿ��Ķ��󣬵����ⲿ��ķ�������������ʹ���ڲ���Heart
        body.methodBody();
        System.out.println("===================");

        //���չ�ʽд
        Body.Heart heart = new Body().new Heart();
        heart.beat();
        System.out.println("=========================");

        Outer.Inner obj = new Outer().new Inner();
        obj.methodInner();
        System.out.println("================");

        Outer obj1 = new Outer();
        obj1.methodOuter();
    }

}
