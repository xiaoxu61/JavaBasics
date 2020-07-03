package cn.learn.basic.Demo25;
/*
java.lang.String������ַ���
API����˵��Java �����е������ַ�������ֵ���� "abc" ������Ϊ�����ʵ��ʵ�֡�
��ʵ��˵�����������е�˫�����ַ���������String��Ķ��󣬣�����û��new Ҳ�����ǣ�

�ַ������ص㣺
1���ַ��������������ɱ䡾�ص㡿
2��������Ϊ�ַ������ɸı䣬�����ַ����ǿ��Թ���ʹ�õ�
3���ַ���Ч���൱����char []�ַ����飬���ײ�ԭ����byte [] �ֽ�����

�����ַ����ĳ���3+1�ַ���
���ֹ��췽����
    1��public String()������һ���հ��ַ����������κ�����
    2��public String(char[] array)�������ַ���������ݣ���������Ӧ���ַ���
    3��public String(byte[] array)�������ֽ���������ݣ���������Ӧ���ַ���
    4��ֱ�Ӵ���
*/

public class Demo25String {
    public static void main(String[] args) {
        //�ղ�������
        String str1 = new String();
        System.out.println(str1);

        //�����ַ����鴴���ַ���
        char[] charArray = {'a','d','e'};
        String str2 = new String(charArray);
        System.out.println(str2);

        //�����ֽ����鴴���ַ���
        byte[] byteArra = {97,98,99};
        String str3 = new String(byteArra);
        System.out.println(str3);

        /*
        �ַ��������أ�������ֱ��д�ϵ�˫�����ַ����������ַ����������С�

        ���ڻ���������˵ == �ǽ�����ֵ�ıȽ�
        ��������������˵ == �ǽ��е�ֵַ�ıȽ�   ��Ҫ���ַ������ݽ��бȽϣ�����ʹ����������
        public boolean equals(Object obj)�������������κζ���ֻ�в�����һ���ַ�������������ͬ�Ż��true�����򷵻�false
        ��ע���κζ�������Object���н���
              equals�������жԳ��ԣ�Ҳ����a.equals(b)��b.equals(a)Ч��һ��
              ����Ƚ�˫��һ������һ���������Ƽ��ѳ����ַ���д��ǰ��
              �Ƽ���"abc".equals(str)   ���Ƽ���str.equals("abc")
        public boolean equalsIgnoreCase(String str)�����Դ�Сд�������ݱȽ�
        */
        String str4 = "Hello";
        String str5 = "Hello";
        char[] charArra = {'H','e','l','l','o'};
        String str6 = new String(charArra);
        System.out.println(str4.equals(str5));
        System.out.println(str5.equals(str6));
        System.out.println(str5.equals("Hello"));
        System.out.println("Hello".equals(str4));
        System.out.println("======================");
        String str7 = null;
        System.out.println("Hello".equals(str7));//�Ƽ�
        //System.out.println(str7.equals("Hello"));//���Ƽ���������ָ���쳣��NullPointerException
        System.out.println("=================");
        String strA = "Java";
        String strB = "java";
        System.out.println(strA.equals(strB));
        System.out.println(strA.equalsIgnoreCase(strB));
    }

}
