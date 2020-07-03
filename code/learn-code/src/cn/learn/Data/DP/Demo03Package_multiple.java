package cn.learn.Data.DP;
/*
    ��N����Ʒ��һ��������V�ı���
        ��i����Ʒ�����s[i]����ÿ�������v[i]����ֵ��w[i]
        ��⽫��Щ��Ʒ���뱳������ʹ��Ʒ������Ͳ������������������ܼ�ֵ���
*/

import java.util.Arrays;

public class Demo03Package_multiple {
    public static void main(String[] args) {
        getValue(7);
        getMaxValue(7);
    }

    /**
     * �Ż���Ķ��ر�������
     *      ���Խ���Ʒ�ĸ�����ֺ�ŵ���Ʒ�У�ת��Ϊ01��������
     *      Ҳ����˵����i����Ʒ�����s[i]����ÿ�������v[i]����ֵ��w[i]
     *            ��s����Ʒ��ӵ���Ʒ��
     *      �����ƵĲ𷨣�
     *          0
     *          1
     *          2
     *          3 = 1 + 2
     *          4 = 4
     *          5 = 1 + 4
     *          6 = 2 + 4
     *          7 = 1 + 2 + 4
     *     s���ٰ�s��Ϊ���ٸ���������ƴ��С�ڵ���s������log ��2Ϊ�׵�s������ȡ��
     *
    */
    private static void getMaxValue(int N) {

    }

    /**
     * f[i]�������i������£�����ֵ�Ƕ���
     *    for (int i = 0; i < V.length; i++) {
     *       for (int j = V[i]; j <= N; j++) {
     *           if (i == 0) {
     *               f[j] = 0;
     *           }else {
     *               f[j] = Math.max(f[j], f[j - V[i]] + W[i], f[j - 2*V[i]] + 2*W[i],...,f[j - s*V[i]] + s*W[i]);
     *           }
     *       }
     *     }
    */
    private static void getValue(int N) {
        int[] V = {0,2,3,4};//��Ʒ������
        int[] W = {0,3,4,5};//��Ʒ�ļ�ֵ
        int[] S = {0,2,2,1};//��Ʒ�ĸ���
        int[] f = new int[N+1];

        for (int i = 0; i < V.length; i++) {
            for (int j = N; j >= 0; j--) {
                for (int k = 1; k <= S[i] && j >= k*V[i]; k++) {
                    f[j] = Math.max(f[j], f[j - k*V[i]] + k*W[i]);
                }
            }
        }
        System.out.println(f[N]);
        System.out.println(Arrays.toString(f));
    }
}
