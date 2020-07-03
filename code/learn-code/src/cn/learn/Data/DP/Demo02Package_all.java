package cn.learn.Data.DP;
/*
    ��ȫ��������
        ��N����Ʒ��һ��������V�ı�����ÿ����Ʒ�������޼�����
        ��i����Ʒ�������V[i]����ֵ��W[i]
        ��⽫��Щ��Ʒװ�뱳������ʹ��Щ��Ʒ������������������������Ҽ�ֵ���
    �����ʽ��
        ��һ������������N��V �ÿո�������ֱ��ʾ��Ʒ���ͱ����ݻ�
        ��������N�У� ÿ����������V[i]��W[i] �ÿո�������ֱ��ʾ��i����Ʒ������ͼ�ֵ
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

public class Demo02Package_all {
    public static void main(String[] args) {
        getValue(7);
        getMaxValue(7);
    }

    /**
     * f[i]��ʾ �������i������£�����ֵ�Ƕ���
     * result = max{f[0~m]}
     *
     * for (int i = 0; i < V.length; i++) {
     *             for (int j = V[i]; j <= m; j++) {
     *                f[j] = Math.max(f[j],f[j - V[i]] + W[i]);
     *             }
     *             for (int j = m; j >= V[i]; j--) {
     *                 for (int k = 0; k*V[i] <= m; k++) {
     *                     f[j] = max{f[j], f[j - k*V[i]] + k*W[i]}
     *                 }
     *             }
     *         }
     *
     * ��ѧ���ɷ���
     *     1�����迼��ǰi-1����Ʒ֮�����е�f[j]������ȷ��
     *     2����֤�����������i����Ʒ֮�����е�f[j]Ҳ������ȷ��
     * �Ա���Ϊ0~7��������СΪ����������Ʒ��Ľ�����£�
     *   {0,0,0,0,0,0,0,0}  ǰ0����Ʒ
     *   {0,0,3,3,6,6,9,9}  ǰ1��Ʒ����ʱ
     *   {0,0,3,4,6,7,9,10} ǰ������Ʒ����ʱ
     *   {0,0,3,4,6,7,9,10} ǰ������Ʒ����ʱ
     *
     *  ����ĳ��j���ԣ�������Ž��а���k��V[i]
    */
    public static void getMaxValue(int N) {
        int[] V = {0,2,3,4};
       int[] W = {0,3,4,5};
        int f[] = new int[N+1];

        for (int i = 0; i < V.length; i++) {
            for (int j = V[i]; j <= N; j++) {
                if (i == 0) {
                    f[j] = 0;
                }else {
                    f[j] = Math.max(f[j],f[j - V[i]] + W[i]);
                }
            }
        }
        System.out.println(f[N]);
        System.out.println(Arrays.toString(f));
    }

    /**
     * �ö�ά˼������ȫ��������
     *      ״̬ת�Ʒ��̣�f[i][j] = max{f[i-1][j],f[i-1][j-k*V[i]] + W[i]}
     *      ��ʼ����f[0][0] = 0;
    */
    public static void getValue(int N) {
        int[] V = {0,2,3,4};
        int[] W = {0,3,4,5};
        int f[][] = new int[V.length][N+1];

        for (int i = 0; i < V.length; i++) {
            for (int j = 0; j <= N; j++) {
                if (j == 0 || i == 0) {
                    f[i][j] = 0;
                }else {
                    f[i][j] = f[i-1][j];
                    if (j >= V[i]) {
                       // int max = 0;
                        for (int k = 1; j >= k * V[i]; k++) {
                            //if (max < f[i-1][j - k*V[i]] + k*W[i]) {
                               // max = f[i - 1][j - k * V[i]] + k * W[i];
                           // }
                            f[i][j] = Math.max(f[i][j],f[i - 1][j - k * V[i]] + k * W[i]);
                        }
                        //f[i][j] = Math.max(f[i-1][j],max);
                    }
                }
            }
        }
        System.out.println(f[V.length - 1][N]);
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
    }
}
