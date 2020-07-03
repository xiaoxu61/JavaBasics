package cn.learn.basic.Demo01;

/*
   switch语句,选择语句
   编写格式：
         switch(表达式，为了得到一个值){
			 case 常量1 :
			    要执行的语句;
			 break;
			 
			 case 常量2 :
			    要执行的语句;
			 break; 
			 
			 case 常量3 :
			    要执行的语句;
			 break;
			 
			 default:
			     要执行的语句;
			 break;
		 }
		 执行流程：表达式和case后边的常量进行比较
		 和哪个case后的常量相同就执行哪个case后面的程序，遇到break就全结束
		 关键字：switch case break default
**************************************************************************		 
	     switch语句中的表达式的数据类型是有要求的
		 JDK1.0~1.4 数据类型接受byte short int char
		 JDK1.5~    数据类型接受byte short int char enum(枚举)
		 JDK1.7     数据类型接受byte short int char enum String
*/
public class SwitchDemo{
	public static void main(String[] args){
		//定义整数变量，用于保存星期几的整数
		int week = 6;
		//switch语句
		switch(week){
			case 1:
			  System.out.println("星期一");
			break;
			
			case 2:
			  System.out.println("星期二");
			break;
			
			case 3:
			  System.out.println("星期三");
			break;
			
			case 4:
			  System.out.println("星期四");
			break;
			
			case 5:
			  System.out.println("星期五");
			break;
			
			case 6:
			  System.out.println("星期六");
			break;
			
			case 7:
			  System.out.println("星期日");
			break;
			
			default:
			  System.out.println("星期不存在");
			break;
		}
//switch又一特性：case的穿透性
//     case的常量和switch中数据相同，case后面没有遇到break 程序就会一直向下穿
//案例：星期一~五，工作日。星期6~7输出休息日		
		switch(week){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			  System.out.println("工作日");
			break;
			
			case 6:
			case 7:
			  System.out.println("休息日");
			break;
			
			default:
			  System.out.println("星期不存在");
			break;
		}

/*
   数组：数据太多存数组
     定义数组容器
	     定义数组容器，要素，强制数据类型语言
		 必须有数据类型，大小，就是存储数据的个数
		 定义数组公式：
		       数据类型[] 变量名 = new 数据类型[存储元素的个数];
			   
			   数据类型：数组中存储元素的数据类型
			   []      ：表示数组的意思
			   变量名  ：自定义标识符
			   数据类型：数组中存储元素的数据类型
			   []      ：表示数组的意思
			   元素个数：数组中，可以存储多少个数据
			   
			数组是一个容器：存储到数组中的每个元素，都有自己的自动编号
			自动编号，最小值：0；最大值：长度-1；
			自动编号专业名称：索引（index）,下标，角标
			访问数组存储的元素，必须依赖于索引公式：数组名[索引]; 
			
			Java提供一个属性，操作索引
			数组的一个属性：数组的长度，属性的名字：length
			使用属性公式：数组名.length  数据类型：int
			
			数组的最小索引是0，最大索引数组.length-1
		数组操作中，常见的两个异常
            数组的索引越界异常  报错：java.lang.ArrayIndexOutOfBoundsException: 6
            空指针异常			
*/
            //定义数组，存储整数，容器长度，3个
			//数据类型[] 变量名 = new 数据类型[存储元素的个数];
			int[] arr = new int[3];
			//arr数组属于引用类型，保存的数据实质是内存中的地址
			System.out.println(arr);
			//通过索引的方式，访问数组中的三个元素
			System.out.println(arr[0]);
			System.out.println(arr[1]);
			System.out.println(arr[2]);
			System.out.println(arr.length);
//    数组的两个定义方式
//1、数组类型[] 变量名 = new 数据类型[]{元素1，元素2，元素3}；
//注意事项：new后面的中括号中，不允许写任何内容，写了就编译失败
			int[] arr1 = new int[]{1,2,4,6,9};
			System.out.println(arr1.length);
			System.out.println(arr1[3]);
			System.out.println("==============");
//2、数据类型[] 变量名 = {元素1，元素2，元素3};
//直接大括号赋值,简单
			int[] arr2 = {0,2,4,6,};
			System.out.println(arr2.length);
			System.out.println(arr2[3]);
			
//使用索引，对数组中的元素进行赋值
//定义数组，存储int类型数组，长度就是5
            int[] arr3 = new int[5];
            arr3[3] = 3;			
			System.out.println(arr3[4]);
/*数组遍历：
    将所有的数组元素 全获取(依靠索引)
	规律从0开始，一直自动增长1，到达length-1;
	循环来实现
	    for  知道循环次数，计数器思想
		while不确定循环次数
*/
			int[] arr4 = {1,5,9,7,6,5};
			System.out.println("数组遍历(while循环):");
			int num = 0; 
			while(num < arr4.length){
				System.out.println(arr4[num]);
				num++;
			}
			System.out.println(arr4[5]);
			System.out.println(num);
			
			
			System.out.println("数组遍历for循环");
			for(int i = 0; i < arr4.length; i++){
			    System.out.println(arr4[i]);
				
			}
/*
    获取数组中的最值：数组遍历，用max或者min比较数组中元素
	并用max或者min记录下比较中较大或较小的数，遍历完成后记录的数就是最大或者最小值
*/
            int[] arr5 = {1,5,8,5,9,7,6};
			//定义变量记录索引0上的元素
			int max = arr5[0];
			//遍历数组，获取所有的元素，和变量max进行比较
			for(int i = 1; i < arr5.length; i++){
				//变量max和数组中的每个元素进行比较
				//如果max小于数组中的一个元素
				if (max < arr5[i]){
					//较大的数组的元素，赋值给max
					max = arr5[i];
				}
			}
			//遍历完成，变量max就是数组最大值
			System.out.println("数组中的最大值是" +max);
			
/*
  二维数组
     数组中的数组，数组里面存储的还是数组
  定义方式和一维数组类似
  int[][] arr = new int[3][4];
  定义一个二维数组
  [3]表示：二维数组中有三个一维数组
  [4]表示：三个一维数组中，每个数组的长度是4
*/
            int[][] arr6 = new int[3][4];
			System.out.println(arr6);
			System.out.println(arr6[1]);
			System.out.println(arr6[1][2]);
			
//最简单的二位数组定义：
// int[][] arr = {{1,4},{1,6,8},{3,5,9,10}}
            int[][] arr7 = {{1,2,3},{4,5},{6,7,8,9},{0} };
			//问题打印数组中的元素7
			System.out.println("二维数组中的" +arr7[2][1]);
			System.out.println(arr7[1].length);
			//二维数组的遍历
			//for循环遍历二维数组，遍历过程中，for遍历一维数组
			//外循环遍历二维数组
			for(int i = 0; i < arr7.length; i++){
				//内循环遍历每个一维数组
				for(int j = 0; j < arr7[i].length; j++){
					System.out.print("第"+i+"组,"+"第"+j+"个数是"+arr7[i][j]);	
				}
				System.out.println();
			}
			//用while循环实现遍历
			int numOut = 0;
			while(numOut < arr7.length){
				int numIn = 0;
				while(numIn < arr7[numOut].length){
					System.out.println("第"+numOut+"组,"+"第"+numIn+"个数是"+arr7[numOut][numIn]);
					numIn++;
				}
				numOut++;
			}
			
		//二维数组的遍历求和
            int[][] arr8 = {{11,12},{21,22,23},{31,32,33,34},};
            //定义变量保存两个求和的值
            int sum = 0;        //保存所有的求和
            int groupSum = 0;	//保存每个一维数组求和
            for(int i = 0; i < arr8.length; i++){
				for(int j = 0; j < arr8[i].length; j++){
					//将一维数组的元素求和
					groupSum += arr8[i][j];
				}
				System.out.println("每个小组总金额"+groupSum);
				//将每个一维数组求和
				sum += groupSum;
				groupSum = 0;
			}
            System.out.println("公司的总金额"+sum);			
/*
JVM对自己的内存进行了划分，分为5个区域

          存储器：内存和CPU之间
      本地方法栈：JVM调用了系统中的功能
  方法和数据共享：运行时期class文件，进入的地方
          方法栈：所有的方法运行的时候，进入的内存
              堆：存储的是容器和对象
*/
	}
}