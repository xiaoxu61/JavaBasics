package cn.learn.basic.Demo01;

/*
   循环语句：可以让一部分代码反复执行
   while循环编写格式：
         while(条件){
			 循环体
		 }
		 条件：当条件是true，就执行循环体，执行完循环体后
		 程序再次执行while中的条件，如果条件还是true，继续执行循环体
		 直到条件是false的时候，循环就结束
*/
public class WhileDemo{
	public static void main(String[] args){
		//输出1~4之间的整数
		//定义变量，整数类型，循环的条件
		int i = 1;
		while(i <= 4){
			System.out.println(i);
			i++;
		}
/*
  for循环编写格式
      for(初始化变量 ; 条件 ; 增量){
		  循环体
	  }
	  初始化变量：定义变量，作用，控制循环的次数
	  1、变量定义，在一个while循环中，终身就定义一次
	  2、条件是false，整个for结束
	      3、是true，执行循环体
		  4、执行增量
		  5、再执行2、  如此循环
	  条件：当条件是true，执行循环体，条件是false，结束循环
	  增量：变量自增情况
*/
         //    定义变量   条件   增量
         for(int j = 0; j <= 10; j++){
			 System.out.println(j);
		 }
		 //利用for循环，计算1+到4 的结果
		 int sum = 0;
		 //利用循环，将变量从1变化到4
		 for(int i1 = 1; i1 <= 4; i1++){
			 //对变量进行求和
			 sum = sum + i1;
		 }
			 System.out.println(sum);
/*
  do...while循环编写格式：
         do{
			 循环体
		 }while(条件)；
     特点：无条件先执行一次
*/		 
         int a = 0;
		 do{
			 System.out.println(a);
			 a++;
		 }while(a < 5);
		 
/*
   //死循环
   //while形式死循环
       while(true){
	   
       }
   //for形式死循环
       for( ; true; ){
		   
	   }
*/
    /*
	  嵌套循环：循环里面还有循环，for形式多
	  for(条件){
		  for(条件){
			  
		  }
	  }
	  总循环次数 = 内循环次数*外循环次数
	  内循环是外循环的循环体
	*/
	    for(int b  = 0; b <= 9; b++){
		    for(int c = 0; c <= b; c++ ){
			    System.out.print(c);
		    }
			System.out.println();
	    }
/*
   break 关键字
   作用于循环中，终止循环的作用
*/		
	     int d = 1;
		 while(true){
			 if(d == 3){
				 break;
			 }else{
				 System.out.println(d);
			 }
			 d++;
		 }
	//给循环命名：在循环前  循环名 + ： 即可；
	//终止某个循环 break + 循环名;
	//break后面没加循环名，那就是终止当前循环
	      a: for(int e = 0; e < 5; e++){
			  for (int f = 0; f < 7; f++){
				  System.out.print("F"+f);
				  break a;
			  }
			  System.out.println("E"+e);
		  }
/*
   continue 关键字
   作用：在循环中，终止本次循环，开始下一次循环
*/
             for(int g = 0; g < 10; g++){
				 if(g % 2 == 0){     //遇到偶数
					 continue;       //结束当前循环，开始下次循环
				 }
				 System.out.println(g);
			 }
	}
}