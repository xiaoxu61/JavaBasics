package cn.learn.Data.Basic;
/*
    赫夫曼树
        1、给定n个权值作为n个【叶子节点】，构造一棵二叉树，若该树的【带权路径长度（wpl）】达到最小
            称这样的二叉树为最优二叉树，也称为哈夫曼树
        2、赫夫曼树是带权路径长度最短的树，权值较大的节点离根较近
        *路径和路径长度：在一棵树中，从一个节点往下可以到达的孩子或者孙子节点之间的通路，称为路径。
        *通路中分支的数目称为路径的长度。若规定根节点的层数为1，则从根节点到第L层节点的路径长度为L-1
        *节点的权及带权路径长度：若将树中节点赋予一个某种含义的数值，则这个数值称为该节点的权。节点的
            带权路径长度为：从根节点到该节点之间的路径长度与该节点的权的乘积。
        *树的带权路径长度：树的带权路径长度规定为所有【叶子结点】的带权路径长度之和，记为WPL，
            权值越大的结点离根结点越近的二叉树才是最优二叉树
        *WPL最小的就是赫夫曼树

        构成赫夫曼树的步骤：
            1、从小到大进行排序，将每一个数据，每个数据都是一个结点，每个结点可以看成是一棵最简单的二叉树
            2、取出根结点最小的两颗二叉树
            3、组成一棵新的二叉树，该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
            4、再将这颗新的二叉树，以根节点的权值大小再次排序，不断重复1234步骤，直到数列中，所有的数据都被
                处理，就得到一棵赫夫曼树
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo14HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node treeRoot = createHuffmanTree(arr);
        preOrder(treeRoot);

    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }else {
            System.out.println("空树，不能遍历");
        }
    }

    public static Node createHuffmanTree(int[] arr) {
        //为了操作方便
        //1、遍历arr数组
        //2、将arr的每个元素构成一个Node
        //3、将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(new Node(i));
        }
        while (nodes.size() > 1) {
            //排序，从小到大
            Collections.sort(nodes);

            //处理的过程是一直循环的；

            System.out.println("nodes = " + nodes);
            //取出根节点权值最小的两棵二叉树
            //1、取出权值最小的结点（二叉树）
            Node leftNode = nodes.remove(0);
            //2、取出权值第二小的结点（二叉树）
            Node rightNode = nodes.remove(0);

            //3、构建一棵新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //将parent加入到nodes
            nodes.add(parent);
            System.out.println("处理后nodes = " + nodes);
        }

        //返回赫夫曼树的root结点
        return nodes.get(0);

    }
}


//创建结点类
//为了让Node 对象支持Collections集合排序
//让Node实现Comparable接口
class Node implements Comparable<Node>{
    int value;//结点权值
    Node left;//指向左子结点
    Node right;//指向右子结点

    public Node(int value) {
        this.value = value;
    }

    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        return this.value - o.value;
    }
}
