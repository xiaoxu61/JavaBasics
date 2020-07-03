package cn.learn.basic.Demo01;/*
  随机点名器两种方法
*/
import java.util.Random;
public class callName{
	public static void main(String[] args){
		//存储姓名，姓名存储到数组中
		//数组存储姓名，姓名的数据类型，String
		String[] names = {"张三","李四","王二","小明","小王","老王","小李","小丽","飞机","坦克"};
		for(int i = 0; i < names.length; i++){
			System.out.println(names[i]);
		}
		System.out.println("=======");
		//随机出一个人名
		//利用随机数，生成一个整数，作为索引，到数组中找到对应的元素
		Random ran = new Random();
		//随机数，范围必须是0~数组的最大索引
		int index = ran.nextInt(names.length);
		System.out.println(names[index]);
		
		System.out.println("=======");
		//定义数组，存储学生姓名
		String[] Names = new String [10];
		//调用添加姓名方法
		addStudent(Names);
		//调用遍历数组方法
		printStudentName(Names);
		//调用随机姓名的方法
		String name = randomStudentName(Names);
		System.out.println("=======");
		System.out.println(name);
		
	}
	/*
	  1、存储所有学生姓名
	  2、预览所有学生姓名，遍历数组
	  3、随机数作为索引，到数组中找元素
	  
	  将功能做成方法，调用方法即可
	  定义三个功能，用到同一个姓名数据
	  姓名存储到数组中，三个方法，使用一个数组中的数据，方法传递参数
	*/
	/*
	   定义方法，实现向数组中添加学生姓名
	   返回值，没有
	   参数，参数就是数组
	*/
	public static void addStudent(String[] Names){
		 Names[0] ="张三"; Names[1] ="李四"; Names[2] ="王二";
		 Names[3] ="小明"; Names[4] ="小王"; Names[5] ="老王";
		 Names[6] ="小李"; Names[7] ="小丽"; Names[8] ="飞机";
		 Names[9] ="坦克";
	}
	/*
	  定义方法，遍历数组
	  返回值，没有
	  参数，数组
	*/
	public static void printStudentName(String[] Names){
		for(int i = 0; i < Names.length; i++){
			System.out.println(Names[i]);
		}
	}
	/*
	  定义方法，随机数，做索引，数组中找到学生姓名
	  返回值，学生姓名
	  参数，数组
	*/
	public static String randomStudentName(String[] Names){
		Random Ran = new Random();
		int Index = Ran.nextInt(Names.length);
		return Names[Index];
	}
}