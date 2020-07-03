package cn.learn.basic.Demo01;

/*
   if 语句编写格式：
     if(条件){
		 if	语句的执行体
	 }
	 条件：结果必须是布尔类型 1==1 true||false
	 执行体：当if中的条件为true的时候，执行大括号中的执行体
	         if条件false的时候，什么也不做
*/
public class ifDemo{
	public static void main(String[] args){
		int i = 4;
		//对变量i进行if判断
		if(i == 5){
			System.out.println("if中的条件是true");
			i++;
		}
			System.out.println(i);
/*
   if...else 语句
      编写格式：
	      if(条件){
			  if 的执行体
		  }else{
			  else 的执行体
		  }
		 当if中的条件为true，执行if的执行体
		 当if中的条件为false，执行else的执行体
*/
        int  j = 8;
		//判断变量是奇偶数，除以2，看余数0 1
		if (j % 2 == 0){
			System.out.println(j+ "是偶数");
	    }else{
			System.out.println(j+ "是奇数");
		}
/*
    if...else if...else语句
    语句用于对多个条件进行判断
         编写格式：
            if(条件){
				if执行体
			}else if(条件){
				if执行体
			}else if(条件){
				if执行体
			}else{
				else的执行体
			}
         当if中的条件是true，执行if执行体
         if中的条件是false，执行else执行体
         一个语句中，包含多个if，只要有一个if的条件是true，其他代码不再执行		 
*/
        //成绩判断要求，成绩>80优,成绩>70良,成绩>60不及格
		int grade = 80;
		//使用if else if语句对成绩判断
		if(grade > 80){
			System.out.println(grade+ "成绩是优");
		}else if(grade > 70){
			System.out.println(grade+ "成绩是良");
		}else if(grade > 60){
			System.out.println(grade+ "成绩是中");
		}else{
			System.out.println(grade+ "成绩是差");
		}
/*
  if语句和三元运算符的替换
    要求：已知两个数，计算最大值
	两个整数比较大小
	
	使用if还是使用三元
	    判断条件比较多，使用if
		三元必须有结果，if可以没有结果
*/
         int a = 5;
		 int b = 5;
		 //使用if语句，判断出最大值
		 if(a > b){
			 System.out.println(a+ "是最大值");
		 }else{
			 System.out.println(b+ "是最大值");
			 
		 }
     //使用三元运算实现 
	     int k = a > b ? i : j;
			 System.out.println(k+ "是最大值");
	}
}