package cn.learn.basic.Demo03;
/*
�������ͺ��ַ���֮����໥ת��
    �������� --> �ַ�����String��
        1����������ֵ + ""  ��򵥵ķ����������г��ã�
        2����װ��ľ�̬����toString(����)������Object���toString()����
            static String toString(int i)����һ����ʾָ�������� String ����
        3��String �ľ�̬������valueOf(����)
            static String valueOf(int i) ����int�������ַ�����ʾ��ʽ
    �ַ���(String) --> ��������
        ��װ��ľ�̬����parseXXX("�ַ���")
            Integer�ࣺstatic int parseInt(String s)
            Double�ࣺstatic double parseDouble(String s)
*/

public class Demo06Integer2 {
    public static void main(String[] args) {
        //�������� --> �ַ���
        int i1 = 100;
        String s1 = i1 + "";
        System.out.println(s1);

        String s2 = Integer.toString(100);
        //toString(int ,int ����),��int������ת��ָ��������
        String s21 = Integer.toString(5,2);
        System.out.println(s2 + 200);
        System.out.println(s21);

        String s3 = String.valueOf(100);
        System.out.println(s3 + 300);

        //�ַ���(String) --> ��������
        int i = Integer.parseInt(s1);
        System.out.println(i + 10);

        int in2 = Integer.parseInt("110", 2);
        //radix��������110��2���壬ǰ�������Ƕ����ƣ����Ƿ���parseInt���н����ʮ���Ƶ�
        System.out.println(in2);

//        int a = Integer.parseInt("a");//�����쳣
    }
}
