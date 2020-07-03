package cn.learn.Data.Basic;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo12Search {
    public static void main(String[] args) {
//        int[] arr = {1,9,11,-1,34,89};
//        int[] arr = {1,81,89,1000,1234};
//        int[] arr = {1,81,89,1234};
        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
//        int index = SeqSearch(arr, 11);
//        int index = BinarySearch(arr, 0, arr.length -1, 8);
//        ArrayList list = BinarySearch1(arr, 0, arr.length - 1, 1000);
        ArrayList<Integer> list = insertSearch(arr, 0, arr.length - 1, 89);
        System.out.println(fibonacciSearch(arr,5));
        if (list.size() == 0) {
            System.out.println("未找到查找的值");
        }else {
            System.out.println("找到该值,下标为：" + list);
        }
    }

    /*
    斐波那契查找算法
        与之前算法原理相似，仅仅改变了mid 的位置，mid = left + F(k-1) -1
        F(k-1):F代表斐波那契数列
    */
    //非递归方式编写算法
    public static int fibonacciSearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        int k = 0; //表示斐波那契分割数值的下标
        int mid = 0; //存放mid值
        int f[] = fib();//获取斐波那契数列
        //获取到斐波那契分割数值的下标
        while (high > f[k]-1) {
            k++;
        }
        //因为f[k] 值 可能大于arr的长度，因此需要使用Arrays类，构造一个新的数组，并指向a[]
        int[] temp = Arrays.copyOf(arr, f[k]-1);
        //将arr数组中扩充的部分，使用arr最后的数填充
        for(int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //使用while循环来找到key
        while (low <= high) {
            mid = low + f[k - 1] -1;
            if (key < temp[mid]) {//继续向数组左边查找
                high = mid - 1;
                //带查找的全部元素 = mid前面的元素 + mid后面的元素
                //f[k]            =   f[k-1]     +   f[k-2]
                //因为前面有f[k-1]个元素，所以可以继续拆分f[k-1] = f[k-2]+f[k-3]
                k--;
            }else if (key > temp[mid]) {//继续向数组右边查找
                low = mid + 1;
                //全部元素 = 前面的元素 + 后面的元素
                //  f[k]   =   f[k-1]  +   f[k-2],  后面有f[k - 2] 个元素
                //所以继续拆分f[k-1 - 2] = f[k -3] + f[k - 4]
                //下次循环 mid = f[k - 1 - 2]
                k -= 2;
            }else {//找到
                if (mid <= high) {
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
    public static int maxSize = 20;
    //因为后面需要mid = left + F(k-1) -1,需要使用斐波那契数列，先定义一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    /*
    插值查找：
        原二分查找公式 mid = (left + right) / 2 = left + (right - left)/2
        插值查找公式有优化为 mid = left + (right - left)* (findValue - arr[left])/(arr[right] - arr[left])

        对于数据量比较大，关键字分布比较均匀的查找表来说，采用插值查找速度较快
        关键字分布不均匀的情况下，该方法不一定比折半查找好
    */
    public static ArrayList<Integer> insertSearch(int[] arr, int left, int right, int findValue) {
        System.out.println("插值查找");
        int mid = left + (right - left)* (findValue - arr[left])/(arr[right] - arr[left]);
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return new ArrayList<>();
        }
        if (arr[mid] > findValue) {
            return insertSearch(arr, left, mid - 1, findValue);
        }else if (arr[mid] < findValue) {
            return insertSearch(arr, mid + 1, right, findValue);
        }else {
            ArrayList<Integer> resIndex = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findValue) {
                    break;
                }
                resIndex.add(temp);
                temp -= 1;
            }
            resIndex.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findValue) {
                    break;
                }
                resIndex.add(temp);
                temp += 1;
            }
            return resIndex;
        }
    }

    /*
    二分查找：
        请对一个【有序数组】进行二分查找，{1,810,89,1000,1234}
        思路：
            1、首先确定该数组的中间下标 mid = (left + right)/2
            2、然后让需要查到的数findValue和arr[mid]比较
                若：findValue > arr[mid] 说明需要查找的数在mid右边，因此向右递归查找
                若：findValue < arr[mid] 说明你要查找的数就min左边，因此向左递归查找
                若：findValue = arr[mid] 说明找到，返回
            //什么时候需要递归结束
                1、找到就结束
                2、未找到，当left > right 就要退出
    */
    public static int BinarySearch(int[] arr, int left, int right,int findValue) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findValue > midValue) {
            return BinarySearch(arr, mid + 1, right, findValue);
        }else if (findValue < midValue) {
            return BinarySearch(arr, left, mid -1, findValue);
        }else {
            return mid;
        }
    }
    //返回数据中所有的目标值索引
    public static ArrayList BinarySearch1(int[] arr, int left, int right, int findValue) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findValue > midValue) {
            return BinarySearch1(arr, mid + 1, right, findValue);
        }else if (findValue < midValue) {
            return BinarySearch1(arr, left, mid -1, findValue);
        }else {
            ArrayList<Integer> resIndexlist = new ArrayList<>();
            //向mid索引值的左右边扫描，将所有满足目标元素的下标，加入到ArrayList集合
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findValue) {
                    break;
                }
                //否则 将temp放入到集合中
                resIndexlist.add(temp);
                temp -= 1;
            }
            resIndexlist.add(mid);
            //向mid索引值的右边扫描，将所有满足目标元素的下标 加入到集合
            temp = mid + 1;
            while (true) {
                if (temp > arr.length -1 || arr[temp] != findValue) {
                    break;
                }
                //否则 将temp放入到集合中
                resIndexlist.add(temp);
                temp += 1;
            }
            return resIndexlist;
        }
    }

    /*
    线性查找算法
     要求：有一个数列{1,8,10,89,1000,1234}，判断数列中是否包含此名称，如果找到，就提示找到并给出下标值
        思路：如果查找到全部符合条件的值
    */
    public static int SeqSearch(int[] arr, int value) {
        //线性查找是逐一比对
        for (int i= 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
