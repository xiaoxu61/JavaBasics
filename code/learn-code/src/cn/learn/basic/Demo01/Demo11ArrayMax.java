package cn.learn.basic.Demo01;
/*


*/

public class Demo11ArrayMax {
    public static void main(String[] args) {
        int[] array = {5, 10, 15, 20, 40, 10000};
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            //�����ǰԪ�ر�max��������
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }

        }
        System.out.println("���������ֵ:" + max);
        System.out.println("��������Сֵ:" + min);
    }
}
