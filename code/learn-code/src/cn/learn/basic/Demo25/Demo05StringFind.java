package cn.learn.basic.Demo25;
/*
查询大字符串中，出现指定小字符串的次数，如"hellojava,nihaojava,javazhenhao",
    中查询出现java的次数
*/

public class Demo05StringFind {
    public static void main(String[] args) {
        String big = "hellojava,nihaojava,javazhenhao";
        String small = "java";
        int i = findCount(big, small);
        System.out.println(i);
    }
    public static int findCount(String big, String small) {
        int count = 0;
        while (true) {
            int index = big.indexOf(small);
            if (index < 0){
                return count;
            }else if(index >= 0){
                big = big.substring(index + 1);
                count++;
            }
        }
    }
}
