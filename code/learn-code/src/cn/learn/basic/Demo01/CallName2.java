package cn.learn.basic.Demo01;/*
  随机点名器,集合改进(学生的姓名和年龄)
  现实中有学生这个事物，使用定义的形式，描述学生事物
  属性：姓名，年龄
  
  姓名存储了数组，将容器换成集合
  String[] s = {"",""};
  集合中存储的是学生的姓名吗？应该存储Student类型
  存储学生：
    学生类型,存储到集合中
	总览：遍历集合
	随机：随机数，作为索引,到集合中找到元素
	三个功能，共享数据，集合容器
	定义三个方法，必须参数传递集合
*/
import java.util.ArrayList;
import java.util.Random;

public class CallName2{
	public static void main(String[] args){
		//定义集合，存储的是StudentName类型变量
		ArrayList<StudentName> array = new ArrayList<StudentName>();
		//调用添加方法
		add(array);
		//调用遍历集合
		printArrayList(array);
		//调用随机数
		randomStudentName(array);
	}
	/*
	  总览学生的信息，遍历集合
	*/
	public static void printArrayList(ArrayList<StudentName> array){
		for(int  i = 0; i < array.size(); i++){
			//存储集合的时候，集合.add(sn1)
			//获取出来的时候,集合.get方法，获取出来的是什么,还是StudentName类型变量
			
			System.out.println(array.get(i));
			
			StudentName s = array.get(i);
			System.out.println(s.name+" "+s.age);
			
		}
	}
	/*
	  随机数，当作集合的索引，到集合中找到元素
	*/
	public  static  void randomStudentName(ArrayList<StudentName> array){
		Random r = new Random();
		int number = r.nextInt(array.size());
		//随机数，索引，到集合中get
		StudentName s = array.get(number);
		System.out.println(s.name+" "+s.age);

	}
	/*
	  定义方法实现存储学生的姓名和年龄
	  创建StudentName类型变量，存储到集合中
	*/
	public static void add(ArrayList<StudentName> array){
		//创建StudentName类型变量
		StudentName sn1 = new StudentName();
		StudentName sn2 = new StudentName();
		StudentName sn3 = new StudentName();
		StudentName sn4 = new StudentName();
		StudentName sn5 = new StudentName();
		StudentName sn6 = new StudentName();
		
		sn1.name = "张1";
		sn1.age  =  21;
		sn2.name = "张2";
		sn2.age  =  22;
		sn3.name = "张3";
		sn3.age  =  23;
		sn4.name = "张4";
		sn4.age  =  24;
		sn5.name = "张5";
		sn5.age  =  25;
		sn6.name = "张6";
		sn6.age  =  26;
		
		//将StudentName变量，存储到集合中
		array.add(sn1);
		array.add(sn2);
		array.add(sn3);
		array.add(sn4);
		array.add(sn5);
		array.add(sn6);
	}
	
}