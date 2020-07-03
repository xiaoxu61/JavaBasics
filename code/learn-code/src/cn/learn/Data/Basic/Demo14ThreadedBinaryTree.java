package cn.learn.Data.Basic;
/*
    ������������
*/

public class Demo14ThreadedBinaryTree {
    public static void main(String[] args) {
        HeroNodeTree root = new HeroNodeTree(1, "tom1");
        HeroNodeTree node2 = new HeroNodeTree(3, "tom2");
        HeroNodeTree node3 = new HeroNodeTree(6, "tom3");
        HeroNodeTree node4 = new HeroNodeTree(8, "tom4");
        HeroNodeTree node5 = new HeroNodeTree(10, "tom5");
        HeroNodeTree node6 = new HeroNodeTree(14, "tom6");

        root.setLeft(node2);
        root.setRight(node3);

        node2.setParent(root);
        node3.setParent(root);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);

        node4.setParent(node2);
        node5.setParent(node2);
        node6.setParent(node3);

        //�����������������
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);
        //binaryTree.threadedNodes();
        //binaryTree.threadedPreNode();
        binaryTree.threadedPostNode();

        //����
        HeroNodeTree leftNode = node3.getLeft();
        System.out.println(leftNode);

        HeroNodeTree right = node3.getRight();
        System.out.println(right);

        //binaryTree.threadedList();
        //binaryTree.threadedPreList();
        binaryTree.threadedPostList();

    }
}


//������ThreadedBinaryTree ʵ�������������ܵĶ�����
class BinaryTree{
    private HeroNodeTree root;

    //Ϊʵ������������Ҫ����Ҫ��ָ��ǰ�ڵ��ǰ���ڵ��ָ��
    //�ڵݹ��������ǣ�pre���Ǳ���ǰ���ڵ�
    private HeroNodeTree pre = null;

    public void setRoot(HeroNodeTree root) {
        this.root = root;
    }

    //ʵ�ֺ��������ķ���
    public void threadedPostList() {
        HeroNodeTree node = root;

        //���ҵ������
        while (node.getLeftType() == 0) {
            node = node.getLeft();
        }

        HeroNodeTree preNode = null;
        while(node != null) {
            //�ҽڵ�������
            if (node.getRightType() == 1) {
                System.out.println(node);
                preNode = node;
                node = node.getRight();

            } else {
                //����ϸ�����Ľڵ��ǵ�ǰ�ڵ���ҽڵ�
                if (node.getRight() == preNode) {
                    System.out.println(node);
                    if (node == root) {
                        return;
                    }

                    preNode = node;
                    node = node.getParent();

                } else {    //�������ڵ�Ľ������ҵ�������������ڵ�
                    node = node.getRight();
                    while (node != null && node.getLeftType() == 0) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }

    public void threadedPostNode() {
        threadedPostNode(root);
    }

    //ʵ�ֺ���������
    public void threadedPostNode(HeroNodeTree node) {
        if (node == null) {
            return;
        }


        threadedPostNode(node.getLeft());
        threadedPostNode(node.getRight());

        if (node.getLeft() == null) {
            node.setLeft(pre);

            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);

            pre.setRightType(1);
        }

        pre = node;
    }

    //����ǰ���������ķ���
    public void threadedPreList() {
        HeroNodeTree node = root;
        while (node != null) {
            //System.out.println(node);
            while (node.getLeftType() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }

            while (node.getRightType() == 1) {
                System.out.println(node);
                node = node.getRight();
            }

            node = node.getRight();
        }
    }

    public void threadedPreNode() {
        threadedPreNode(root);
    }

    //ʵ��ǰ�������������
    public void threadedPreNode(HeroNodeTree node) {
        if (node == null) {
            return;
        }
        //�ȴ���ǰ�ڵ�
        if (node.getLeft() == null) {
            node.setLeft(pre);

            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);

            pre.setRightType(1);
        }
        pre = node;
        //������������
        if (node.getLeftType() == 0) {
            threadedPreNode(node.getLeft());
        }

        //������������
        if (node.getRightType() == 0) {
            threadedPreNode(node.getRight());
        }
    }

    //���������������������ķ���
    public void threadedList() {
        HeroNodeTree node = root;
        while (node != null) {
            //ѭ�����ҵ�leftType == 1�Ľ�㣬��һ���ҵ�����8���
            //�������ű������仯����Ϊ��leftType==1ʱ��˵���ýڵ��ǰ���������
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //��ӡ��ǰ�ڵ�
            System.out.println(node);
            //�����ǰ�ڵ����ָ��ָ����Ǻ�̽ڵ㣬��һֱ���
            while (node.getRightType() == 1) {
                //��ȡ����ǰ�ڵ�ĺ�̽ڵ�
                node = node.getRight();
                System.out.println(node);
            }

            //�滻��������Ľڵ�
            node = node.getRight();

        }
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //��д�Զ��������������������ķ���
    //node ���ǵ�ǰ��Ҫ�������Ľڵ�
    public void threadedNodes(HeroNodeTree node) {
        if (node == null) {
            return;
        }

        //(1)��������������
        threadedNodes(node.getLeft());
        //(2)��������ǰ�ڵ�

        //�ȴ���ǰ�ڵ��ǰ���ڵ�
        if (node.getLeft() == null) {
            //�õ�ǰ�ڵ��������ָ��ǰ���ڵ�
            node.setLeft(pre);

            node.setLeftType(1);
        }

        //�����̽ڵ�
        if (pre != null && pre.getRight() == null) {
            //��ǰ���ڵ����ָ��ָ��ǰ�ڵ�
            pre.setRight(node);
            //�޸�ǰ���ڵ����ָ������
            pre.setRightType(1);
        }

        pre = node;//ÿ����һ���ڵ�󣬵�ǰ�ڵ�����һ���ڵ�

        //(3)������������
        threadedNodes(node.getRight());
    }

    //ǰ�����
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("������Ϊ�գ��޷�ǰ�����");
        }
    }

