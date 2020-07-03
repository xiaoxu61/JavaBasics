package cn.learn.Data.Basic.CommonAlgorithm;
/*
�������⣺
    ��һ������������Ϊ4��������������Ʒ
    ��Ʒ    ����     �۸�
    ����     1       1500
    ����     4       3000
    ����     3       2000
 1��Ҫ��ﵽ��Ŀ��ΧΪװ��ı������ܼ�ֵ��󣬲�������������
 2��Ҫ��װ�����Ʒ�����ظ�
    W[i] �� V[i] ��ȷ���Ƿ���Ҫ������Ʒ���뵽�����У�V[i] W[i]�ֱ�Ϊ��i����Ʒ�ļ�ֵ��������CΪ����������
����V[i][j]��ʾ��ǰi����Ʒ���ܹ�װ������Ϊj�ı����е�����ֵ��������������Ľ����
    1��V[i][0] = V[0][j] = 0; ��ʾ����� ��һ�к͵�һ����0
    2����W[i] > j ʱ��V[i][j] = V[i-1][j]; ��׼��������������Ʒ���������ڵ�ǰ����������ʱ����ֱ��
ʹ����һ����Ԫ��װ�����
    3����j >= W[i]ʱ��V[i][j] = max{ V[i-1][j], V[i]+V[i-1][j-W[i]] }
    //��׼���������������Ʒ������С�ڵ��ڵ�ǰ������������
    //װ��ķ�ʽ��
        V[i-1][j]: ������һ����Ԫ���װ������ֵ
        V[i]: ��ʾ��ǰ��Ʒ�ļ�ֵV[i-1][j-W[i]]: װ��i-1��Ʒ����ʣ��ռ�j-W[i]
*/

import java.util.Arrays;

public class Package {
    public static void main(String[] args) {
        int [] w = {0,1,4,3};//��Ʒ������
        int [] val = {0,1500,3000,2000};//��Ʒ�ļ�ֵ
        int m = 4;//����������
        int n = val.length;//��Ʒ�ĸ���



        //������ά����
        int[][] v = new int[n][m+1];
        //Ϊ�˼�¼��Ʒ�����������һ����ά����
        int[][] path = new int[n][m+1];

        //��ʼ����һ�к͵�һ��
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++ ) {
            v[0][i] = 0;
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i] > j) {
                    v[i][j] = v[i-1][j];
                }else {
                    //v[i][j] = Math.max(v[i-1][j],v[i-1][j-w[i]] + val[i]);
                    //Ϊ�˼�¼��Ʒ���������
                    if (v[i-1][j] < (v[i-1][j-w[i]] + val[i])) {
                        v[i][j] = v[i-1][j-w[i]] + val[i];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        show(v);
        System.out.println("��Ʒ��ŷ�����");
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("��%d����Ʒ���뵽����\n", i);
                j -= w[i];
            }
            i--;
        }
    }

    public static void show(int[][] v) {
        for (int[] arr : v) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
