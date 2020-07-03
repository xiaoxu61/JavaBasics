package cn.learn.Data.Basic.Tree;
/*
    二叉树
        分析二叉树的前序、中序、后序遍历的步骤
        1、创建一棵二叉树
        2、前序遍历
            2.1先输出当前节点(初始的时候是root节点)
            2.2如果左子节点不为空，则递归继续前序遍历
            2.2如果右子节点不为空，则递归继续前序遍历
        3、中序遍历
            3.1如果当前节点的左子节点不为空，则递归中序遍历
            3.2输出当前节点
            3.2如果当前节点的右子节点不为空，则递归中序遍历
        4、后续遍历
            4.1如果当前节点的左子节点不为空，则递归后序遍历
            4.2如果当前节点的右子节点不为空，则递归后序遍历
            4.3输出当前节点

       分析二叉树查找的思路：
       前序查找：
       1、先判断当前节点的no是否等于要查找的
       2、如果相等，则返回当前节点
       3、如果不等，则判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
       4、如果左递归前序查找，找到节点，则返回，否则持续判断当前节点的右子节点是否为空，如果不空，则继续向右递归前序查找
       中序查找：
       1、判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
       2、如果找到，则返回，如果没有找到，就和当前节点比较，如果是则返回当前节点，否则继续进行右递归的中序查找
       3、如果左递归中序查找，找到就返回，否则返回null
       后续查找
       1、判断当前节点的左子节点是否为空，如果不为空，则递归后序查找
       2、如果找到，就返回，如果没有找到，就判断当前节点的右子节点是否为空，如果不为空，则右递归进行后序查找，
       3、如果找到，就返回，如果不是就和当前节点进行比较，如果是则返回，否则返回null

       删除节点的思路分析
       规定：
        1、如果删除的节点是叶子节点，则删除该节点
        2、如果删除的是非叶子节点，则删除该子树
       思路：
        1、因为我们的二叉树是单向的，所有我们是判断当前节点的子节点是否需要删除节点，
           而不能去判断当前这个节点是不是需要删除节点
        2、如果当前节点的左子树不为空，并且左子节点就是要删除的节点，就将this.left = null
        3、如果当前节点的右子节点不为空，并且右子节点就是要删除的节点，就将this.right = null
        4、如果第2、3步没有删除节点，那么我们就需要向左子树进行递归删除
        5、如果第四步也没有删除节点，则应向右子树进行递归删除
        5、如果数是空树，如果只有root一个节点，则等价二叉数置空

*/

public class Demo14Tree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNodeTree root = new HeroNodeTree(1, "宋江");
        HeroNodeTree hero2 = new HeroNodeTree(2, "吴用");
        HeroNodeTree hero3 = new HeroNodeTree(3, "卢俊义");
        HeroNodeTree hero4 = new HeroNodeTree(4, "林冲");
        HeroNodeTree hero5 = new HeroNodeTree(5, "关胜");

        //先手动创建二叉树
        root.setLeft(hero2);
        root.setRight(hero3);
        hero3.setRight(hero4);
        hero3.setLeft(hero5);
        binaryTree.setRoot(root);

        //测试
        System.out.println("前序遍历");//12354
        binaryTree.preOrder();

        System.out.println("中序遍历");//21534
        binaryTree.infixOrder();

        System.out.println("后序遍历");//25431
        binaryTree.postOrder();

        System.out.println("前序查找");
        HeroNodeTree resNode = binaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到了，信息为id = %d，name = %s\n",resNode.getNo(),resNode.getName());
        }
        System.out.println("中序查找");
        resNode = binaryTree.infixOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到了，信息为id = %d，name = %s\n",resNode.getNo(),resNode.getName());
        }
        System.out.println("后序查找");
        resNode = binaryTree.postOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到了，信息为id = %d，name = %s\n",resNode.getNo(),resNode.getName());
        }

        System.out.println("删除节点");
        binaryTree.deleteNode(1);

        binaryTree.preOrder();
    }
}

//创建树
class BinaryTree{
    private HeroNodeTree root;

    public void setRoot(HeroNodeTree root) {
        this.root = root;
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

    @Override
    public String toString() {
        return "HeroNodeTree{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
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
