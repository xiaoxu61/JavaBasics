package cn.learn.Data.Basic.CommonAlgorithm;
/*
    KMP算法：
        应用场景-字符串匹配问题
            有一个字符串 str1 = "硅硅谷 尚硅谷你上硅 尚硅谷你尚硅谷你尚硅谷你好"
            和一个子串   str2 = "尚硅谷你尚硅谷你"
            现在要判断str1是否含有str2，如果存在，就返回第一次出现的位置，如果没有则返回-1
        如果用暴力匹配的思路，并假设现在str1匹配到i位置，子串str2匹配到j位置，则有：
            1、如果当前字符串匹配成功（即str1[i] == str2[j])，则i++，j++继续匹配下一个字符
            2、如果失配（即str1[i] != str2[j]），令i = i - (j-1), j=0。相当于匹配失败时，i回溯，j被置为0
            3、用暴力方法解决的话就会有大量的回溯，每次只移动一位，若是不匹配，移动到下一位接着判断，浪费了大量的时间
            4、暴力匹配算法实现

        KMP算法：
            String str1 = "BBC ABCDAB ABCDABCDABDE";
            String str2 = "ABCDABD"
            【部分匹配值】就是 前缀 和 后缀 的最长共有元素的长度
            a 的前缀和后缀都为空集，共有元素长度为0
            ab 的前缀为a，后缀为b，共有元素的长度为0
            abc 的前缀为[a, ab], 后缀为[bc,c] 共有元素为0
            abcd 前缀[a,ab,abc] 后缀[bcd,cd,d]共有元素为0
            abcda 前缀[a,ab,abc,abcd] 后缀[bcda,cda,da,a]共有元素为a, 长度为1
            abcdab 前缀[a,ab,abc,abcd,abcda] 后缀[bcdab,cdab,dab,ab,b]共有元素为ab 长度为2

            abcdabd 前缀为[a,ab,abc,abcd,abcda,abcdab] 后缀为[bcdabd,cdabd,dabd,abd,bd,d]共有元素为0
*/

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你上硅 尚硅谷你尚硅谷你尚硅谷你好";
        String str2 = "尚硅谷你尚硅谷你";
        int index = violenceMatch(str1, str2);//暴力匹配
        System.out.println(index);

        str1 = "BBC ABCDAB ABCDABCDABDE";
        str2 = "ABCDABD";
        int[] next = KMPNext("ABCDABD");
        System.out.println(Arrays.toString(next));
        index = KMPSearch(str1, str2, next);//kmp算法
        System.out.println(index);
    }

    //获取到字符的部分匹配值
    public static int[] KMPNext(String dest) {
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串长度为1，部分匹配值就是0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //dest.charAt(i) != dest.charAt(j) 我们需要从next[j-1] 获取新的j
            //直到发现有 dest.charAt(i) == dest.charAt(j) 成立才退出
            //这时kmp算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }

            //dest.charAt(i) == dest.charAt(j) 条件满足时，部分匹配值就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * @param str1  源字符串
     * @param str2  子字符串
     * @param next  部分匹配表，是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
    */
    public static int KMPSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {

            //处理不相等时
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

    //暴力匹配算法实现
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

        //判断是否匹配成功
        if (j == s2Len) {
            return i-j;
        } else {
            return -1;
        }
    }
}
