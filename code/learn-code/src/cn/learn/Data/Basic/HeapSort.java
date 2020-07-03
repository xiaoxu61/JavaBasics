package cn.learn.Data.Basic;
/*
    实现堆排序
        基本思路：
            1、将无序序列构建成一个堆，根据升序降序需求选择大顶堆（升序）或小顶堆（降序）
            2、将堆顶元素与末尾元素交换，将最大元素 沉 到数组末端
            3、重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前尾末元素，反复执行调整+交换步骤
                直到整个序列有序
*/

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序排序
        int[] arr = {4,6,8,5,9,8,7,6,3,0,0};
        heapSort(arr,1);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr,int i) {
        if ( arr == null || arr.length < 2) return;
        for (i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index-1)/2]) {
            swap(arr,index,(index - 1)/2);
            index = (index-1)/2;
        }
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index*2+1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left+1] > arr[left]
                    ? left +1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index*2+1;
        }
    }

    //编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        int temp = 0;

        System.out.println("堆排序！");

        //分布完成
        /*adjustHeap(arr,1,arr.length);
        System.out.println("第一次" + Arrays.toString(arr));//49856
        adjustHeap(arr,0,arr.length);
        System.out.println("第二次" + Arrays.toString(arr));//96854*/

        //完成最终代码
        //将无序序列构成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for(int i = arr.length/2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
            System.out.println(Arrays.toString(arr));
        }

        //2、将堆顶元素与尾末元素交换，将最大元素"沉"到数组末端
        //3、重新调整结构，使其满足定义，然后继续交换堆顶元素与当前末尾元素，反复调整+交换步骤，直到整个序列有序
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
            System.out.println(Arrays.toString(arr));
        }
    }

    //将一个数组（二叉树）调整成一个大顶堆

    /**
     *功能：完成将以i对应的非叶子节点的树调整成大顶堆
     * 举例：arr = {4,6,8,5,9} => i=1 => adjustHeap => 得到{4，9，8，5，6}
     * 如果我们再次调用 adjustHeap 传入的 i=0 => 得到{4，9，8，5，6} => {9,6,8,5,4}
     *
     * @param arr 待调整的数组
     * @param i    表示非叶子节点在数组中索引
     * @param length 表示对多少个元素继续调整，并且是在逐渐减少
    */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //k = i*2+1 k是i节点的左子节点
        //k = i*2+2 k是i节点的右子节点
        //(i-1)/2   就是i节点的父节点
        for (int k = i*2+1; k < length; k = k*2+1) {
            if (k+1 < length && arr[k] < arr[k+1]){//说明左子节点的值小于右子节点的值
                k++;//k指向右指针
            }
            if (arr[k] > temp) {//如果子节点，大于父节点
                arr[i] = arr[k];//把较大的值赋给当前节点
                i = k;//!!!i指向k，继续循环比较
            } else {
                break;
            }
        }
        //当循环结束，已经将以i为父节点的树最大值，放在最顶端（局部）
        arr[i] = temp;//将temp值放到调整后的位置
    }
}
