package cn.learn.basic.Demo25;
/*
    将字符串的首字母转换成大写，其他内容转成小写
        思想：
            获取首字母subString(0,1),转成大写toUpperCase()

            获取剩余字符串，subString(1); toLowerCase()
*/

public class Demo04StringConver {
    public static void main(String[] args) {
        String s = toConvert("aFIUFCUSHU");
        System.out.println(s);
    }
    public static String toConvert(String str) {
        String first = str.substring(0,1);
        String after = str.substring(1);
        //调用String类方法，大写，小写转换
        first = first.toUpperCase();
        after = after.toLowerCase();

        return first.concat(after);

    }
}
