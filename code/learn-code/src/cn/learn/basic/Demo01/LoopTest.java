package cn.learn.basic.Demo01;

/*
   ����ѭ���������ĸ������дСд��52��
   ���A~Z a~z
   ���ñ����ʵ����ĸ�����ֵĶ�Ӧ��ϵ
   A~Z 65~90
   a~z 97~122

   ʵ�ֲ��裺
      1���������������Сдa����дA
      2��ѭ��26�Σ��������õı���
         ÿ��ѭ������++
 */
public class LoopTest {
    public static void main(String[] args){
        //�������������������ĸ
        char xiaoxie = 'a';
        char daxie = 'A';
        //����ѭ��������26��
        for(int i = 0; i < 26; i++){
            System.out.print(xiaoxie+""+daxie);
            daxie++;
            xiaoxie++;
        }
    }
}
