package cn.learn.basic.Demo01;/*
  方法的定义格式
      修饰符 返回值类型 方法的名字(参数列表){
		  方法的功能主体
		     循环，判断，变量，比较，运算
		   return;
	  }
	  
	      修饰符：固定写法 public static
	  返回值类型：方法运算后，结果的数据类型，无返回值时返回值类型用void
	      方法名：自定义名字，满足标识符规范，方法名字首字母小写，后面每个单词首字母大写
        参数列表：方法的运算过程中，是否有未知的数据，如果有未知的数据，定义在参数列表上(定义变量)
		  return：方法的返回，将计算的结果返回.结束方法
	
    方法定义和使用的注意事项： 
	    1、方法不能定义在另一个方法的里面
		2、写错方法的名字
		3、写错了参数列表
		4、方法返回值是void，方法中可以省略return 不写
		5、方法的返回值类型和return后面的数据类型必须匹配
		6、方法重复定义问题
		7、调用方法的时候，返回值是void，不能写在输出语句中
		
    		  
	方法的重载特性(overload)
	   在同一个类中，允许出现同名的方法，只要方法的参数列表不同，这样的方法就是重载
	   参数列表不同：参数的个数，数据类型，顺序
	  注意事项：
	    1、参数列表必须不同
		2、重载和参数变量名无关
		3、重载和返回值类型无关
		3、重载和修饰符无关
	  技巧：重载看方法名和参数列表
*/
import java.util.Scanner;
public class MethodDemo{
	public static void main(String[] args){
		//调用方法，方法执行起来
		//在方法main中，调用方法 getArea
		int area = getArea(5,6);
		System.out.println("面积是：" +area);
		System.out.println("面积是："+getArea(7,8));
		//打印矩形
		printRect();
		//键盘录入得到一个整数
		int number = getNumber();
		System.out.println(number);
		//打印指定M行，每行N个*号的矩形
		printRect2(3,5);
		//求三个数的平均值
		//int getAvg(1,3,5);
		System.out.println(getAvg(1,3,5));
		//方法的重载的调用，根据参数传递进行区分
		System.out.println(getSum(1.2,3));
		//方法，调用中的参数传递问题
		//基本数据类型
		int a = 1;
		int b = 2;
		change(a,b);
		System.out.println(a);
		System.out.println(b);
		//引用类型
		int[] arr = {1,2,3,4};
		System.out.println(arr[2]);
		change(arr);
		System.out.println(arr[2]);
		
		
		
	}
	/*
	   方法的定义练习
	   
	     定义无返回值的无参数方法。如打印3行，每行3个*号
		 为什么没有返回值：
		     打印矩形，输出结果，不需要将结果返回
			 明确未知数：不需要未知数
	*/
	public static void printRect(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print("*");
			}
				System.out.println();
		}
	}
	/*
	  定义有返回值无参数方法，如键盘录入得到一个整数
	  明确方法计算后结果的数据类型 int
	  明确有没有未知数，没有
	*/
	public static int getNumber(){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		return number;
	}
	/*
	  定义无返回值，有参数方法，如打印指定M行，每行N个*号的矩形
	  明确方法计算后结果，控制台输出图形，没有返回值的
	  方法中有没有未知数，图形行数和列数，是未知的，数据类型整数int
	*/
	public static void printRect2(int m, int n){
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print("*");
			}
				System.out.println();
		}
	}
	/*
	   定义有返回值有参数方法，如求三个数的平均值
	   明确方法计算后的类型，返回值类型 int
	   明确方法未知数，三个未知数的整数
	*/
	public static int getAvg(int a, int b, int c){
		return (a+b+c)/3;
	}
	/*
	要求：计算一个长方形的面积
	定义方法解决这个要求
	分析方法定义过程：
	    1、明确方法计算后的结果的数据类型 int 定义格式对应的就是返回值类型
		2、方法的计算过程中，有没有未知的数据，宽和长，未知数据的数据类型 int
		   未知数的变量，定义在方法的小括号内
	*/
	public static int getArea(int W, int h){
		//实现方法的功能主体
		int area = W * h;
		return area;
	}
	/*
	  
	  定义方法，对参数求和
	  参数，没有规定几个，数据类型
	
	public static int getSum(int a; int b){
		return a + b;
	}
	
	public static double getSumDouble(double a; double b){
		return a + b;
	}
	public static int getSum3(int a; int b; int c){
		return a + b + c;
	}
	*/
	//对参数求和，利用方法的重载特性
	public static int getSum(int a, int b){
		System.out.print("两个int参数的和为");
		return a + b;
	}
	public static int getSum(int a, int b, int c){
		System.out.print("三个int参数的和为");
		return a + b + c;
	}
	public static double getSum(double a, double b){
		System.out.print("两个double参数的和为");
		return a + b;
	}
	/*
	  方法，调用中的参数传递问题
	      1、方法参数是基本数据类型
		  2、方法参数是引用类型
		     传递的是地址
	*/
	public static void change(int a, int b){
		a = a+b;
		b = b+a;
	}
	public static void change(int[] arr){
		arr[2] = 100;
	}
	
}