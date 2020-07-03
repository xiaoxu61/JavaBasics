package cn.learn.basic.Demo01;

/*
  实现商品库存清单案例
      步骤：1、实现打印表头，是固定数据，直接写输出语句
	        2、表格中间，商品数据采用变量形式，定义变量，找对数据类型
			   输出所有变量
			3、表格结尾，一部分数据固定
			   另一部分需要通过商品数据进行数学计算
*/
public class Shop{
	public static void main(String[] args){
		//输出固定数据
		System.out.println("----------------商城库存清单-----------");
		System.out.println("品牌型号      尺寸      价格     库存数");
		//定义表格中的数据变量
		//品牌类型String，尺寸double，价格double，库存int
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
		//商品信息变量进行打印，变量之间加入一定的字符串空格
		System.out.println(macBrand+"    "+macSize+"     "+macPrice+"     "+macCount);
		System.out.println(thinkBrand+"  "+thinkSize+"     "+thinkPrice+"    "+thinkCount);
		System.out.println(asusBrand+"   "+asusSize+"     "+asusPrice+"     "+asusCount);
		//计算库存总数，所有商品数量库存求和
		int totalCount = macCount + thinkCount + asusCount;
		double totalMoney = macCount * macPrice + thinkCount * thinkPrice + asusCount * asusPrice;
		System.out.println("---------------------------------------");
		System.out.println("商品总库存数"+totalCount);
		System.out.println("商品库存总金额"+totalMoney);
		System.out.println("---------------------------------------");
	}
}