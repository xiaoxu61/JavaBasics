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


        //���� һ��ð��������ٶ�O(n^2) ��80000�����ݡ�����
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random() * 80000);//����һ��[0,80000) �������
        }
        long start = System.currentTimeMillis();
//        bubbleSort(arr);//ð������14687����
//        selectSort(arr);//ѡ������5646����
//        insertSort(arr);//��������1608����
//        shellSort(arr);//ϣ�����򽻻�����12209����
//        shell2Sort(arr);//ϣ�������ƶ�����33����
//        quickSort(arr, 0, arr.length - 1);//�������򷨣�115����
        quickSort(0, arr.length - 1, arr);
//        mergeSort(arr, 0, arr.length-1, new int[arr.length]);//�鲢����31����
//        mergeSort(arr);
//        radixSort(arr);//��������110����
        long end = System.currentTimeMillis();
        System.out.printf("��ʱ��%d����\n", (end - start));
        System.out.println(Arrays.toString(arr));
//        System.out.println(1/2);
//        System.out.println((int)Math.pow(10,0));

    }

    /*
    {53,3,542,748,14,214}
    ��������
     ˼�룺
        �����д��Ƚ���ֵͳһΪͬ����λ�����ȣ�λ���϶̵���ǰ�油�㣬Ȼ�󣬴����λ��ʼ�����ν�����������
     ���������λ����һֱ�����λ��������Ժ����оͱ��һ����������
     ��һ�֣���ÿ��Ԫ�صĸ�λ��ȡ��
         ��һ��Ȼ�������Ӧ�÷����ĸ���Ӧ��Ͱ��һ��һά���飩
         �ڶ�������Ͱ��˳������ȡ�����ݣ��ŵ�ԭ����
     �ڶ��֣���ÿ��Ԫ�ص�ʮλ��ȡ����û�е�Ϊ�㣩�ظ���������
    */
    public static void radixSort(int[] arr) {

        //����һ����ά���飬��ʾ10��Ͱ��ÿ��Ͱ����һ������
        //Ϊ�˰���10��һά���飬��ֹ��������ʱ���������ÿһ��һά����Ͱ�Ĵ�С��Ϊ����������ĳ���
        int[][] bucket = new int[10][arr.length];//����Ͱ�Ķ�λ����
        //��¼ÿ��Ͱ�У�ʵ�ʴ���˶��ٸ����ݣ����Ƕ���һ��һά��������¼ÿ��Ͱ��ÿ�η�������ݸ���
        //���磺bucketElementCount[0] ����bucket[0] Ͱ�ķ������ݸ���
        int[] bucketElementCount = new int[10];
        int digitOfElement = 0;

        //��һ���������ÿ��Ԫ�صĸ�λ��������
        //Ͱ�д������
        /*for(int i = 0; i < arr.length; i++) {
            //�õ����еĸ�λ
            digitOfElement = arr[i] % 10;
            //��ֵ�ŵ�Ͱ��
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
            //��Ͱ�����ݸ������浽bucketElementCount��
            bucketElementCount[digitOfElement]++;
        }
        //��˳��ȡ��Ͱ������
        int index = 0;//����һλ������±�����ȡ������

        for (int i = 0; i < bucketElementCount.length; i++) {
            //��Ͱ�������ݣ��Ž���������ȡ��
            if (bucketElementCount[i] != 0) {
                //ѭ����Ͱ
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            //��һ�ִ������Ҫ��[bucketElementCount[i] ����
            bucketElementCount[i] = 0;
        }
        System.out.println("first:" + Arrays.toString(arr));

        //�ڶ����������ÿ��Ԫ�صĸ�λ��������
        //Ͱ�д������
        for(int i = 0; i < arr.length; i++) {
            //�õ����е�ʮλ
            digitOfElement = arr[i] /10 % 10;
            //��ֵ�ŵ�Ͱ��
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
            //��Ͱ�����ݸ������浽bucketElementCount��
            bucketElementCount[digitOfElement]++;
        }
        //��˳��ȡ��Ͱ������
        index = 0;//����һλ������±�����ȡ������

        for (int i = 0; i < bucketElementCount.length; i++) {
            //��Ͱ�������ݣ��Ž���������ȡ��
            if (bucketElementCount[i] != 0) {
                //ѭ����Ͱ
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElementCount[i] = 0;
        }
        System.out.println("second:" + Arrays.toString(arr));

        //�������������ÿ��Ԫ�صĸ�λ��������
        //Ͱ�д������
        for(int i = 0; i < arr.length; i++) {
            //�õ����е�ʮλ
            digitOfElement = arr[i] /100 % 10;
            //��ֵ�ŵ�Ͱ��
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
            //��Ͱ�����ݸ������浽bucketElementCount��
            bucketElementCount[digitOfElement]++;
        }
        //��˳��ȡ��Ͱ������
        index = 0;//����һλ������±�����ȡ������

        for (int i = 0; i < bucketElementCount.length; i++) {
            //��Ͱ�������ݣ��Ž���������ȡ��
            if (bucketElementCount[i] != 0) {
                //ѭ����Ͱ
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElementCount[i] = 0;
        }
        System.out.println("third:" + Arrays.toString(arr));*/

        //�ȵõ�������������
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //�õ��������λ��
        int maxLength = (max + "").length();

        //ʹ��ѭ�������봦��
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
//            System.out.println("��" + i + "�֣��õ�����Ϊ" + Arrays.toString(arr));
        }
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //�м�����
            //����ݹ�ֽ�
            mergeSort(arr, left, mid, temp);
            //���ҵݹ�ֽ�
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);

        }
    }

    /**
     * �ϲ���
     * 8,4,5,7,1,3,6,2
     * �鲢����
     * �ȷֺ���
     * �֣��������𲽷ֳ�n��
     * �Σ����ֺõ����ݣ�����ϲ����𽥺ϲ�Ϊԭ�����鳤��
     *
     * @param arr   �����ԭʼ����
     * @param left  ����������еĳ�ʼ����
     * @param mid   �м�����
     * @param right �ұ�����
     * @param temp  ����ת����
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftPar = left;//��ʼ�� ����������еĳ�ʼ����
        int midPar = mid + 1;//��ʼ�� �ұ��������еĳ�ʼ����
        int t = 0;//temp����ĵ�ǰ����
        //(һ) �Ȱ��������ߣ����򣩵����ݰ��չ�����䵽temp����
        //ֱ���������ߵ��������У���һ�ߴ�����Ϊֹ
        while (leftPar <= mid && midPar <= right) {
            //�����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұߵ��������еĵ�ǰԪ��
            //�� ����ߵĵ�ǰԪ�أ���䵽temp

            if (arr[leftPar] <= arr[midPar]) {
                temp[t] = arr[leftPar];
                t += 1;
                leftPar += 1;
            } else {//��֮ ���ұߵ�Ԫ����䵽temp
                temp[t] = arr[midPar];
                t += 1;
                midPar += 1;
            }
        }
        //����ʣ�����������е�ʣ������ȫ��������䵽 temp��
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
        //��temp�����Ԫ�ؿ�����arr
        t = 0;
        int tempLeft = left;
        //��һ�κϲ� tempLeft = 0  right = 1 // �ڶ���tempLeft = 2  right = 3 //tempLeft = 0  right = 3
        //���һ��tempLeft = 0  right = 7
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
        int mid = L + ((R - L) >> 1);//L��R���е��λ��(L+R)/2
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
    ��������
    */
    public static void quickSort(int[] arr, int left, int right) {
        int pivot = arr[(right + left) / 2];//�õ�һ���м�ֵ
        int leftPar = left;//��ʼ�������������
        int rightPar = right;//��ʼ�������Ҷ�����
        int temp = 0;//�м�ֵ
        while (leftPar < rightPar) {

            //������ҵ����м�ֵ��ģ�Ȼ���˳�
            while (arr[leftPar] < pivot) {
                leftPar += 1;
            }

            //���ұ��ҵ����м�ֵС��ֵ��Ȼ���˳�
            while (arr[rightPar] > pivot) {
                rightPar -= 1;
            }

            //�����ʽ������˵��pivot��ߵ�ֵȫ����С��pivot��ֵ���ұߵ�ֵȫ���Ǵ���pivot��ֵ
            if (leftPar >= rightPar) {
                break;
            }

            //����
            temp = arr[leftPar];
            arr[leftPar] = arr[rightPar];
            arr[rightPar] = temp;

            //������ɺ󣬷���arr[leftPar] == pivot rightPar-- ǰ��
            //              arr[rightPar] == pivot leftPar++  ����
            //������ܳ�����ѭ��
            if (arr[leftPar] == pivot) {
                rightPar -= 1;
            }
            //ͬ������l++ ����
            if (arr[rightPar] == pivot) {
                leftPar += 1;
            }
        }
        //���leftPar == rightPar �������һ���Ҽ�һ���������ջ���
        if (leftPar == rightPar) {
            leftPar += 1;
            rightPar -= 1;
        }
        //����ݹ�
        if (left < rightPar) {
            quickSort(arr, left, rightPar);
        }
//        System.out.println(leftPar);

        //���ҵݹ�
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
        int more = R;//Ĭ�����һλ����
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        swap(arr, more, R);//�����һλ������������������ĵ�һ������
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }

    //ϣ��������ƶ���
    public static void shell2Sort(int[] arr) {
//        int count = 0;
        int temp = 0;
//        int count = 0;
        //����ǰ��������õ�����ѭ��
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //���������е�����Ԫ�أ���gap�飬ÿ����arr.length/gap��Ԫ�أ�����Ϊgap
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                if (arr[j - gap] > arr[j]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //�ƶ�
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //��while�˳��󣬾͸�temp�ҵ������λ��
                    arr[j] = temp;
                }

            }
