package cn.learn.basic.Demo01;

/*
  算法运算符
  + 加法，连接
  - 减法
  * 乘法
  / 除法
  % 取模，获取余数
  ++ 自增1
  -- 自减1
*/
public class Operator{
	public static void main(String[] args){
		// + 连接作用，将一个字符串和其他数据连接起来
		// + 遇到字符串，变成连接符号“5+5=55”
		// + 任何类型只要和字符串+，所有的数据都变成了字符串
		System.out.println("5+5 = "+5+5);
		//除法运算
		int i = 100;
		int j = 9;
		System.out.println(+i/j);
		//取模运算，两个数相除，获取的是余数
		int k = 6;
		int m = 4;
		System.out.println(k%m);
		//自增运算 ++
		int a = 2;
		int b = 4;
		a++;        //变量a自己增加1
		System.out.println(a);
        ++b;
		System.out.println(b);
		/*
		   ++ 写在变量前面，和写在后边的区别
		   a = 1
		   a++  ++a 符号写在前面还是后面，在变量自己独立计算的时候没有区别
		   但是变量要是参与了其他运算就有区别了
		*/
		int k1 = 5;
		int k2 = k1++;   //++ 后算，先将K1的值赋予k2，k1自己再++
		System.out.println(k1);
		System.out.println(k2);
		
		int k3 = 5;
		int k4 = ++k3;   //++ 先算，先将K3的值++再赋予k4
		System.out.println(k3);
		System.out.println(k4);
		
		/*
		  赋值运算符
		  =
		  += -= *= /= %=
		*/
		//= 赋值运算，将右面的值，赋值给左边的变量
		int k5 = 3;
		k5 = k5 + 3;
		System.out.println(k5);
		
		//+= 赋值运算符 i+=3 i = i+3
		int k6 = 5;
		k6 += 6;   //k6 = k6 + 6
		System.out.println(k6);
		
		byte k7 = 1;
		k7 =(byte)(k7 + 1);
		System.out.println(k7);
		byte b1 = 1;
		b1+=1;  //等同于(byte)(b1 + 1)  推荐用加等，还不用强制转换
		System.out.println(b1);
		
		/*
		  ==相等于  !=不等于 <小于 >大于 <=小于等于 >=大于等于
		  比较符号两边的数据
		  比较运算符 比较的结果是布尔值：true或者false 
		  计算结果的数据类型是boolean类型
		  
		*/
		int i1 = 3;
		int j1 = 4;
		//System.out.println(i1 = j1);
		//System.out.println(i1 == j1);
		//System.out.println(3 == 4);
		
		/*
		  逻辑运算符 &与 |或 ^异或(两边相同为真) !非（取反）
		  &&短路与（一边是false另一边不运行）  
		  ||短路或（一边是true，另一边不运行）
		  对两个Boolean类型数据之间进行计算，结果也是Boolean类型
		*/
		System.out.println(true & true);
		
		System.out.println(3>4 && ++j1>2);
		System.out.println(i1);
		System.out.println(j1);
		/*
		  三元运算符
		  公式：
		      布尔表达式 ？ 结果1：结果2
		  布尔表达式结果是true，三元运算符的结果是结果1
		  布尔表达式结果是false，三元运算符的结果是结果2
		*/
		System.out.println(3>5?99:88);
		String S = 0 == 0 ? "你觉得呢" : "呵呵";
		System.out.println("零是不是等于零？"+S);
	}
}