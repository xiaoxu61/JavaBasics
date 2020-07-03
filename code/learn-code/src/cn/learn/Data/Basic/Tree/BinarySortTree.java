package cn.learn.Data.Basic.Tree;
/*
二叉排序树
    对于二叉排序树的任何一个非叶子结点，要求左子节点的值比当前结点的值小，右子结点的值比当前结点的值大
*/


public class BinarySortTree {

    public static void main(String[] args) {
//        int[] arr = {7,3,10,12,5,1,9,2};
        int[] arr = {7, 3, 0, 1, 2};
        BinarySortT binarySort = new BinarySortT();
        for (int i = 0; i < arr.length; i++) {
            binarySort.add(new BinaryNode(arr[i]));
        }

        binarySort.infixOrder();
        binarySort.delNode(0);
        //binarySort.delNode(5);
        //binarySort.delNode(9);
        System.out.println("删除结点后");
        binarySort.infixOrder();
    }
}

//创建二叉排序树
class BinarySortT {
    private BinaryNode root;

    //查找要删除的结点
    public BinaryNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public BinaryNode searchParent(int value) {
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
            BinaryNode targetNode = search(value);
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
            BinaryNode parentNode = searchParent(value);

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
                BinaryNode tempTarget = targetNode.right;
                boolean flag = false;
                while (tempTarget.left != null) {//一直查找左结点就会一直循环
                    flag = true;
                    tempTarget = tempTarget.left;
                }
                BinaryNode tempParent = searchParent(tempTarget.value);
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

    public void add(BinaryNode node) {
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

class BinaryNode {
    int value;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinaryNode{" + "value=" + value + '}';
    }

    //查找要删除的结点
    public BinaryNode search(int value) {
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
    public BinaryNode searchParent(int value) {
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
    public void add(BinaryNode node) {
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
