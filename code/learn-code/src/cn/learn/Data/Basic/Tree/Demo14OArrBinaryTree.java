package cn.learn.Data.Basic.Tree;
/*
    ˳��洢�������ĸ���
        �����ݴ洢����������洢��ʽ�����Ĵ洢��ʽ�����໥ת�������������ת����������Ҳ���Ի�������
     Ҫ��
        ��ͼ�Ķ������Ľ�㣬Ҫ��������ķ�ʽ�����arr[1,2,3,4,5,6,6]
        Ҫ���ڱ�������arrʱ����Ȼ������ǰ���������������ͺ�������ķ�ʽ��ɽڵ�ı���
    ˳��洢���������ص㣺
        1��˳�������ͨ��ֻ������ȫ������
        2����n��Ԫ�ص����ӽڵ�Ϊ 2*n+1
        3����n��Ԫ�ص����ӽڵ�Ϊ 2*n+2
        4����n��Ԫ�صĸ��ڵ�Ϊ (n-1)/2
        5��n��ʾ�������еĵڼ���Ԫ��(��0��ʼ��ţ���ͼ��ʾ)
        ����  arr[1,2,3,4,5,6,6]
        ��Ӧ����Ϊ��
                        1(arr[0])
                      /           \
             2(arr[1])             3(arr[2])
             /       \             /        \
        4(arr[3])  5(arr[4])   6(arr[5])   7(arr[6])
*/

public class Demo14OArrBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("ǰ�����");
        arrBinaryTree.preOrder(0);
        System.out.println();
        System.out.println("�������");
        arrBinaryTree.infixOrder(0);
        System.out.println();
        System.out.println("��������");//����
        arrBinaryTree.postOrder(0);
    }
}

//��дһ��ArrBinaryTree  ʵ��˳�������
class ArrBinaryTree{
    private int[] arr;
    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        preOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
            return;
        }
        //�����ǰ���Ԫ��
        System.out.print(arr[index]);

        if (index * 2 + 1 < arr.length) {
            preOrder(index*2+1);
        }
        if (index * 2 + 2 < arr.length) {
            preOrder(index*2+2);
        }
    }

    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
            return;
        }

        if (index * 2 + 1 < arr.length) {
            infixOrder(index*2+1);
        }

        System.out.print(arr[index]);

        if (index * 2 + 2 < arr.length) {
            infixOrder(index*2+2);
        }

    }

    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
            return;
        }

        if (index * 2 + 1 < arr.length) {
            infixOrder(index * 2 + 1);
        }

        if (index * 2 + 2 < arr.length) {
            infixOrder(index * 2 + 2);
        }

        System.out.print(arr[index]);
    }
}
