package cn.learn.basic.Demo01;

/*
  ʵ����Ʒ����嵥����
      ���裺1��ʵ�ִ�ӡ��ͷ���ǹ̶����ݣ�ֱ��д������
	        2������м䣬��Ʒ���ݲ��ñ�����ʽ������������Ҷ���������
			   ������б���
			3������β��һ�������ݹ̶�
			   ��һ������Ҫͨ����Ʒ���ݽ�����ѧ����
*/
public class Shop{
	public static void main(String[] args){
		//����̶�����
		System.out.println("----------------�̳ǿ���嵥-----------");
		System.out.println("Ʒ���ͺ�      �ߴ�      �۸�     �����");
		//�������е����ݱ���
		//Ʒ������String���ߴ�double���۸�double�����int
		String macBrand = "MacBookAir";
		double macSize = 13.3;
		double macPrice = 6988.88;
		int    macCount = 5;
		
		String thinkBrand = "ThinkPadT450";
		double thinkSize = 14;
		double thinkPrice = 5999.99;
		int    thinkCount = 10;
		
		String asusBrand = "ASUS-FL5800";
		double asusSize = 15.6;
		double asusPrice = 4999.5;
		int    asusCount = 18;
		//��Ʒ��Ϣ�������д�ӡ������֮�����һ�����ַ����ո�
		System.out.println(macBrand+"    "+macSize+"     "+macPrice+"     "+macCount);
		System.out.println(thinkBrand+"  "+thinkSize+"     "+thinkPrice+"    "+thinkCount);
		System.out.println(asusBrand+"   "+asusSize+"     "+asusPrice+"     "+asusCount);
		//������������������Ʒ����������
		int totalCount = macCount + thinkCount + asusCount;
		double totalMoney = macCount * macPrice + thinkCount * thinkPrice + asusCount * asusPrice;
		System.out.println("---------------------------------------");
		System.out.println("��Ʒ�ܿ����"+totalCount);
		System.out.println("��Ʒ����ܽ��"+totalMoney);
		System.out.println("---------------------------------------");
	}
}