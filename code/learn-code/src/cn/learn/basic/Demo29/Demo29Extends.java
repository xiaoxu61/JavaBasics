package cn.learn.basic.Demo29;
/*
�ڼ̳й�ϵ�У����������һ�����࡯��Ҳ����˵��������Ա��������׿���
���縸����Ա���������ǽ�ʦ����ô����ʦ����һ��Ա��������ϵ��is-a

���常��ĸ�ʽ����һ����ͨ���ඨ�壩
public class ��������{
    //...
}

��������ĸ�ʽ��
public class �������� extends �������� {
    //...
}

������ļ̳й�ϵ���У������Ա�����������򴴽��������ʱ�����������ַ�ʽ��
   ֱ��ͨ�����������ʳ�Ա������
       �Ⱥ������˭����������˭��û����������
   ���ͨ����Ա�������ʳ�Ա����:
        �÷�������˭����������˭��û����������


*/

public class Demo29Extends {
    public static void main(String[] args) {
        //����һ���������
        Demo29Teacher teacher = new Demo29Teacher();
        //Teacher������Ȼʲô��ûд�����ǻ�̳����Ը����method
        teacher.method();

        //����һ���������̵Ķ���
        Demo29Assistant assistant = new Demo29Assistant();
        assistant.method();

        Demo29Fu fu = new Demo29Fu();//�����������
        System.out.println(fu.numFu);//ֻ���ø���Ķ�����û���κ���������

        Demo29Zi zi = new Demo29Zi();
        System.out.println(zi.numFu);
        System.out.println(zi.numZi);
        System.out.println("=================");

        //�Ⱥ������˭����������˭
        System.out.println(zi.num);//��������
//        System.out.println(zi.abc);//������û�У����뱨��
        System.out.println("==================");
        zi.methodZi();//�������������ģ�����������ģ�û����������
        //����������ڸ��൱�ж����
        zi.methodFu();
    }
}
