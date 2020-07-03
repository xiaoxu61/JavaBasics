package cn.learn.Data.Basic;

import java.util.Arrays;
import java.util.HashMap;

public class Demo11Sort {
    public static void main(String[] args) {
//        int[] arr = {3,9,-1,10,20};
//        int[] arr2 = {101,34,119,1,-1,2,5};
//        int[] arr = {101, 34, 119, 1};
//        int[] arr = {8,9,1,7,2,3,5,4,6,0};
//        int[] arr = {-9,0,78,0,23,-567,70,0,};
//        int[] arr = {8,4,5,7,1,3,6,2};
//        int[] arr = {53,3,542,748,14,214};

        //int[] arr = {0,78,0,-1,-2};


        //测试 一下冒泡排序的速度O(n^2) 给80000个数据。测试
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random() * 80000);//生成一个[0,80000) 的随机数
        }
        long start = System.currentTimeMillis();
//        bubbleSort(arr);//冒泡排序：14687毫秒
//        selectSort(arr);//选择排序：5646毫秒
//        insertSort(arr);//插入排序：1608毫秒
//        shellSort(arr);//希尔排序交换法：12209毫秒
//        shell2Sort(arr);//希尔排序移动法：33毫秒
//        quickSort(arr, 0, arr.length - 1);//快速排序法：115毫秒
        quickSort(0, arr.length - 1, arr);
//        mergeSort(arr, 0, arr.length-1, new int[arr.length]);//归并排序：31毫秒
//        mergeSort(arr);
//        radixSort(arr);//基数排序：110毫秒
        long end = System.currentTimeMillis();
        System.out.printf("用时：%d毫秒\n", (end - start));
        System.out.println(Arrays.toString(arr));
