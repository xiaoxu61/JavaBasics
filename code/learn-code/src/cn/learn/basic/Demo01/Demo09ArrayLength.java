package cn.learn.basic.Demo01;
/*
  ��λ�ȡ����ĳ���
  ��ʽ����������.length
  ����ĵ�һ��int���֣���������ĳ��ȡ�

  ����һ�����������������ڼ䳤�Ȳ��ɸı�
*/

public class Demo09ArrayLength {
    public static void main(String[] args) {
        int[] arrayA = new int[3];
        int[] arrayB = {10, 20, 30, 3, 5, 6, 65,56, 564};
        int len = arrayB.length;
        System.out.println("arrayB����ĳ����ǣ�" + len);

        int[] arrayC = new int[3];
        System.out.println("arrayB����ĳ����ǣ�" + arrayC.length);
        arrayC = new int[5];
        System.out.println("arrayB����ĳ����ǣ�" + arrayC.length);
    }
}
