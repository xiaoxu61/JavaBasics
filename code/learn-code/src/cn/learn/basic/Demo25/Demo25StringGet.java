package cn.learn.basic.Demo25;
/*
String �������ȡ��صĳ��÷�����
   public int length()����ȡ�ַ������к��е��ַ��������õ��ַ�������
   public String concat(String str)������ǰ�ַ����Ͳ����ַ���ƴ�ӳ�Ϊ����ֵ�µ��ַ���
   public charAt(int index)����ȡָ������λ�õĵ����ַ�����������0��ʼ��
   public int indexOf(String str)�����Ҳ����ַ����ڱ��ַ��������״γ��ֵ�����λ�ã����û�з���-1ֵ
*/


public class Demo25StringGet {
    public static void main(String[] args) {
        //��ȡ�ַ����ĳ���
        int length = "sdsfdfgfghthuhidg".length();
        System.out.println("�ַ����ĳ����ǣ�" + length);

        //ƴ���ַ�
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1.concat(str2);
        System.out.println(str3);
        System.out.println("==============");

        //��ȡָ������λ�õĵ����ַ�
        char ch = "Hello".charAt(2);
        System.out.println("��2������λ�õ��ַ��ǣ�" + ch);
        System.out.println("=================");

        //���Ҳ����ַ����ڱ����ַ������г��ֵĵ�һ������λ��
        //�������û�У�����-1
        String original = "HellodWorld";
        int index = original.indexOf("llo");
        System.out.println("��һ������ֵ�ǣ�" + index);//2
        System.out.println(original.indexOf("a"));
    }
}
