package cn.learn.basic.Demo01;

/*
  定义方法，实现数组遍历
  遍历中，输出结果[11，33, 565, 66, 78, 89]
  int[] arr = {3,4,45,7}
  实现步骤:
     1、定义方法实现数组的遍历
     2、先打印[ 中括号
     3、遍历数组
        输出数组的元素和逗号
        判断是否遍历到了最后一个元素，如果是最后一个元素，输出] 中括号
 */
public class ArrayMethodTest {
    public static void main(String[] args){
        //定义数组
        int[] arr = {11,66,88,99};
        int[] arr2 = {1,5,8,4};

        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                System.out.print("[");
            }
            System.out.print(arr[i]);
            if (i < arr.length - 1){
                System.out.print(",");
            }else
                System.out.println("]");
        }
        printArray(arr);

        //调用打印数组
        printArray(arr2);
        //调用逆序的方法
        reverse(arr);
        //调用打印数组方法
        printArray(arr);
        //调用选择排序方法
        selectSort(arr);
        printArray(arr);
        //调用冒泡排序方法
        bubbleSort(arr2);
        printArray(arr2);

        int index = binarySearch(arr2,5);
        System.out.println(index);
    }
    /*
       折半查找（二分法，折半）
       前提：被查找的数组中的元素，必须有序
       返回值：索引
       参数：数组，被找的元素
          1、需要预先定义的变量
             三个，三个指针
          2、进行循环折半
             可以折半的条件  min <= max
          3、让被找元素，和中间索引元素进行比较
             元素 > 中间索引  小指针 = 中间+1
             元素 < 中间索引  大指针 = 中间-1
             元素 == 中间索引 找到了，结束了，返回中间索引
          4、循环结束，无法折半
             元素没有找到，返回-1

     */
    public static int binarySearch(int[] arr,int key){
        //定义三个指针变量
        int min = 0;
        int max = arr.length ;
        int mid = 0;
        //循环折半，条件min <= max
        while (min <= max){
            //公式，中间索引计算
            mid = (min + max)/2;
            if(key > arr[mid]){
                min = mid + 1;
            }else if(key < arr[mid]){
                max = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    /*
       数组的冒泡排序
         数组的相邻元素换位置
     */
    public static void bubbleSort(int[] arr){
        for(int i =0; i < arr.length -1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    /*
        数组的排序：一般都是升序排列，元素，小到大的排列

        两种排序方式
          选择排序：数组的每个元素都进行比较
          冒泡排序：数组中的相邻元素的比较
          规则：比较大小，交换位置
        实现步骤：
           嵌套循环
     */
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            //内循环每次都在减少
            for(int j = i+1; j < arr.length; j++){
                //数组元素进行判断
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    /*
       定义方法 实现功能
       返回值 void
       方法参数：数组
     */
    //输出一半中括号
    public static void printArray(int[] arr) {
        System.out.print("[");
        //数组遍历
        for(int i = 0; i < arr.length; i++){
            //判断遍历到的元素，是不是数组最后一个元素
            //如何判断 循环变量 到达 length - 1
            if(i == arr.length - 1) {
                //输出数组的元素和
                System.out.println(arr[i]+"]");
            }else {
                //不是数组的最后一个元素，输出数组元素和逗号
                System.out.print(arr[i] + ",");
            }
        }
    }

    /*
       实现数组的逆序
          数组中的元素，进行位置上的交换
          逆序 不等于  反向遍历
          就是数组中最远的两个索引进行位置交换，实现数组的逆序
          使用的是数组的指针思想，就是变量，思想，可以随时变换索引
          反转reverse
          实现步骤：
            1、定义方法，实现数组的逆序
            2、遍历数组，实现数组的最远索引换位置
              使用临时的第三方变量
     */
    public static void reverse(int[] arr){
        //利用循环，实现数组的遍历，遍历过程中最远端换位
        for(int start = 0, end = arr.length - 1; start < end; start++, end--){
            //数组中的元素进行位置上的交换
            //star索引和end索引的元素交换
            //定义临时变量保存start索引
            int temp = arr[start];
            //最大索引上的元素赋值给最小索引
            arr[start] = arr[end];
            //临时的变量（最小索引）保存的数据，赋值给最大索引上
            arr[end] = temp;
        }
    }

}
