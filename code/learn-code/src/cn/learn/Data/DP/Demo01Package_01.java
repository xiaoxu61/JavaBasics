package cn.learn.Data.DP;
/*
    01��������
        ��N����Ʒ��һ��������V�ı���
        ��i����Ʒ�������Vi����ֵ��Wi
        ��⽫��Щ��Ʒװ�뱳��������ʹ����Щ��Ʒ����������������������������ܼ�ֵ���

        �����ʽ��
            ��һ������������N��V���ÿո�������ֱ��ʾ��Ʒ�������ͱ����ݻ�
            ��������N�У�ÿ��������V[i]��W[i]���ÿո�������ֱ��ʾ��i����Ʒ������ͼ�ֵ
        �����ʽ��
            ���һ����������ʾ����ֵ
        ���ݷ�Χ��
            0 < N, V <= 1000
            0 < V[i], W[i] <= 1000
        ����������
            4 5
            1 2
            2 4
            3 4
            4 5
        ���������
            8
*/


import java.util.Arrays;

public class Demo01Package_01 {
    public static void main(String[] args) {
        getValue(7);
        getMaxValue(7);
    }

    /**
     * �Ż��ռ临�ӶȺ��01��������
     * <p>
     * ���裺
     * �ȳ�ʼ������f[] = {0,0,0,0,0,0,0}  ����f[n]�е�n������������
     * ����һ����Ʒʱ ������������������ڸ���Ʒ�����Сʱ���������ܵõ�������ֵf[] = {0,0,3,3,3,3,3,3}
     * ����������Ʒʱ ������������������ڸ���Ʒ�����Сʱ���������ܵõ�������ֵf[] = {0,0,3,4,4,7,7,7}
     * ����������Ʒʱ ������������������ڸ���Ʒ�����Сʱ���������ܵõ�������ֵf[] = {0,0,3,4,5,7,8,9}
     */
    public static void getMaxValue(int N) {
        int[] V = {0, 2, 3, 4};
        int[] W = {0, 3, 4, 5};

        int f[] = new int[N + 1];
        for (int i = 0; i < V.length; i++) {
            for (int j = N; j >= V[i]; j--) {
                f[j] = Math.max(f[j], f[j - V[i]] + W[i]);
            }
        }

        System.out.println(Arrays.toString(f));

    }

    /**
     * ��ά�Ķ�̬�滮
     * f[i][j] ��ʾֻ��ǰi����Ʒ���������j������£��ܼ�ֵ����Ƕ���
     * result = max{f[n][0~V]}
     * f[i][j]:
     * 1����ѡ��i����Ʒ��f[i][j] = f[i-1][j]
     * 2��ѡ��i����Ʒ��f[i][j] = f[i-1][j - V[i]] + W[i]
     * f[i][j] = max{1,2} ת�Ʒ���
     * <p>
     * f[0][0] = 0;
     * @param N    ��������
     * @return     ����ܼ�ֵ
     */
    public static void getValue(int N) {
        int[] V = {0, 2, 3, 4};
        int[] W = {0, 3, 4, 5};

        int f[][] = new int[V.length][N + 1];
        /*for (int i = 1; i < V.length; i++) {
            for (int j = 0; j <= N; j++) {
                if (j == 0) {
                    f[i][j] = 0;
                }else {
                    f[i][j] = f[i - 1][j];
                }
                if (j >= V[i]) {
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j - V[i]] + W[i]);
                }
            }
        }*/
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < V.length; j++) {
                if (i == 0 || j == 0) {
                    f[j][i] = 0;
                } else {
                    f[j][i] = f[j - 1][i];
                    if (i >= V[j]) {
                        f[j][i] = Math.max(f[j - 1][i], f[j - 1][i - V[j]] + W[j]);
                    }
                }
            }
        }

        System.out.println(f[V.length - 1][N]);
    }

}
