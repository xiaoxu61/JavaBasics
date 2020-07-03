package cn.learn.basic.Demo24;
/*
希望向集合中ArrayList当中存储基本类型，必须使用基本类型对应的“包装类”

基本类型 包装类（引用类型，包装类都位于java.lang包下）

byte     Byte
short    Short
int      Integer     【特殊】
long     Long
float    Float
double   Double
char     Character   【特殊】
boolean  Boolean

从JDK 1.5+ 开始，支持自动装箱，自动拆箱
自动装箱：基本类型 --> 包装类型
自动拆箱：包装类型 --> 基本类型
*/

import java.util.ArrayList;

public class Demo24ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<>();

        //ArrayList<int> = listB = new ArrayList<>();//错误写法
        ArrayList<Integer> listC = new ArrayList<>();
        listC.add(100);
        listC.add(125);
        listC.add(0, 15);
        System.out.println(listC);


        int num = listC.get(0);
        System.out.println("listC中的第一号元素是：" + num);

    }
}
