package cn.learn.basic.Demo07Error;

public class Demo03Exception {
    public static void main(String[] args) {
        int avg = getAvg(50, 25, 65, 30, -40);
        System.out.println(avg);
    }
    /*
        传递成绩，计算成绩的平均数
        成绩没有负数，需要抛出异常，停止运算
    */
    private static int getAvg(int...sourse) {
        int sum = 0;
        for (int s : sourse) {
            if (s < 0) {
                throw new FuShuException("成绩错误：" + s);
            }
            sum = sum + s;
        }
        return sum/sourse.length;
    }
}
