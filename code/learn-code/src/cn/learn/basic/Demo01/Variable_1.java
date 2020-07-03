package cn.learn.basic.Demo01;

/*
  常量：字符串，双引号，包裹，“0—n”
  
  变量定义和使用的注意事项
    1.变量定义后，不赋值不能使用
	2.变量有自己的作用范围，变量的有效范围，定义的一对大括号内
	3.变量不允许重复定义
	
*/
public class Variable_1{
	public static void main(String[] args){
		//定义变量，字符串类型，数据类型 String 表示字符串的数据类型
		String s = "我爱Java";
		//String 属于引用类型，定义方式和基本类型一样
		System.out.println(s);
		
		int i = 10;
		System.out.println(i);
		{
			int j = 10;
		System.out.println(j);
		}
		
	//	int
				i = 1;
	}
}