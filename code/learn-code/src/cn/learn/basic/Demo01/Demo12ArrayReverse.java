package cn.learn.basic.Demo01;
/*
  1������Ԫ�ط�ת����ʵ���ǶԳ�λ�õ�Ԫ�ؽ���
  2��ͨ�����������õ���һ��������
     int i = 0;
     ���ڱ�ʾ�Գ�λ����Ҫ����������
     int min = 0;
     int max = array.length - 1;
  3����ν�������������ֵ
     ��Ҫһ���м���
  4��ʲôʱ��ֹͣ����?
     (1) ��min = max ������
     (2) ��min > max ż����
     �� min < max ʱ�ͽ���������ֹͣ

*/

public class Demo12ArrayReverse {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        printArray(array);
        System.out.println("================");
        /*
        ��ʼ����䣺int min = 0��max = array.length - 1
        �����жϣ�min < max
        �������ʽ��min++, max--
        ѭ���壺�õ�������������
        */
        for(int min = 0, max = array.length - 1; min < max; min++, max--){
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }
        printArray(array);
    }
    /*
    ���������Ϊ�����Ĳ���
    �����÷�����ʱ���򷽷���С���Ž��д��Σ����ݽ�ȥ����ʵ������ĵ�ֵַ
    */
    public static void printArray(int[] array) {
        System.out.println("�����յ��Ĳ����ǣ�" + array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
