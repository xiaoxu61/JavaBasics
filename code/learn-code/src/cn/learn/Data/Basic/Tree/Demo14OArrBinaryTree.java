package cn.learn.Data.Basic.Tree;
/*
    顺序存储二叉树的概念
        从数据存储来看，数组存储方式和树的存储方式可以相互转换，即数组可以转换成数，树也可以换成数组
     要求：
        右图的二叉树的结点，要求以数组的方式来存放arr[1,2,3,4,5,6,6]
        要求在遍历数组arr时，仍然可以以前序遍历，中序遍历和后序遍历的方式完成节点的遍历
    顺序存储二叉树的特点：
        1、顺序二叉树通常只考虑完全二叉树
        2、第n个元素的左子节点为 2*n+1
        3、第n个元素的右子节点为 2*n+2
        4、第n个元素的父节点为 (n-1)/2
        5、n表示二叉树中的第几个元素(从0开始编号，如图所示)
        数组  arr[1,2,3,4,5,6,6]
        对应的树为：
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
        System.out.println("前序遍历");
        arrBinaryTree.preOrder(0);
        System.out.println();
        System.out.println("中序遍历");
        arrBinaryTree.infixOrder(0);
        System.out.println();
        System.out.println("后续遍历");//不对
        arrBinaryTree.postOrder(0);
    }
}

//编写一个ArrBinaryTree  实现顺序二叉树
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
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        //输出当前这个元素
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
            System.out.println("数组为空，不能按照二叉树的前序遍历");
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
            System.out.println("数组为空，不能按照二叉树的前序遍历");
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
