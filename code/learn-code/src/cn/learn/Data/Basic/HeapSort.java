package cn.learn.Data.Basic;
/*
    ʵ�ֶ�����
        ����˼·��
            1�����������й�����һ���ѣ���������������ѡ��󶥶ѣ����򣩻�С���ѣ�����
            2�����Ѷ�Ԫ����ĩβԪ�ؽ����������Ԫ�� �� ������ĩ��
            3�����µ����ṹ��ʹ������Ѷ��壬Ȼ����������Ѷ�Ԫ���뵱ǰβĩԪ�أ�����ִ�е���+��������
                ֱ��������������
*/

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //Ҫ�����������������
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

    //��дһ��������ķ���
    public static void heapSort(int arr[]) {
        int temp = 0;

        System.out.println("������");

        //�ֲ����
        /*adjustHeap(arr,1,arr.length);
        System.out.println("��һ��" + Arrays.toString(arr));//49856
        adjustHeap(arr,0,arr.length);
        System.out.println("�ڶ���" + Arrays.toString(arr));//96854*/

        //������մ���
        //���������й���һ���ѣ���������������ѡ��󶥶ѻ�С����
        for(int i = arr.length/2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
            System.out.println(Arrays.toString(arr));
        }

        //2�����Ѷ�Ԫ����βĩԪ�ؽ����������Ԫ��"��"������ĩ��
        //3�����µ����ṹ��ʹ�����㶨�壬Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ�أ���������+�������裬ֱ��������������
        for (int j = arr.length - 1; j > 0; j--) {
            //����
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
            System.out.println(Arrays.toString(arr));
        }
    }

    //��һ�����飨��������������һ���󶥶�

    /**
     *���ܣ���ɽ���i��Ӧ�ķ�Ҷ�ӽڵ���������ɴ󶥶�
     * ������arr = {4,6,8,5,9} => i=1 => adjustHeap => �õ�{4��9��8��5��6}
     * ��������ٴε��� adjustHeap ����� i=0 => �õ�{4��9��8��5��6} => {9,6,8,5,4}
     *
     * @param arr ������������
     * @param i    ��ʾ��Ҷ�ӽڵ�������������
     * @param length ��ʾ�Զ��ٸ�Ԫ�ؼ������������������𽥼���
    */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];//��ȡ����ǰԪ�ص�ֵ����������ʱ����
        //��ʼ����
        //k = i*2+1 k��i�ڵ�����ӽڵ�
        //k = i*2+2 k��i�ڵ�����ӽڵ�
        //(i-1)/2   ����i�ڵ�ĸ��ڵ�
        for (int k = i*2+1; k < length; k = k*2+1) {
            if (k+1 < length && arr[k] < arr[k+1]){//˵�����ӽڵ��ֵС�����ӽڵ��ֵ
                k++;//kָ����ָ��
            }
            if (arr[k] > temp) {//����ӽڵ㣬���ڸ��ڵ�
                arr[i] = arr[k];//�ѽϴ��ֵ������ǰ�ڵ�
                i = k;//!!!iָ��k������ѭ���Ƚ�
            } else {
                break;
            }
        }
        //��ѭ���������Ѿ�����iΪ���ڵ�������ֵ��������ˣ��ֲ���
        arr[i] = temp;//��tempֵ�ŵ��������λ��
    }
}
