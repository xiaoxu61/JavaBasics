package cn.learn.basic.Demo25;
/*
    java.lang.StringBuilder�ࣺ�ַ�������������������ַ�����Ч��
    ���췽����
        StringBuilder()
            ����һ�������κ��ַ����ַ��������������ʼ����Ϊ16�ַ�
        StringBuilder(String str)����һ���ַ���������������ʼ��Ϊָ�����ַ�������

    StringBuilder�ĳ��÷�����
        public StringBuilder oppend(...)����������������ݵ��ַ�����ʽ�������ص�ǰ��������
    StringBulider��String�����໥ת����
        String --> StringBuilder������ʹ��StringBuilder�Ĺ��췽��
            StringBuilder(String str)����һ���ַ���������������ʼ��Ϊָ�����ַ�������
        StringBuilder --> String������ʹ��StringBuilder�е�toString����
            public String toString()������ǰStringBuilder����ת��ΪString����
*/

public class Demo05StringBuilder {
    public static void main(String[] args) {
        //�ղ������췽��
        StringBuilder bu1 = new StringBuilder();
        System.out.println(bu1);//���ַ���
        //���ַ������췽��
        StringBuilder bu2 = new StringBuilder("abc");
        System.out.println(bu2);
        System.out.println("==================");
        //ʹ��append������StringBuilder���������
        //���ص���this.���÷����Ķ���
        StringBuilder bu3 = bu1.append("abc");
        System.out.println(bu1);
        System.out.println(bu3);
        System.out.println(bu1 == bu3);

        //ʹ��appen����������շ���ֵ
        StringBuilder bu = new StringBuilder();
        bu.append("abc");
        bu.append(1);
        bu.append(true);
        System.out.println(bu);

        /*
        ��ʽ��̣���������ֵ��һ�����󣬿��Լ������÷���
        */
        System.out.println("abc".toUpperCase().toLowerCase().toUpperCase().toLowerCase());
        bu.append("abc").append(1).append(true).append("��");
        System.out.println(bu);
        System.out.println("==========================");

        //String --> StringBuilder
        String str = "hello";
        System.out.println(str);
        StringBuilder sbu = new StringBuilder(str);
        //��StringBuilder���������
        sbu.append("world");
        System.out.println(sbu);

        //StringBuilder --> String
        String s = sbu.toString();
        System.out.println(s);
    }
}
