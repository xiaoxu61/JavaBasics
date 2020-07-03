package cn.learn.basic.Demo07Error;

public class Demo03Exception {
    public static void main(String[] args) {
        int avg = getAvg(50, 25, 65, 30, -40);
        System.out.println(avg);
    }
    /*
        ���ݳɼ�������ɼ���ƽ����
        �ɼ�û�и�������Ҫ�׳��쳣��ֹͣ����
    */
    private static int getAvg(int...sourse) {
        int sum = 0;
        for (int s : sourse) {
            if (s < 0) {
                throw new FuShuException("�ɼ�����" + s);
            }
            sum = sum + s;
        }
        return sum/sourse.length;
    }
}