//        System.out.println(1/2);
//        System.out.println((int)Math.pow(10,0));

    }

    /*
    {53,3,542,748,14,214}
    基数排序：
     思想：
        将所有待比较数值统一为同样的位数长度，位数较短的数前面补零，然后，从最低位开始，依次进行依次排序。
     这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列
     第一轮：将每个元素的个位数取出
         第一步然后看这个数应该放在哪个对应的桶（一个一维数组）
         第二步按照桶的顺序依次取出数据，放到原数组
     第二轮：将每个元素的十位数取出（没有的为零）重复上述步骤
    */
    public static void radixSort(int[] arr) {

        //定义一个二维数组，表示10个桶，每个桶就是一个数组
        //为了包含10个一维数组，防止放入数的时候溢出，则每一个一维数组桶的大小定为待排序数组的长度
        int[][] bucket = new int[10][arr.length];//设置桶的二位数组
        //记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录每个桶的每次放入的数据个数
        //比如：bucketElementCount[0] 就是bucket[0] 桶的放入数据个数
        int[] bucketElementCount = new int[10];
        int digitOfElement = 0;

        //第一轮排序（针对每个元素的个位进行排序）
        //桶中存放数据
        /*for(int i = 0; i < arr.length; i++) {
            //拿到数中的个位
            digitOfElement = arr[i] % 10;
            //将值放到桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
            //将桶中数据个数保存到bucketElementCount中
            bucketElementCount[digitOfElement]++;
        }
        //按顺序取出桶中数据
        int index = 0;//按照一位数组的下标依次取出数据

        for (int i = 0; i < bucketElementCount.length; i++) {
            //若桶中有数据，才将数据依次取出
            if (bucketElementCount[i] != 0) {
                //循环该桶
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            //第一轮处理后，需要将[bucketElementCount[i] 置零
            bucketElementCount[i] = 0;
        }
        System.out.println("first:" + Arrays.toString(arr));

        //第二轮排序（针对每个元素的个位进行排序）
        //桶中存放数据
        for(int i = 0; i < arr.length; i++) {
            //拿到数中的十位
            digitOfElement = arr[i] /10 % 10;
            //将值放到桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
            //将桶中数据个数保存到bucketElementCount中
            bucketElementCount[digitOfElement]++;
        }
        //按顺序取出桶中数据
        index = 0;//按照一位数组的下标依次取出数据

        for (int i = 0; i < bucketElementCount.length; i++) {
            //若桶中有数据，才将数据依次取出
            if (bucketElementCount[i] != 0) {
                //循环该桶
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElementCount[i] = 0;
        }
        System.out.println("second:" + Arrays.toString(arr));

        //第三轮排序（针对每个元素的个位进行排序）
        //桶中存放数据
        for(int i = 0; i < arr.length; i++) {
            //拿到数中的十位
            digitOfElement = arr[i] /100 % 10;
            //将值放到桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
            //将桶中数据个数保存到bucketElementCount中
            bucketElementCount[digitOfElement]++;
        }
        //按顺序取出桶中数据
        index = 0;//按照一位数组的下标依次取出数据

        for (int i = 0; i < bucketElementCount.length; i++) {
            //若桶中有数据，才将数据依次取出
            if (bucketElementCount[i] != 0) {
                //循环该桶
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElementCount[i] = 0;
        }
        System.out.println("third:" + Arrays.toString(arr));*/

        //先得到数据中最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //得到最大数的位数
        int maxLength = (max + "").length();

        //使用循环将代码处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < arr.length; j++) {
                digitOfElement = arr[j] / n % 10;
//                digitOfElement = arr[j] /((int)Math.pow(10,i)) %10;
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                bucketElementCount[digitOfElement]++;

            }
            int index = 0;
            for (int j = 0; j < bucketElementCount.length; j++) {
                if (bucketElementCount[j] != 0) {
                    for (int k = 0; k < bucketElementCount[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                bucketElementCount[j] = 0;
            }
//            System.out.println("第" + i + "轮，得到数据为" + Arrays.toString(arr));
        }
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);

        }
    }

    /**
     * 合并：
     * 8,4,5,7,1,3,6,2
     * 归并排序：
     * 先分后治
     * 分：将数据逐步分成n份
     * 治：将分好的数据，按组合并，逐渐合并为原来数组长度
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftPar = left;//初始化 左边有序序列的初始索引
        int midPar = mid + 1;//初始化 右边有序序列的初始索引
        int t = 0;//temp数组的当前索引
        //(一) 先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完为止
        while (leftPar <= mid && midPar <= right) {
            //如果左边的有序序列的当前元素，小于等于右边的有序序列的当前元素
            //则 将左边的当前元素，填充到temp

            if (arr[leftPar] <= arr[midPar]) {
                temp[t] = arr[leftPar];
                t += 1;
                leftPar += 1;
            } else {//反之 将右边的元素填充到temp
                temp[t] = arr[midPar];
                t += 1;
                midPar += 1;
            }
        }
        //将有剩余数据数列中的剩余数据全部依次填充到 temp中
        while (leftPar <= mid) {
            temp[t] = arr[leftPar];
            t += 1;
            leftPar += 1;
        }
        while (midPar <= right) {
            temp[t] = arr[midPar];
            t += 1;
            midPar += 1;
        }
        //将temp数组的元素拷贝到arr
        t = 0;
        int tempLeft = left;
        //第一次合并 tempLeft = 0  right = 1 // 第二次tempLeft = 2  right = 3 //tempLeft = 0  right = 3
        //最后一次tempLeft = 0  right = 7
//        System.out.println(tempLeft +" " + right);
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int L, int R) {
        if (L == R) return;
        int mid = L + ((R - L) >> 1);//L和R的中点的位置(L+R)/2
        sortProcess(arr, L, mid);//T(N/2)
        sortProcess(arr, mid + 1, R);//T(N/2)
        merge(arr, L, mid, R);//O(N)
        //T(N) = 2T(N/2) + O(N)
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    /*
    -9,78,0,23,-567,70
    快速排序法
    */
    public static void quickSort(int[] arr, int left, int right) {
        int pivot = arr[(right + left) / 2];//拿到一个中间值
        int leftPar = left;//初始化数据左端索引
        int rightPar = right;//初始化数据右端索引
        int temp = 0;//中间值
        while (leftPar < rightPar) {

            //在左边找到比中间值大的，然后退出
            while (arr[leftPar] < pivot) {
                leftPar += 1;
            }

            //在右边找到比中间值小的值，然后退出
            while (arr[rightPar] > pivot) {
                rightPar -= 1;
            }

            //如果下式成立，说明pivot左边的值全部是小于pivot的值，右边的值全部是大于pivot的值
            if (leftPar >= rightPar) {
                break;
            }

            //交换
            temp = arr[leftPar];
            arr[leftPar] = arr[rightPar];
            arr[rightPar] = temp;

            //交换完成后，发现arr[leftPar] == pivot rightPar-- 前移
            //              arr[rightPar] == pivot leftPar++  后移
            //否则可能出现死循环
            if (arr[leftPar] == pivot) {
                rightPar -= 1;
            }
            //同理，将其l++ 后移
            if (arr[rightPar] == pivot) {
                leftPar += 1;
            }
        }
        //如果leftPar == rightPar 必须左加一，右减一，否则出现栈溢出
        if (leftPar == rightPar) {
            leftPar += 1;
            rightPar -= 1;
        }
        //向左递归
        if (left < rightPar) {
            quickSort(arr, left, rightPar);
        }
//        System.out.println(leftPar);

        //向右递归
        if (right > leftPar) {
            quickSort(arr, leftPar, right);
        }
    }

    public static void quickSort(int L, int R, int[] arr) {
        if (L < R) {
            swap(arr, (int)(L + Math.random()*(R-L+1)), R);
            int[] p = partition(arr, L, R);
            quickSort(L, p[0] - 1, arr);
            quickSort(p[1] + 1, R, arr);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;//默认最后一位不动
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        swap(arr, more, R);//将最后一位的数，与大于他的数的第一个交换
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }

    //希尔排序的移动法
    public static void shell2Sort(int[] arr) {
//        int count = 0;
        int temp = 0;
//        int count = 0;
        //根据前面分析，得到如下循环
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //遍历各组中的所有元素（共gap组，每组有arr.length/gap个元素）步长为gap
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                if (arr[j - gap] > arr[j]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当while退出后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
//                count++;
//            System.out.printf("第%d轮希尔排序得到结果为%s\n",count,Arrays.toString(arr));

        }

    }

    /*
    希尔排序：
        是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，
        当增量减至1时，整个文件恰被分成一组，算法便终止

    */
    public static void shellSort(int[] arr) {

        //第一轮排序
        //因为第一轮排序，是将10个数分成了 10/2 = 5组
        /*int temp = 0;
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j+5]) {
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        //第二轮排序
        //因为第二轮排序，是将10个数分成了 10/2 = 5/2 = 2 组
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j+2]) {
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        //第三轮排序
        //因为第三轮排序，是将10个数分成了 10/2 = 5/2 = 2/2 = 1 组
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));*/
        int temp = 0;
//        int count = 0;
        //根据前面分析，得到如下循环
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //遍历各组中的所有元素（共gap组，每组有arr.length/gap个元素）步长为gap
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            count++;
//            System.out.printf("第%d轮希尔排序得到结果为%s\n",count,Arrays.toString(arr));
        }


    }

    /*
    插入排序：
    思想：
        把n个待排序的元素看成是一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含n-1个元素
        排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，
        将它插入到有序表中的适当位置，使之成为新的有序表
    */
    public static void insertSort(int[] arr) {

        //逐步实现
        //{101, 34, 119, 1}
        /*int insertValue = arr[1];
        int insertIndex = 1 - 1;
        //给insertValue找到插入的位置
        //       防止越界异常           假定预插入点是插入值的前一个位置
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //推出循环时，说明插入点找到
        arr[insertIndex + 1] = insertValue;
        System.out.println("第一次插入：" + Arrays.toString(arr));

        insertValue = arr[2];
        insertIndex = 2 - 1;
        //给insertValue找到插入的位置
        //       防止越界异常           假定预插入点是插入值的前一个位置
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //推出循环时，说明插入点找到
        arr[insertIndex + 1] = insertValue;
        System.out.println("第二次插入：" + Arrays.toString(arr));

        insertValue = arr[3];
        insertIndex = 3 - 1;
        //给insertValue找到插入的位置
        //       防止越界异常           假定预插入点是插入值的前一个位置
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //推出循环时，说明插入点找到
        arr[insertIndex + 1] = insertValue;
        System.out.println("第三次插入：" + Arrays.toString(arr));*/
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i - 1;
            //       防止越界异常           假定预插入点是插入值的前一个位置
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //若插入点位置就是当前位置，则不用执行下面语句
//            if (insertValue + 1 != i) {
            arr[insertIndex + 1] = insertValue;
//            }
        }
    }

    /*
    选择排序：
        选择排序一共有 数组大小-1 轮排序
        每一轮排序，又是一个循环，循环的规则
            假定当前这个数是最小数
            然后和后面的每个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标
            当遍历到数组的最后时，就得到了本轮最小数和下标
            然后与当前数进行交换
    */
    public static void selectSort(int[] arr) {

        //按步解析选择排序
        /*int minIndex = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                //若当前数小于假定的最小数，则重置最小数并记下其索引
                min = arr[i];
                minIndex = i;
            }
        }
        //循环完毕后，将最小值与第一个数据交换
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        System.out.println(Arrays.toString(arr));
        }

        minIndex = 1;
        min = arr[1];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                //若当前数小于假定的最小数，则重置最小数并记下其索引
                min = arr[i];
                minIndex = i;
            }
        }
        //循环完毕后，将最小值与第一个数据交换
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        System.out.println(Arrays.toString(arr));
        }

        minIndex = 2;
        min = arr[2];
        for (int i = 2; i < arr.length; i++) {
            if (min > arr[i]) {
                //若当前数小于假定的最小数，则重置最小数并记下其索引
                min = arr[i];
                minIndex = i;
            }
        }
        //循环完毕后，将最小值与第一个数据交换
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        System.out.println(Arrays.toString(arr));
        }*/

        //代码实现
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
//                System.out.printf("第%d轮循环，的到的数据为：%s\n", i , Arrays.toString(arr));
            }
        }

    }

    /*
        冒泡排序法
            思想：
                从数据最左端开始，两两数据依次相比较，直至数据最右端；从左至右算一次循环
                第一次循环完毕，可找到该数据中最大的数，即，排在数据最右端（从小到大排序）
                至多循环n-1后即可排完
    */
    public static void bubbleSort(int[] arr) {
//        System.out.println("待排序的数据：" + Arrays.toString(arr));
        int temp = 0;
        //排序的思路实现
       /* for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println( "第一轮排序后：" + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1 - 1; i++) {
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println( "第二轮排序后：" + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1 - 2; i++) {
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println( "第三轮排序后：" + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1 - 3; i++) {
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println( "第四轮排序后：" + Arrays.toString(arr));*/

        //优化后的冒泡排序法
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
//                System.out.println("提前排序完成：" + Arrays.toString(arr));
                break;
            } else {
                flag = false;
            }
//            System.out.println("第" + (i + 1) + "轮排序后：" + Arrays.toString(arr));
        }
    }
}
