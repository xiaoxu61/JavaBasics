package cn.learn.basic.Demo25;
/*
�ָ��ַ����ķ�����
   public String[] split(String regex)�����ղ����Ĺ��򣬽��ַ����г����ɲ���
   ע�⣺split�����Ĳ�����ʵ��һ����������ʽ�������ѧϰ
   ����Ҫע�⣺���Ӣ�ľ��"."�����з֣�����д"\\."��������б�ܣ�
*/

public class Demo25StringSplit {
    public static void main(String[] args) {
        String str1 = "aaa,bbb,ccc";
        String[] array1 = str1.split(",");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(" ��" + i + "����");
            System.out.print(array1[i]);
        }
        System.out.println();
        System.out.println("=================");
        String str2 = "aaa bbb ccc";
        String[] array2 = str2.split(" ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(" ��" + i + "����");
            System.out.print(array2[i]);
        }
        System.out.println();
        System.out.println("==================");

        String str3 = "XXX.YYY.ZZZ";
        String[] array3 = str3.split(".");
        System.out.println(array3.length);
        for (int i = 0; i < array3.length; i++) {
            System.out.print(" ��" + i + "����");
            System.out.print(array3[i]);
        }
        System.out.println("===========================");
        String[] array4 = str3.split("\\.");
        System.out.println(array4.length);
        for (int i = 0; i < array4.length; i++) {
            System.out.print(" ��" + i + "����");
            System.out.print(array4[i]);
        }
    }
}
