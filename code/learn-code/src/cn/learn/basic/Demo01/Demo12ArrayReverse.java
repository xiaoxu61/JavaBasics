package cn.learn.basic.Demo01;
/*
  1、数组元素反转，其实就是对称位置的元素交换
  2、通常遍历数组用的是一个索引：
     int i = 0;
     现在表示对称位置需要两个索引：
     int min = 0;
     int max = array.length - 1;
  3、如何交换两个变量的值
     需要一个中间量
  4、什么时候停止交换?
     (1) 当min = max 奇数个
     (2) 当min > max 偶数个
     当 min < max 时就交换，否则停止

*/

public class Demo12ArrayReverse {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        printArray(array);
        System.out.println("================");
        /*
        初始化语句：int min = 0，max = array.length - 1
        条件判断：min < max
        步进表达式：min++, max--
        循环体：用第三个变量倒手
        */
        for(int min = 0, max = array.length - 1; min < max; min++, max--){
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }
        printArray(array);
    }
    /*
    数组可以作为方法的参数
    当调用方法的时候，向方法的小括号进行传参，传递进去的其实是数组的地址值
    */
    public static void printArray(int[] array) {
        System.out.println("方法收到的参数是：" + array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
