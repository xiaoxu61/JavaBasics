package cn.learn.basic.Demo25;
/*
String ������ת����صĳ��÷�����
   public char[] toCharArray������ǰ�ַ�����ֳ��ַ���������Ϊ����ֵ
   public byte[] getByte()����õ�ǰ�ַ����ײ���ֽ�����
   public String replace(CharSequence oldString, CharSequence newString)�������г��ֵ����ַ����滻Ϊ�µ��ַ���
      �����滻֮��Ľ�����ַ���.��ע��CharSequence��˼����˵���Խ����ַ������͡�
*/

public class Demo25StringConver {
    public static void main(String[] args) {
        //ת�����ַ�������
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]);//H
        System.out.println(chars.length);
        System.out.println("=================");

        //ת�����ֽ�����
        byte[] bytes = "ABC".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println("========================");
        //�ַ��������滻
        String str1 = "How do you do?";
        String str2 = str1.replace("o", "*");
        System.out.println(str1);
        System.out.println(str2);

        String lang1 = "�᲻���氡�����ү��!���ү�ģ����ү�ģ� ";
        String lang2 = lang1.replace("���ү��","���·ҷ�");
        System.out.println(lang2);
    }
}
