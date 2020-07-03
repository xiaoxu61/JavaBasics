package cn.learn.basic.Demo01;

import java.util.ArrayList;
import java.util.Scanner;

/*
  实现库存管理案例：
     1、存储商品信息
       创建出集合，存储商品类型变量
       将商品类型的变量，存储到集合中
     2、查看库存清单
        将集合进行遍历，获取出集合中的Goods类型变量
        输出每一个Goods类型的属性
        计算求和：总库存，总金额
     3、修改商品的库存
       遍历集合，获取出集合中存储的Goods类型变量
       变量调用Goods类的属性count，值进行修改（键盘输入）
 */
public class Shopping {
    public static void main(String[] args){
      //创建ArrayList集合，存储Goods类型
      ArrayList<Goods> array = new ArrayList<Goods>();
      //调用添加商品信息的方法
      addGoods(array);
      //进入死循环中
      while (true){
          //调用选择功能的方法，获取到用户输入的功能序号
          int number = chooseFunction();
          //对序号判断
          switch (number){
              case 1:
                  //进入查看库存
                  printStore(array);
                  break;
              case 2:
                  //进入修改库存
                  update(array);
                  break;
              case 3:
                  return;
              default:
                  System.out.println("无此功能");
          }
      }
    }
    /*
       定义方法，实现选择菜单，用户根据功能选择菜单
     */
    public static int chooseFunction(){
        System.out.println("------库存管理-----");
        System.out.println("1、查看库存清单");
        System.out.println("2、修改库存数量");
        System.out.println("3、退出");
        System.out.println("请输入需要执行的操作序号");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }
    /*
       定义方法，修改库存
       键盘输入，将goods中的属性值，修改
     */
    public static void update(ArrayList<Goods> array){
        Scanner sc = new Scanner(System.in);
        //遍历集合，获取集合中的每个元素
        for(int i = 0; i < array.size(); i++){
            //集合方法get获取的是集合的元素，元素类型Goods
            Goods g = array.get(i);
            System.out.println("请输入"+g.brand+"的库存数");
            //Goods属性，count进行修改
            g.count = sc.nextInt();
        }
    }
    /*
       定义方法，查看库存清单，遍历集合
     */
    public static void printStore(ArrayList<Goods> array){
        System.out.println("-------商场库存清单------");
        System.out.println("品牌型号     尺寸    价格    库存数");
        //定义变量，保存总库存数
        int totalCount = 0;
        double totalMoney = 0;
        //遍历集合
        for(int i = 0; i < array.size(); i++){
            Goods g = array.get(i);
            System.out.println(g.brand+"    "+g.size+"    "+g.price+"    "+g.count);
            totalCount = totalCount+g.count;
            totalMoney = totalMoney+g.count*g.price;
        }
        System.out.println("库存总数："+totalCount);
        System.out.println("库存总金额："+totalMoney);

    }
    /*
      定义集合方法，将商品的信息存储到集合中
      集合是所有方法的共享数据，参数传递
     */
    public static void addGoods(ArrayList<Goods> array){
        //创建商品类型变量Good类型的变量
        Goods g1 = new Goods();
        Goods g2 = new Goods();
        g1.brand = "MacBook";
        g1.price = 999.99;
        g1.count = 3;

        g2.brand = "TinkPad";
        g2.price = 5555.32;
        g2.count = 2;

        array.add(g1);
        array.add(g2);
    }
}
