package cn.learn.Data.Basic.Tree;
/*
    平衡二叉树AVLTree：
        1、平衡二叉树也叫平衡二叉搜索树，又被称为AVL树，可以保证查询效率高
        2、具有一下特点：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
                        并且左右两个子树都是一棵平衡二叉树，平衡二叉树的常用实现方法有红黑树、AVL、替罪羊树、
                        Treap、伸展树等；

    右高左旋，左高右旋：
        当插入的数是一个较大的值，可能使得数不再是平衡二叉树，则需进行左旋转（降低右子树的高度）：
            1、创建一个新的结点，newNode，创建一个新的节点，值等于当前根节点的值
            //把新节点的左子树设置了当前节点的左子树
            2、newNode.left = left;
            //把新节点的右子树设置为当前节点的右子树的左子树
            3、newNode.right = right.left;
            //把当前节点的值换为右子节点的值
            4、value = right.value;
            //把当前节点的右子树设置为右子树的右子树
            5、right = right.right;
            //把当前节点的左子树设置为新节点
            6、left = newLeft;
        当插入的数是一个较小的值，可能使得数不再是平衡二叉树，则需要进行右旋转（降低左子树的高度）：
            1、创建一个新的节点，newNode，创建一个新的节点，值等于当前节点的值
            //把新节点的右子树设置了当前节点的右子树
            2、newNode right = right;
            //把新节点的左子树设置为当前节点的左子树的右子树
            3、newNode left = left.right;
            //把当前节点的值换为左子节点的值
            4、value = left.value;
            //把当前节点的左子树设置为左子树的左子树
            5、left = left.left;
            //把当前节点的右子树设置为新节点
            6、right = newLeft;
        {10, 11, 7, 6, 8, 9}该数组仅用左旋转或者右旋转，不能将树转为AVL树
      双旋转：


*/

public class SelfBalanceBinaryTree {
    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8};
//        int[] arr = {10, 12, 8, 9, 7, 6};

        int[] arr = {10, 11, 7, 6, 8, 9};
        //创建一个AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加节点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLNode(arr[i]));
        }

        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();
        System.out.println("在没有平衡处理");
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("左子树的高度：" + avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度：" + avlTree.getRoot().rightHeight());
        System.out.println("当前树根为：" + avlTree.getRoot());

    }
}

//创建AVLTree
class AVLTree {
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    //查找要删除的结点
    public AVLNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public AVLNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1、需要先去找到删除的结点，targetNode
            AVLNode targetNode = search(value);
            //如果没有找到要删除的结点
            if (targetNode == null) {
                return;
            }
            //若当前二叉排序树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //查找target的父节点
            AVLNode parentNode = searchParent(value);

            //如果删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode是父节点的左子结点还是右子结点
                if (parentNode.left != null && parentNode.left == targetNode) {
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right == targetNode) {
                    parentNode.right = null;
                }

            } else if (targetNode.left != null && targetNode.right != null) { //如果删除的结点是有两棵子树的结点

                //找到要删除结点的右子树里面的最小值
                AVLNode tempTarget = targetNode.right;
                boolean flag = false;
                while (tempTarget.left != null) {//一直查找左结点就会一直循环
                    flag = true;
                    tempTarget = tempTarget.left;
                }
                AVLNode tempParent = searchParent(tempTarget.value);
                if (flag) {
                    tempParent.left = null;
                } else {
                    tempParent.right = null;
                }
                targetNode.value = tempTarget.value;

            } else {//如果删除的结点只有一棵子树
                if (parentNode == null) {
                    if (targetNode.left != null) {
                        root = targetNode.left;
                    } else {
                        root = targetNode.right;
                    }
                    return;
                }
                if (targetNode.left != null) {//如果删除的结点只有左子结点

                    if (parentNode.left == targetNode) {
                        parentNode.left = targetNode.left;
                    } else {
                        parentNode.right = targetNode.left;
                    }

                } else {

                    if (parentNode.left == targetNode) {
                        parentNode.left = targetNode.right;
                    } else {
                        parentNode.right = targetNode.right;
                    }
                }
            }
        }
    }

    public void add(AVLNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历的方法
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("数组为空，无法遍历");
        }
    }
}

class AVLNode {
    int value;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AVLNode{" + "value=" + value + '}';
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回当前节点的高度，以该节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    private void rightRotate() {
        //创建新的节点，以当前根节点的值
        AVLNode newNode = new AVLNode(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = left.value;
        this.left = this.left.left;
        this.right = newNode;
    }

    private void leftRotate() {
        //创建新的节点，以当前根节点的值
        AVLNode newNode = new AVLNode(this.value);
        //把新的节点左子树设置为当前节点的左子树
        newNode.left = this.left;
        //把新的节点的右子树设置为当前节点的右子树的左子树
        newNode.right = this.right.left;
        //把当前节点的值替换为右子节点的值
        this.value = this.right.value;
        //把当前节点的右子树设置为右子树的右子树
        this.right = this.right.right;
        //把当前节点的左子节点设置为新的节点
        this.left = newNode;

    }

    //查找要删除的结点
    public AVLNode search(int value) {
        if (value == this.value) {
            return this;
        } else if (this.value > value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除结点的父节点
    public AVLNode searchParent(int value) {
        //如果当前结点是要删除结点的父节点，就返回
        if ((this.left != null && this.left.value == value)
                || (this.right != null && this.right.value == value)) {
            return this;
        } else {

            //如果要找的值小于当前值，并且当前结点的左子结点不为空，则向左递归
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);

                //如果要找的值比当前值大，且当前结点的右子结点不为空，则向右递归
            } else if (this.value <= value && this.right != null) {
                return this.right.searchParent(value);

                //否则就找不到
            } else {
                return null;
            }
        }
    }

    //添加结点的方法
    //递归的形式添加结点，注意需要满足二叉排序树的要求
    public void add(AVLNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            //如果当前左子结点为空
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        //当添加完节点后，如果右子树的高度比左子树的高度差值大于1，左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果右子树的左子树高度大于右子树的右子树的高度，先进行右旋转再进行左旋转
            if (right != null && right.rightHeight() < right.leftHeight()) {
                //先对右子树进行旋转
                right.rightRotate();
                leftRotate();//左旋转
            } else {
                leftRotate();//左旋转
            }
            return;

        } else if (leftHeight() - rightHeight() > 1) {//如果左子树的高度比右子树的高度差值大于1，右旋转
            //如果它的左子树的右子树高度大于它的左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对当前节点的左节点（左子树） -> 左旋转
                left.leftRotate();
                //再对当前节点进行右旋转
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
