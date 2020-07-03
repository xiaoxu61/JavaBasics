package cn.learn.Data.Basic;
/*
���⣺��8x8�����̸��ϰڷŰ˸��ʺ����������ʺ󶼲��ܴ���ͬһ�С�ͬһ�С�ͬһб���ϣ����ж����ְڷ�
    �˻ʺ������˼·������
        1����һ���ʺ��ȷŵ�һ�У���һ��
        2���ڶ����ʺ���ڵڶ��У���һ�У�Ȼ���ж��Ƿ�OK�������OK���������ڵڶ��С������С����ΰ������з��꣬�ҵ�һ������
        3�������������ʺ�....ֱ����8���ʺ�Ҳ�ܷ���һ������ͻ��λ�ã��������ҵ���һ������
        3�����õ�һ���������ջ���˵���һ��ջʱ����ʼ���ݣ�������һ���ʺ󣬷ŵ���һ�е��������⣬ȫ���õ�
        4��Ȼ���ͷ������һ���ʺ�ŵڶ��У��������ִ��1��2��3��4����
*/

public class Demo10Queen8 {
    //����һ��max��ʾ���ж��ٸ��ʺ�
    int max = 8;
    //��������array������ʺ����λ�õĽ������ arr = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        new Demo10Queen8().check(0);
        System.out.println("�ܹ��ⷨ��" + count);
        System.out.println("z�ܹ��ж����ٴ�" + judgeCount);
    }

    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            judgeCount++;
            //�Ȱѵ�ǰ�ʺ󣬷ŵ����еĵ�һ��
            array[n] = i;
            if (judge(n)) {
                //������ͻ�����ŷ�n+1�ʺ�
                check(n+1);
            }
            //�����ͻ���ͼ���ִ��array[n] = i���� ����n���ʺ󣬷����ڱ��е� ����һ��λ��
        }
    }
    //�ж��Ƿ��ͻ���鿴���Ƿ��õ�n���ʺ�ʱ�����ûʺ��Ƿ��ǰ���ѰڷŻʺ��ͻ
    private boolean judge(int n) {

        for (int i = 0; i < n; i++) {
            //   ��ʾ�Ƿ���ͬһ��                ��ʾ�Ƿ���ͳһб��
            if (array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

    //�ʺ�ڷ�λ�õ����
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
