package cn.learn.basic.Demo25;
/*
��ѯ���ַ����У�����ָ��С�ַ����Ĵ�������"hellojava,nihaojava,javazhenhao",
    �в�ѯ����java�Ĵ���
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