    //�������
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("������Ϊ�գ��޷������������");
        }
    }

    //��������
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("������Ϊ�գ��޷����к������");
        }
    }

    //ǰ�����
    public HeroNodeTree preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNodeTree infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNodeTree postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    public void deleteNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            }else {
                root.deleteNode(no);
            }
        }else {
            System.out.println("��������ɾ��");
        }
    }
}

//�����ڵ�
class HeroNodeTree{
    private int no;
    private String name;
    private HeroNodeTree left;
    private HeroNodeTree right;

    private HeroNodeTree parent;

    public HeroNodeTree getParent() {
        return parent;
    }

    public void setParent(HeroNodeTree parent) {
        this.parent = parent;
    }

    //˵��
    //1�����leftType = 0, ��ʾָ����������������1���ʾָ��ǰ���ڵ�
    //2�����rightType = 0, ��ʾָ����������������1���ʾָ��ǰ���ڵ�
    private int leftType;
    private int rightType;


    @Override
    public String toString() {
        return "HeroNodeTree{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNodeTree getLeft() {
        return left;
    }

    public void setLeft(HeroNodeTree left) {
        this.left = left;
    }

    public HeroNodeTree getRight() {
        return right;
    }

    public void setRight(HeroNodeTree right) {
        this.right = right;
    }

    public HeroNodeTree(int no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    //��дǰ������ķ���
    public void preOrder() {
        System.out.println(this);//��������ڵ�

        //�ݹ�������
        if (this.left != null) {
            this.left.preOrder();
        }
        //�ݹ�������
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    //��д��������ķ���
    public void infixOrder() {
        //�ݹ�������
        if (this.left != null) {
            this.left.infixOrder();
        }
        //�����
        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }
    //��д���������ķ���
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //ǰ���������
    public HeroNodeTree preOrderSearch(int no) {
        System.out.println("ǰ�����");
        //�ȱȽϵ�ǰ�ڵ��no
        if (this.no == no) {
            return this;
        }
        HeroNodeTree resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //�����������
    public HeroNodeTree infixOrderSearch(int no) {
        //�������
        HeroNodeTree resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("�����������");
        //���ص�ǰֵ
        if (this.no == no) {
            return this;
        }

        //���Ҳ���
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //��������
    public HeroNodeTree postOrderSearch(int no) {
        HeroNodeTree resNode = null;
        //����ݹ�
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //���ҵݹ�
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("�����������");
        //������������û���ҵ�����Ƚϵ�ǰ�ڵ�
        if (this.no == no) {
            return this;
        }
        return null;
    }

    //ɾ���ڵ�
    //���ɾ������Ҷ�ӽڵ㣬��ɾ���ýڵ�
    //���ɾ���Ĳ���Ҷ�ӽڵ㣬��ɾ��������
    public void deleteNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.deleteNode(no);
        }
        if (this.right != null) {
            this.right.deleteNode(no);
        }
    }
}
