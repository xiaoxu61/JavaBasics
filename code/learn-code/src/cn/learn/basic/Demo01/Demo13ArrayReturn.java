package cn.learn.basic.Demo01;
/*
  һ������������0��1���������������ֻ����0����1������ֵ�������ж������ֵ
  ���ϣ����һ���������в����˶��������ݽ��з��أ���ô�죿
  ���������ʹ��һ��������Ϊ����ֵ���ͼ��ɡ�

  �κ��������Ͷ�����Ϊ���������ݲ��������߷���ֵ����

  ������Ϊ�����Ĳ��������ݽ�ȥ����ʵ��������ĵ�ֵַ
  ������Ϊ�����ķ���ֵ�����ص�Ҳ������ĵ�ֵַ
*/

public class Demo13ArrayReturn {
    public static void main(String[] args) {
        int[] result = calculate(10,20,30);
        System.out.println("�ܺͣ�" + result[0]);
        System.out.println("ƽ������" + result[1]);
    }
    public static int[]  calculate(int a, int b, int c){
        int sum = a + b + c;  //�ܺ�
        int avg = sum/3;      //ƽ����
        //���������ϣ�����з���
        //��Ҫһ�����飬����������ֵ
        int[] array = new int[2];
        array[0] = sum;
        array[1] = avg;
        return array;
    }
}
