package cn.learn.Data.Basic.CommonAlgorithm;
/*
    KMP�㷨��
        Ӧ�ó���-�ַ���ƥ������
            ��һ���ַ��� str1 = "���� �й�����Ϲ� �й�����й�����й�����"
            ��һ���Ӵ�   str2 = "�й�����й����"
            ����Ҫ�ж�str1�Ƿ���str2��������ڣ��ͷ��ص�һ�γ��ֵ�λ�ã����û���򷵻�-1
        ����ñ���ƥ���˼·������������str1ƥ�䵽iλ�ã��Ӵ�str2ƥ�䵽jλ�ã����У�
            1�������ǰ�ַ���ƥ��ɹ�����str1[i] == str2[j])����i++��j++����ƥ����һ���ַ�
            2�����ʧ�䣨��str1[i] != str2[j]������i = i - (j-1), j=0���൱��ƥ��ʧ��ʱ��i���ݣ�j����Ϊ0
            3���ñ�����������Ļ��ͻ��д����Ļ��ݣ�ÿ��ֻ�ƶ�һλ�����ǲ�ƥ�䣬�ƶ�����һλ�����жϣ��˷��˴�����ʱ��
            4������ƥ���㷨ʵ��

        KMP�㷨��
            String str1 = "BBC ABCDAB ABCDABCDABDE";
            String str2 = "ABCDABD"
            ������ƥ��ֵ������ ǰ׺ �� ��׺ �������Ԫ�صĳ���
            a ��ǰ׺�ͺ�׺��Ϊ�ռ�������Ԫ�س���Ϊ0
            ab ��ǰ׺Ϊa����׺Ϊb������Ԫ�صĳ���Ϊ0
            abc ��ǰ׺Ϊ[a, ab], ��׺Ϊ[bc,c] ����Ԫ��Ϊ0
            abcd ǰ׺[a,ab,abc] ��׺[bcd,cd,d]����Ԫ��Ϊ0
            abcda ǰ׺[a,ab,abc,abcd] ��׺[bcda,cda,da,a]����Ԫ��Ϊa, ����Ϊ1
            abcdab ǰ׺[a,ab,abc,abcd,abcda] ��׺[bcdab,cdab,dab,ab,b]����Ԫ��Ϊab ����Ϊ2

            abcdabd ǰ׺Ϊ[a,ab,abc,abcd,abcda,abcdab] ��׺Ϊ[bcdabd,cdabd,dabd,abd,bd,d]����Ԫ��Ϊ0
*/

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str1 = "���� �й�����Ϲ� �й�����й�����й�����";
        String str2 = "�й�����й����";
        int index = violenceMatch(str1, str2);//����ƥ��
        System.out.println(index);

        str1 = "BBC ABCDAB ABCDABCDABDE";
        str2 = "ABCDABD";
        int[] next = KMPNext("ABCDABD");
        System.out.println(Arrays.toString(next));
        index = KMPSearch(str1, str2, next);//kmp�㷨
        System.out.println(index);
    }

    //��ȡ���ַ��Ĳ���ƥ��ֵ
    public static int[] KMPNext(String dest) {
        //����һ��next���鱣�沿��ƥ��ֵ
        int[] next = new int[dest.length()];
        next[0] = 0;//����ַ�������Ϊ1������ƥ��ֵ����0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //dest.charAt(i) != dest.charAt(j) ������Ҫ��next[j-1] ��ȡ�µ�j
            //ֱ�������� dest.charAt(i) == dest.charAt(j) �������˳�
            //��ʱkmp�㷨�ĺ��ĵ�
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }

            //dest.charAt(i) == dest.charAt(j) ��������ʱ������ƥ��ֵ����+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * @param str1  Դ�ַ���
     * @param str2  ���ַ���
     * @param next  ����ƥ������Ӵ���Ӧ�Ĳ���ƥ���
     * @return �����-1����û��ƥ�䵽�����򷵻ص�һ��ƥ���λ��
    */
    public static int KMPSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {

            //�������ʱ
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j -1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            if (j == str2.length()) {
                return i-j+1;
            }
        }
        return -1;
    }

    //����ƥ���㷨ʵ��
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;
        int j = 0;
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j-1);
                j = 0;
            }
        }

        //�ж��Ƿ�ƥ��ɹ�
        if (j == s2Len) {
            return i-j;
        } else {
            return -1;
        }
    }
}
