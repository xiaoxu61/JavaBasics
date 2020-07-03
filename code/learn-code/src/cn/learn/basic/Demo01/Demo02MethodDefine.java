package cn.learn.basic.Demo01;
/*
  参数：就是进入方法的数据
  返回值：从方法中出来的数据

  定义方法的完整格式：
  修饰符 返回值类型 方法名称（参数类型 参数名称,...）{
  方法体
  return 返回值；
  }
  修饰符：现阶段的固定写法，public static
  返回值类型：方法最终产生的数据结果是什么类型
  方法名称：方法的名字，规则和变量一样，小驼峰
  参数类型：进入方法的数据是什么类型
  参数名称：进入方法的数据对应的变量名称  PS参数方法如果多个，使用逗号进行分隔
  方法体：方法需要做的事情，若干行代码
  return：1、停止当前方法；2、将后面返回值还给调用出
  返回值：方法执行后最终产生的数据结果

  方法的三种调用格式：
      1、单独调用：方法名称（参数）
      2、打印调用：System.out.println(方法名称（参数）);
      3、赋值调用：数据类型 变量名称 = 方法名称（参数）

  注意：
     无返回值的方法，返回值类型固定写为void，这种方法只能单独调用，不能进行打印调用或者赋值调用
     有返回值的方法，可以使用单独调用、打印调用、赋值调用
 */
public class Demo02MethodDefine {
    public static void main(String[] args) {
//        单独调用
        sum(10, 20);
        System.out.println("====");
//        打印调用
        System.out.println(sum(10, 20));
        System.out.println("====");
//        赋值调用
        int num = sum(15, 25);
        System.out.println("变量的值=" + num);
        num += 100;
        System.out.println("加法后的值=" + num);
    }
    public static int sum(int a, int b){
        System.out.println("方法执行了");
        int result = a + b;
        return result;
    }
}
