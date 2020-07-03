package cn.learn.Data.Basic;
/*
    线索化二叉树
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

        //测试中序遍历线索化
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);
        //binaryTree.threadedNodes();
        //binaryTree.threadedPreNode();
        binaryTree.threadedPostNode();

        //测试
        HeroNodeTree leftNode = node3.getLeft();
        System.out.println(leftNode);

        HeroNodeTree right = node3.getRight();
        System.out.println(right);

        //binaryTree.threadedList();
        //binaryTree.threadedPreList();
        binaryTree.threadedPostList();

    }
}


//创建树ThreadedBinaryTree 实现了线索化功能的二叉树
class BinaryTree{
    private HeroNodeTree root;

    //为实现线索化，需要创建要给指向当前节点的前驱节点的指针
    //在递归线索化是，pre总是保留前驱节点
    private HeroNodeTree pre = null;

    public void setRoot(HeroNodeTree root) {
        this.root = root;
    }

    //实现后续遍历的方法
    public void threadedPostList() {
        HeroNodeTree node = root;

        //先找到最左端
        while (node.getLeftType() == 0) {
            node = node.getLeft();
        }

        HeroNodeTree preNode = null;
        while(node != null) {
            //右节点是线索
            if (node.getRightType() == 1) {
                System.out.println(node);
                preNode = node;
                node = node.getRight();

            } else {
                //如果上个处理的节点是当前节点的右节点
                if (node.getRight() == preNode) {
                    System.out.println(node);
                    if (node == root) {
                        return;
                    }

                    preNode = node;
                    node = node.getParent();

                } else {    //如果从左节点的进入则找到有子树的最左节点
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

    //实现后续线索化
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

    //遍历前序线索化的方法
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

    //实现前序遍历线索化；
    public void threadedPreNode(HeroNodeTree node) {
        if (node == null) {
            return;
        }
        //先处理当前节点
        if (node.getLeft() == null) {
            node.setLeft(pre);

            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);

            pre.setRightType(1);
        }
        pre = node;
        //线索化左子树
        if (node.getLeftType() == 0) {
            threadedPreNode(node.getLeft());
        }

        //线索化右子树
        if (node.getRightType() == 0) {
            threadedPreNode(node.getRight());
        }
    }

    //遍历中序线索化二叉树的方法
    public void threadedList() {
        HeroNodeTree node = root;
        while (node != null) {
            //循环的找到leftType == 1的结点，第一个找到就是8结点
            //后面随着遍历而变化，因为当leftType==1时，说明该节点是按照线索化
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                //获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }

            //替换这个遍历的节点
            node = node.getRight();

        }
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //编写对二叉树进行中序线索化的方法
    //node 就是当前需要线索化的节点
    public void threadedNodes(HeroNodeTree node) {
        if (node == null) {
            return;
        }

        //(1)先线索化左子树
        threadedNodes(node.getLeft());
        //(2)线索化当前节点

        //先处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //让当前节点的左子针指向前驱节点
            node.setLeft(pre);

            node.setLeftType(1);
        }

        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }

        pre = node;//每处理一个节点后，当前节点是下一个节点

        //(3)线索化右子树
        threadedNodes(node.getRight());
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法前序遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法进行中序遍历");
        }
    }

    //后续遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法进行后序遍历");
        }
    }

    //前序查找
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
            System.out.println("空树不能删除");
        }
    }
}

//创建节点
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

    //说明
    //1、如果leftType = 0, 表示指向的是左子树，如果1则表示指向前驱节点
    //2、如果rightType = 0, 表示指向的是右子树，如果1则表示指向前驱节点
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

    //编写前序遍历的方法
    public void preOrder() {
        System.out.println(this);//先输出父节点

        //递归左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    //编写中序遍历的方法
    public void infixOrder() {
        //递归左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父
        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }
    //编写后续遍历的方法
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNodeTree preOrderSearch(int no) {
        System.out.println("前序遍历");
        //先比较当前节点的no
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

    //中序遍历查找
    public HeroNodeTree infixOrderSearch(int no) {
        //向左查找
        HeroNodeTree resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("中序遍历查找");
        //返回当前值
        if (this.no == no) {
            return this;
        }

        //向右查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后续查找
    public HeroNodeTree postOrderSearch(int no) {
        HeroNodeTree resNode = null;
        //向左递归
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //向右递归
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("后序遍历查找");
        //若左右子树都没有找到，则比较当前节点
        if (this.no == no) {
            return this;
        }
        return null;
    }

    //删除节点
    //如果删除的是叶子节点，则删除该节点
    //如果删除的不是叶子节点，则删除该子树
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
