package cn.learn.Data.Basic;
/*
    �շ�����
        1������n��Ȩֵ��Ϊn����Ҷ�ӽڵ㡿������һ�ö��������������ġ���Ȩ·�����ȣ�wpl�����ﵽ��С
            �������Ķ�����Ϊ���Ŷ�������Ҳ��Ϊ��������
        2���շ������Ǵ�Ȩ·��������̵�����Ȩֵ�ϴ�Ľڵ�����Ͻ�
        *·����·�����ȣ���һ�����У���һ���ڵ����¿��Ե���ĺ��ӻ������ӽڵ�֮���ͨ·����Ϊ·����
        *ͨ·�з�֧����Ŀ��Ϊ·���ĳ��ȡ����涨���ڵ�Ĳ���Ϊ1����Ӹ��ڵ㵽��L��ڵ��·������ΪL-1
        *�ڵ��Ȩ����Ȩ·�����ȣ��������нڵ㸳��һ��ĳ�ֺ������ֵ���������ֵ��Ϊ�ýڵ��Ȩ���ڵ��
            ��Ȩ·������Ϊ���Ӹ��ڵ㵽�ýڵ�֮���·��������ýڵ��Ȩ�ĳ˻���
        *���Ĵ�Ȩ·�����ȣ����Ĵ�Ȩ·�����ȹ涨Ϊ���С�Ҷ�ӽ�㡿�Ĵ�Ȩ·������֮�ͣ���ΪWPL��
            ȨֵԽ��Ľ��������Խ���Ķ������������Ŷ�����
        *WPL��С�ľ��Ǻշ�����

        ���ɺշ������Ĳ��裺
            1����С����������򣬽�ÿһ�����ݣ�ÿ�����ݶ���һ����㣬ÿ�������Կ�����һ����򵥵Ķ�����
            2��ȡ���������С�����Ŷ�����
            3�����һ���µĶ����������µĶ������ĸ��ڵ��Ȩֵ��ǰ�����Ŷ��������ڵ�Ȩֵ�ĺ�
            4���ٽ�����µĶ��������Ը��ڵ��Ȩֵ��С�ٴ����򣬲����ظ�1234���裬ֱ�������У����е����ݶ���
                �����͵õ�һ�úշ�����
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
            System.out.println("���������ܱ���");
        }
    }

    public static Node createHuffmanTree(int[] arr) {
        //Ϊ�˲�������
        //1������arr����
        //2����arr��ÿ��Ԫ�ع���һ��Node
        //3����Node���뵽ArrayList��
        List<Node> nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(new Node(i));
        }
        while (nodes.size() > 1) {
            //���򣬴�С����
            Collections.sort(nodes);

            //����Ĺ�����һֱѭ���ģ�

            System.out.println("nodes = " + nodes);
            //ȡ�����ڵ�Ȩֵ��С�����ö�����
            //1��ȡ��Ȩֵ��С�Ľ�㣨��������
            Node leftNode = nodes.remove(0);
            //2��ȡ��Ȩֵ�ڶ�С�Ľ�㣨��������
            Node rightNode = nodes.remove(0);

            //3������һ���µĶ�����
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //��parent���뵽nodes
            nodes.add(parent);
            System.out.println("�����nodes = " + nodes);
        }

        //���غշ�������root���
        return nodes.get(0);

    }
}


//���������
//Ϊ����Node ����֧��Collections��������
//��Nodeʵ��Comparable�ӿ�
class Node implements Comparable<Node>{
    int value;//���Ȩֵ
    Node left;//ָ�����ӽ��
    Node right;//ָ�����ӽ��

    public Node(int value) {
        this.value = value;
    }

    //дһ��ǰ�����
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
        //��ʾ��С��������
        return this.value - o.value;
    }
}
