package cn.learn.basic.Demo01;
/*
��������������������װ���̳С���̬

��װ����Java�е�����
  1����������һ�ַ�װ
  2���ؼ���privateҲ��һ�ַ�װ
��װ���ǽ�һЩϸ����Ϣ����������������粻�ɼ�
*/

public class Demo17Method {
    public static void main(String[] args) {
        int[] array = {15, 15, 2, 0, 11, 1};

        int max = getMax(array);
        System.out.println("���ֵ" + max);
    }

    //����һ�����飬�Ҹ���һ�����ֵ
    public static int getMax(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
}