//                count++;
//            System.out.printf("��%d��ϣ������õ����Ϊ%s\n",count,Arrays.toString(arr));

        }

    }

    /*
    ϣ������
        �ǰѼ�¼���±��һ���������飬��ÿ��ʹ��ֱ�Ӳ��������㷨�������������𽥼��٣�ÿ������Ĺؼ���Խ��Խ�࣬
        ����������1ʱ�������ļ�ǡ���ֳ�һ�飬�㷨����ֹ

    */
    public static void shellSort(int[] arr) {

        //��һ������
        //��Ϊ��һ�������ǽ�10�����ֳ��� 10/2 = 5��
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

        //�ڶ�������
        //��Ϊ�ڶ��������ǽ�10�����ֳ��� 10/2 = 5/2 = 2 ��
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

        //����������
        //��Ϊ�����������ǽ�10�����ֳ��� 10/2 = 5/2 = 2/2 = 1 ��
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
        //����ǰ��������õ�����ѭ��
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //���������е�����Ԫ�أ���gap�飬ÿ����arr.length/gap��Ԫ�أ�����Ϊgap
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    //�����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�����
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            count++;
//            System.out.printf("��%d��ϣ������õ����Ϊ%s\n",count,Arrays.toString(arr));
        }


    }

    /*
    ��������
    ˼�룺
        ��n���������Ԫ�ؿ�����һ��������һ���������ʼʱ�������ֻ����һ��Ԫ�أ�������а���n-1��Ԫ��
        ���������ÿ�δ��������ȡ����һ��Ԫ�أ������������������������Ԫ�ص���������бȽϣ�
        �������뵽������е��ʵ�λ�ã�ʹ֮��Ϊ�µ������
    */
    public static void insertSort(int[] arr) {

        //��ʵ��
        //{101, 34, 119, 1}
        /*int insertValue = arr[1];
        int insertIndex = 1 - 1;
        //��insertValue�ҵ������λ��
        //       ��ֹԽ���쳣           �ٶ�Ԥ������ǲ���ֵ��ǰһ��λ��
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //�Ƴ�ѭ��ʱ��˵��������ҵ�
        arr[insertIndex + 1] = insertValue;
        System.out.println("��һ�β��룺" + Arrays.toString(arr));

        insertValue = arr[2];
        insertIndex = 2 - 1;
        //��insertValue�ҵ������λ��
        //       ��ֹԽ���쳣           �ٶ�Ԥ������ǲ���ֵ��ǰһ��λ��
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //�Ƴ�ѭ��ʱ��˵��������ҵ�
        arr[insertIndex + 1] = insertValue;
        System.out.println("�ڶ��β��룺" + Arrays.toString(arr));

        insertValue = arr[3];
        insertIndex = 3 - 1;
        //��insertValue�ҵ������λ��
        //       ��ֹԽ���쳣           �ٶ�Ԥ������ǲ���ֵ��ǰһ��λ��
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //�Ƴ�ѭ��ʱ��˵��������ҵ�
        arr[insertIndex + 1] = insertValue;
        System.out.println("�����β��룺" + Arrays.toString(arr));*/
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i - 1;
            //       ��ֹԽ���쳣           �ٶ�Ԥ������ǲ���ֵ��ǰһ��λ��
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //�������λ�þ��ǵ�ǰλ�ã�����ִ���������
//            if (insertValue + 1 != i) {
            arr[insertIndex + 1] = insertValue;
//            }
        }
    }

    /*
    ѡ������
        ѡ������һ���� �����С-1 ������
        ÿһ����������һ��ѭ����ѭ���Ĺ���
            �ٶ���ǰ���������С��
            Ȼ��ͺ����ÿ�������бȽϣ���������бȵ�ǰ����С������������ȷ����С�������õ��±�
            ����������������ʱ���͵õ��˱�����С�����±�
            Ȼ���뵱ǰ�����н���
    */
    public static void selectSort(int[] arr) {

        //��������ѡ������
        /*int minIndex = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                //����ǰ��С�ڼٶ�����С������������С��������������
                min = arr[i];
                minIndex = i;
            }
        }
        //ѭ����Ϻ󣬽���Сֵ���һ�����ݽ���
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        System.out.println(Arrays.toString(arr));
        }

        minIndex = 1;
        min = arr[1];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                //����ǰ��С�ڼٶ�����С������������С��������������
                min = arr[i];
                minIndex = i;
            }
        }
        //ѭ����Ϻ󣬽���Сֵ���һ�����ݽ���
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        System.out.println(Arrays.toString(arr));
        }

        minIndex = 2;
        min = arr[2];
        for (int i = 2; i < arr.length; i++) {
            if (min > arr[i]) {
                //����ǰ��С�ڼٶ�����С������������С��������������
                min = arr[i];
                minIndex = i;
            }
        }
        //ѭ����Ϻ󣬽���Сֵ���һ�����ݽ���
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        System.out.println(Arrays.toString(arr));
        }*/

        //����ʵ��
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
//                System.out.printf("��%d��ѭ�����ĵ�������Ϊ��%s\n", i , Arrays.toString(arr));
            }
        }

    }

    /*
        ð������
            ˼�룺
                ����������˿�ʼ����������������Ƚϣ�ֱ���������Ҷˣ�����������һ��ѭ��
                ��һ��ѭ����ϣ����ҵ��������������������������������Ҷˣ���С��������
                ����ѭ��n-1�󼴿�����
    */
    public static void bubbleSort(int[] arr) {
//        System.out.println("����������ݣ�" + Arrays.toString(arr));
        int temp = 0;
        //�����˼·ʵ��
       /* for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println( "��һ�������" + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1 - 1; i++) {
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println( "�ڶ��������" + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1 - 2; i++) {
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println( "�����������" + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1 - 3; i++) {
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println( "�����������" + Arrays.toString(arr));*/

        //�Ż����ð������
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
//                System.out.println("��ǰ������ɣ�" + Arrays.toString(arr));
                break;
            } else {
                flag = false;
            }
//            System.out.println("��" + (i + 1) + "�������" + Arrays.toString(arr));
        }
    }
}
