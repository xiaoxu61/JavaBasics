package cn.learn.basic.Demo01;

/*
  标识符
  Java中，自己定义的内容
  自定义类的名字，上一个案例 HelloWorld
  标识符的规则：
      组成：字母52个：A~Z a~z 数字：0~9  符号：下划线 ‘_’  美元符‘$’
      注意：不能数字开头，不能是关键字	  
	  类的名字：首字母大写，第二个单词首字母大写
	  方法的名字：首字母小写，每个单词首字母大写
*/
public class Demo{
	public static void main(String[] args){
		//输出整数       十进制
		System.out.println(50);
		//输出整数，二进制，数字开头0B
		System.out.println(0B11);
		//输出整数，八进制，数字开头0
		System.out.println(051);
		//输出整数，十六进制，数字开头0x 0~9 A~F
		System.out.println(0xE);
		 //输出浮点数据
		 System.out.println(5.5);
		 //输出布尔数据，只有两个值，true,false
		 System.out.println(true);
		 System.out.println(false);
		 //输出字符常量，单引号包裹，只能写一个字符
		  System.out.println('去');
		 //输出字符串常量，双引号包裹，可以写0~n个字符
		  System.out.println("撒大苏打");
	}
}