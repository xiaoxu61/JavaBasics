package cn.learn.basic.Demo01;

/*
   ����1~100֮�������������

   ��һ�����ݴ�0�䵽100 ѭ�� int = 0 <= 100 ++
   ��0~100��Χ���ҵ����� ��%2==1 ����
   ���е�������ͼ���
   ��Ҫ�������������������

   ʵ�ֲ��裺
     1���������ʹ�õ������ݣ�Ԥ�ȶ���ñ���
        ��Ҫ������
     2������ѭ�����ñ�����0�䵽100
     3���жϱ����ı仯����ǲ�������
     4���������������Ԥ�ȶ���õı��� ���
 */
public class jiSuan {
    public static void main(String[] args){
        //����������������
        int sum = 0;
        int sum1 = 0;
        //for ѭ����ѭ���еı���0~100
        for(int i = 0; i <= 100; i++){
            //��ѭ���ı��������������ж�
            if(i %2 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
        //�򻯵�ѭ��
        for(int i = 1; i <= 100; i += 2){
            sum1 += i;
        }
        System.out.println(sum1);

        /*
           Ҫ������ˮ�ɻ���
           ��λ��100~999 ��λ��������+ʮλ��������+��λ�������� = �Լ�����
           153 = 1*1*1+5*5*5+3*3*3
           ��֪��λ�� 123 ��ȡ��ÿ����λ ���ó��� ȡģ����
           ʵ�ֲ��裺
              1����������洢 ������λ�ϵ���
              2������ѭ����ѭ���еı�����100�仯��999
              3��ѭ���еõ���λ�� �����㷨����������λ����
              4��������λ����������ͼ��㣬��������ͣ������Լ����бȽ�
                 ��ͬ������ˮ�ɻ�
         */
        //������������
        int bai = 0;
        int shi = 0;
        int ge = 0;
        //ѭ�� 100~999
        for(int i = 100; i < 1000; i++){
            //��i�����м��㣬��ȡ������λ
            //��ȡ��λ
            bai = i / 100;
            //��ȡʮλ
            shi = i / 10 % 10;
            //��ȡ��λ
            ge = i % 10;
            if(bai*bai*bai + shi*shi*shi + ge*ge*ge == i){
                System.out.println(i);
            }
        }

    }
}