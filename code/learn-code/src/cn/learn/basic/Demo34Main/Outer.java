package cn.learn.basic.Demo34Main;
/*
�������������������ô��ʽ�ǣ��ⲿ������.this.�ⲿ���Ա������

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

public class Outer {

    int num = 10;//�ⲿ��ĳ�Ա����

    public class Inner {
        int num = 20;//�ڲ���ĳ�Ա����

        public void methodInner() {
            int num = 30;//�ڲ���ľֲ�����
            System.out.println(num);//�ֲ��������ͽ�ԭ��
            System.out.println(this.num);//�ڲ���ĳ�Ա����
            System.out.println(Outer.this.num);//�ⲿ��ĳ�Ա����
        }

    }
    public  void methodOuter() {
        class Inner{//�ֲ��ڲ���
            int num = 10;
            public void methodInner() {
                System.out.println(num);//10
            }
        }
        Inner inner = new Inner();
        inner.methodInner();
    }
}
