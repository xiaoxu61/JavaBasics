package cn.learn.Data.Basic.CommonAlgorithm;
/*
    ���ֲ����㷨���ǵݹ飩
        1��ǰ�����ǽ������ֲ����㷨��ʹ�õ��ǵݹ�ķ�ʽ���������ǽ�����ֲ��ҵķǵݹ鷽ʽ
        2�����ֲ��ҷ���ֻ�����ڴ�����������в��ң��������ֺ���ĸ�ȣ�������������ٽ��в���
        3�����ֲ��ҷ�������ʱ��Ϊ����ʱ�� ŵ���n �������ҵ���Ҫ��Ŀ��λ�����ֻ��Ҫ������ӡ�0��99��
    �Ķ���100�������ҵ�Ŀ����30���������Ҫ����7��
*/

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,11,67,100};
        int index = binarySearch(arr,-1);
        System.out.println(index);
    }

    //���ֲ��ҵķǵݹ�ʵ��
    /**
     *
     * @param arr �����ҵ����飬arr����������
     * @param target  ��Ҫ���ҵ���
     * @return ���ض�Ӧ�±꣬-1��ʾû���ҵ�
    */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid - 1;//��Ҫ����߲���
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
