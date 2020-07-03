package cn.learn.basic.Demo01;

/*
  ���巽����ʵ���������
  �����У�������[11��33, 565, 66, 78, 89]
  int[] arr = {3,4,45,7}
  ʵ�ֲ���:
     1�����巽��ʵ������ı���
     2���ȴ�ӡ[ ������
     3����������
        ��������Ԫ�غͶ���
        �ж��Ƿ�����������һ��Ԫ�أ���������һ��Ԫ�أ����] ������
 */
public class ArrayMethodTest {
    public static void main(String[] args){
        //��������
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

        //���ô�ӡ����
        printArray(arr2);
        //��������ķ���
        reverse(arr);
        //���ô�ӡ���鷽��
        printArray(arr);
        //����ѡ�����򷽷�
        selectSort(arr);
        printArray(arr);
        //����ð�����򷽷�
        bubbleSort(arr2);
        printArray(arr2);

        int index = binarySearch(arr2,5);
        System.out.println(index);
    }
    /*
       �۰���ң����ַ����۰룩
       ǰ�᣺�����ҵ������е�Ԫ�أ���������
       ����ֵ������
       ���������飬���ҵ�Ԫ��
          1����ҪԤ�ȶ���ı���
             ����������ָ��
          2������ѭ���۰�
             �����۰������  min <= max
          3���ñ���Ԫ�أ����м�����Ԫ�ؽ��бȽ�
             Ԫ�� > �м�����  Сָ�� = �м�+1
             Ԫ�� < �м�����  ��ָ�� = �м�-1
             Ԫ�� == �м����� �ҵ��ˣ������ˣ������м�����
          4��ѭ���������޷��۰�
             Ԫ��û���ҵ�������-1

     */
    public static int binarySearch(int[] arr,int key){
        //��������ָ�����
        int min = 0;
        int max = arr.length ;
        int mid = 0;
        //ѭ���۰룬����min <= max
        while (min <= max){
            //��ʽ���м���������
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
       �����ð������
         ���������Ԫ�ػ�λ��
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
        ���������һ�㶼���������У�Ԫ�أ�С���������

        ��������ʽ
          ѡ�����������ÿ��Ԫ�ض����бȽ�
          ð�����������е�����Ԫ�صıȽ�
          ���򣺱Ƚϴ�С������λ��
        ʵ�ֲ��裺
           Ƕ��ѭ��
     */
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            //��ѭ��ÿ�ζ��ڼ���
            for(int j = i+1; j < arr.length; j++){
                //����Ԫ�ؽ����ж�
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    /*
       ���巽�� ʵ�ֹ���
       ����ֵ void
       ��������������
     */
    //���һ��������
    public static void printArray(int[] arr) {
        System.out.print("[");
        //�������
        for(int i = 0; i < arr.length; i++){
            //�жϱ�������Ԫ�أ��ǲ����������һ��Ԫ��
            //����ж� ѭ������ ���� length - 1
            if(i == arr.length - 1) {
                //��������Ԫ�غ�
                System.out.println(arr[i]+"]");
            }else {
                //������������һ��Ԫ�أ��������Ԫ�غͶ���
                System.out.print(arr[i] + ",");
            }
        }
    }

    /*
       ʵ�����������
          �����е�Ԫ�أ�����λ���ϵĽ���
          ���� ������  �������
          ������������Զ��������������λ�ý�����ʵ�����������
          ʹ�õ��������ָ��˼�룬���Ǳ�����˼�룬������ʱ�任����
          ��תreverse
          ʵ�ֲ��裺
            1�����巽����ʵ�����������
            2���������飬ʵ���������Զ������λ��
              ʹ����ʱ�ĵ���������
     */
    public static void reverse(int[] arr){
        //����ѭ����ʵ������ı�����������������Զ�˻�λ
        for(int start = 0, end = arr.length - 1; start < end; start++, end--){
            //�����е�Ԫ�ؽ���λ���ϵĽ���
            //star������end������Ԫ�ؽ���
            //������ʱ��������start����
            int temp = arr[start];
            //��������ϵ�Ԫ�ظ�ֵ����С����
            arr[start] = arr[end];
            //��ʱ�ı�������С��������������ݣ���ֵ�����������
            arr[end] = temp;
        }
    }

}
