package cn.learn.basic.Demo24;
/*
用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合中
要求使用自定义的方法来实现筛选

分析：
    1、需要创建一个大集合，用来存储int数字：<Integer>
    2、随机数字就用Random nextInt
    3、循环20次，把随机数字放入大集合：for循环、add的方法
    4、定义一个方法，用于筛选
    筛选：根据大集合，筛选符合要求的元素，得到小集合
    三要素：
         返回值类型：ArrayList小集合（内部参数个数不确定）
         方法名称：getSmallList
         参数列标：ArrayList大集合（装着20个随机数）
     5、判断if是偶数，num % 2 == 0
     6、如果是偶数，放到小集合，否则不放
*/


import java.util.ArrayList;
import java.util.Random;

public class Demo24ArrayListReturn {
    public static void main(String[] args) {
        ArrayList<Integer> BbigList = bigList(5);
        System.out.println(BbigList);
        System.out.println("小集合的个数为：" + getSmallList(BbigList).size());
        System.out.println(getSmallList(BbigList));
    }

    public static ArrayList<Integer> getSmallList(ArrayList<Integer> list){
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(num % 2 == 0){
                smallList.add(num);
            }
        }
        return smallList;
    }

    public static ArrayList<Integer> bigList(int howLong){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < howLong; i++) {
            int temp = new Random().nextInt(50);
            list.add(temp);
        }
        return list;
    }
}
