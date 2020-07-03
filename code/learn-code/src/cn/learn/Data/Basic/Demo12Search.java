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
            System.out.println("δ�ҵ����ҵ�ֵ");
        }else {
            System.out.println("�ҵ���ֵ,�±�Ϊ��" + list);
        }
    }

    /*
    쳲����������㷨
        ��֮ǰ�㷨ԭ�����ƣ������ı���mid ��λ�ã�mid = left + F(k-1) -1
        F(k-1):F����쳲���������
    */
    //�ǵݹ鷽ʽ��д�㷨
    public static int fibonacciSearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        int k = 0; //��ʾ쳲������ָ���ֵ���±�
        int mid = 0; //���midֵ
        int f[] = fib();//��ȡ쳲���������
        //��ȡ��쳲������ָ���ֵ���±�
        while (high > f[k]-1) {
            k++;
        }
        //��Ϊf[k] ֵ ���ܴ���arr�ĳ��ȣ������Ҫʹ��Arrays�࣬����һ���µ����飬��ָ��a[]
        int[] temp = Arrays.copyOf(arr, f[k]-1);
        //��arr����������Ĳ��֣�ʹ��arr���������
        for(int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //ʹ��whileѭ�����ҵ�key
        while (low <= high) {
            mid = low + f[k - 1] -1;
            if (key < temp[mid]) {//������������߲���
                high = mid - 1;
                //�����ҵ�ȫ��Ԫ�� = midǰ���Ԫ�� + mid�����Ԫ��
                //f[k]            =   f[k-1]     +   f[k-2]
                //��Ϊǰ����f[k-1]��Ԫ�أ����Կ��Լ������f[k-1] = f[k-2]+f[k-3]
                k--;
            }else if (key > temp[mid]) {//�����������ұ߲���
                low = mid + 1;
                //ȫ��Ԫ�� = ǰ���Ԫ�� + �����Ԫ��
                //  f[k]   =   f[k-1]  +   f[k-2],  ������f[k - 2] ��Ԫ��
                //���Լ������f[k-1 - 2] = f[k -3] + f[k - 4]
                //�´�ѭ�� mid = f[k - 1 - 2]
                k -= 2;
            }else {//�ҵ�
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
    //��Ϊ������Ҫmid = left + F(k-1) -1,��Ҫʹ��쳲��������У��ȶ���һ��쳲���������
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
    ��ֵ���ң�
        ԭ���ֲ��ҹ�ʽ mid = (left + right) / 2 = left + (right - left)/2
        ��ֵ���ҹ�ʽ���Ż�Ϊ mid = left + (right - left)* (findValue - arr[left])/(arr[right] - arr[left])

        �����������Ƚϴ󣬹ؼ��ֲַ��ȽϾ��ȵĲ��ұ���˵�����ò�ֵ�����ٶȽϿ�
        �ؼ��ֲַ������ȵ�����£��÷�����һ�����۰���Һ�
    */
    public static ArrayList<Integer> insertSearch(int[] arr, int left, int right, int findValue) {
        System.out.println("��ֵ����");
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
    ���ֲ��ң�
        ���һ�����������顿���ж��ֲ��ң�{1,810,89,1000,1234}
        ˼·��
            1������ȷ����������м��±� mid = (left + right)/2
            2��Ȼ������Ҫ�鵽����findValue��arr[mid]�Ƚ�
                ����findValue > arr[mid] ˵����Ҫ���ҵ�����mid�ұߣ�������ҵݹ����
                ����findValue < arr[mid] ˵����Ҫ���ҵ�����min��ߣ��������ݹ����
                ����findValue = arr[mid] ˵���ҵ�������
            //ʲôʱ����Ҫ�ݹ����
                1���ҵ��ͽ���
                2��δ�ҵ�����left > right ��Ҫ�˳�
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
    //�������������е�Ŀ��ֵ����
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
            //��mid����ֵ�����ұ�ɨ�裬����������Ŀ��Ԫ�ص��±꣬���뵽ArrayList����
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findValue) {
                    break;
                }
                //���� ��temp���뵽������
                resIndexlist.add(temp);
                temp -= 1;
            }
            resIndexlist.add(mid);
            //��mid����ֵ���ұ�ɨ�裬����������Ŀ��Ԫ�ص��±� ���뵽����
            temp = mid + 1;
            while (true) {
                if (temp > arr.length -1 || arr[temp] != findValue) {
                    break;
                }
                //���� ��temp���뵽������
                resIndexlist.add(temp);
                temp += 1;
            }
            return resIndexlist;
        }
    }

    /*
    ���Բ����㷨
     Ҫ����һ������{1,8,10,89,1000,1234}���ж��������Ƿ���������ƣ�����ҵ�������ʾ�ҵ��������±�ֵ
        ˼·��������ҵ�ȫ������������ֵ
    */
    public static int SeqSearch(int[] arr, int value) {
        //���Բ�������һ�ȶ�
        for (int i= 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
