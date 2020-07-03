package cn.learn.Data.Basic.CommonAlgorithm;
/*
    二分查找算法（非递归）
        1、前面我们讲过二分查找算法，使用的是递归的方式，下面我们讲解二分查找的非递归方式
        2、二分查找发法只适用于从有序的数列中查找（比如数字和字母等）将数列排序后再进行查找
        3、二分查找法的运行时间为对数时间 诺格二n ，即查找到需要的目标位置最多只需要，假设从【0，99】
    的队列100个数，找到目标数30，则最多需要查找7次
*/

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,11,67,100};
        int index = binarySearch(arr,-1);
        System.out.println(index);
    }

    //二分查找的非递归实现
    /**
     *
     * @param arr 待查找的数组，arr是升序排序
     * @param target  需要查找的数
     * @return 返回对应下标，-1表示没有找到
    */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid - 1;//需要向左边查找
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
