package cn.learn.basic.Demo28;
/*
��Ŀ
������-10.8��5.9֮�䣬���Դ���6 ����С��2.1�������ж��ٸ���

������
1����Ȼ�Ѿ�ȷ���˷�Χ��forѭ��
2�����λ��-10.8Ӧ��ת����-10
   2.1������ʹ��Math.ceil����������ȡ��
   2.2��ǿת��Ϊint���Զ���������С��λ
3��ÿһ�����ֶ������������Բ������ʽӦ����num++��ÿ����������+1
4������õ�����ֵ��Math.abs����
5��һ�����������֣���Ҫ�ü���������ͳ��

��ע�����ʹ��Math.ceil������-10.8���Ա��-10.0.ע��doubleҲ�ǿ��Խ���++��
*/

public class Demo28MathPractise {
    public static void main(String[] args) {
        double min = -10.8;
        double max = 5.9;
        int count = 0;
        //������������i��������֮�����е�����
        for(int i = (int)min; i < max; i++){
            int abs = Math.abs(i);//����ֵ
            if (abs > 6 || abs < 2.1) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("�ܹ��У�" + count);
    }
}
