package cn.learn.basic.Demo34Main;
/*
�ֲ��ڲ��࣬���ϣ���������ڷ����ľֲ���������ô����ֲ����������ǡ���Чfinal�ġ�

��ע����Java 8+��ʼ��ֻҪ�ֲ���ʵ���䣬��ôfinal�ؼ��ֿ���ʡ��

ԭ��
    1��new�����Ķ����ڶ��ڴ浱��
    2���ֲ������Ǹ��ŷ����ߵģ���ջ�ڴ浱��
    3���������н�����������ջ���ֲ������ͻ�������ʧ
    4������new�����Ķ�����ڶѵ��г������ڣ�ֱ������������ʧ
*/

public class MyOuter {

    public void methodOuter() {
        final int num = 10;//���ڷ����ľֲ�����

        class MyInner{
            public void methodInner() {
                System.out.println(num);
            }
        }
    }

}
