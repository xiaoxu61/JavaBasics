package cn.learn.Data.Basic.Tree;
/*
    ƽ�������AVLTree��
        1��ƽ�������Ҳ��ƽ��������������ֱ���ΪAVL�������Ա�֤��ѯЧ�ʸ�
        2������һ���ص㣺����һ�ÿ����������������������ĸ߶Ȳ�ľ���ֵ������1��
                        ��������������������һ��ƽ���������ƽ��������ĳ���ʵ�ַ����к������AVL������������
                        Treap����չ���ȣ�

    �Ҹ����������������
        �����������һ���ϴ��ֵ������ʹ����������ƽ��������������������ת�������������ĸ߶ȣ���
            1������һ���µĽ�㣬newNode������һ���µĽڵ㣬ֵ���ڵ�ǰ���ڵ��ֵ
            //���½ڵ�������������˵�ǰ�ڵ��������
            2��newNode.left = left;
            //���½ڵ������������Ϊ��ǰ�ڵ����������������
            3��newNode.right = right.left;
            //�ѵ�ǰ�ڵ��ֵ��Ϊ���ӽڵ��ֵ
            4��value = right.value;
            //�ѵ�ǰ�ڵ������������Ϊ��������������
            5��right = right.right;
            //�ѵ�ǰ�ڵ������������Ϊ�½ڵ�
            6��left = newLeft;
        �����������һ����С��ֵ������ʹ����������ƽ�������������Ҫ��������ת�������������ĸ߶ȣ���
            1������һ���µĽڵ㣬newNode������һ���µĽڵ㣬ֵ���ڵ�ǰ�ڵ��ֵ
            //���½ڵ�������������˵�ǰ�ڵ��������
            2��newNode right = right;
            //���½ڵ������������Ϊ��ǰ�ڵ����������������
            3��newNode left = left.right;
            //�ѵ�ǰ�ڵ��ֵ��Ϊ���ӽڵ��ֵ
            4��value = left.value;
            //�ѵ�ǰ�ڵ������������Ϊ��������������
            5��left = left.left;
            //�ѵ�ǰ�ڵ������������Ϊ�½ڵ�
            6��right = newLeft;
        {10, 11, 7, 6, 8, 9}�������������ת��������ת�����ܽ���תΪAVL��
      ˫��ת��


*/

public class SelfBalanceBinaryTree {
    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8};
//        int[] arr = {10, 12, 8, 9, 7, 6};

        int[] arr = {10, 11, 7, 6, 8, 9};
        //����һ��AVLTree����
        AVLTree avlTree = new AVLTree();
        //��ӽڵ�
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLNode(arr[i]));
        }

        //����
        System.out.println("�������");
        avlTree.infixOrder();
        System.out.println("��û��ƽ�⴦��");
        System.out.println("���ĸ߶ȣ�" + avlTree.getRoot().height());
        System.out.println("�������ĸ߶ȣ�" + avlTree.getRoot().leftHeight());
        System.out.println("�������ĸ߶ȣ�" + avlTree.getRoot().rightHeight());
        System.out.println("��ǰ����Ϊ��" + avlTree.getRoot());

    }
}

//����AVLTree
class AVLTree {
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    //����Ҫɾ���Ľ��
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

    //ɾ�����
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1����Ҫ��ȥ�ҵ�ɾ���Ľ�㣬targetNode
            AVLNode targetNode = search(value);
            //���û���ҵ�Ҫɾ���Ľ��
            if (targetNode == null) {
                return;
            }
            //����ǰ����������ֻ��һ�����
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //����target�ĸ��ڵ�
            AVLNode parentNode = searchParent(value);

            //���ɾ���Ľ����Ҷ�ӽ��
            if (targetNode.left == null && targetNode.right == null) {
                //�ж�targetNode�Ǹ��ڵ�����ӽ�㻹�����ӽ��
                if (parentNode.left != null && parentNode.left == targetNode) {
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right == targetNode) {
                    parentNode.right = null;
                }

            } else if (targetNode.left != null && targetNode.right != null) { //���ɾ���Ľ���������������Ľ��

                //�ҵ�Ҫɾ�������������������Сֵ
                AVLNode tempTarget = targetNode.right;
                boolean flag = false;
                while (tempTarget.left != null) {//һֱ��������ͻ�һֱѭ��
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

            } else {//���ɾ���Ľ��ֻ��һ������
                if (parentNode == null) {
                    if (targetNode.left != null) {
                        root = targetNode.left;
                    } else {
                        root = targetNode.right;
                    }
                    return;
                }
                if (targetNode.left != null) {//���ɾ���Ľ��ֻ�����ӽ��

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

    //��������ķ���
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("����Ϊ�գ��޷�����");
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

    //�����������ĸ߶�
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //�����������ĸ߶�
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //���ص�ǰ�ڵ�ĸ߶ȣ��Ըýڵ�Ϊ���ڵ�����ĸ߶�
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    private void rightRotate() {
        //�����µĽڵ㣬�Ե�ǰ���ڵ��ֵ
        AVLNode newNode = new AVLNode(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = left.value;
        this.left = this.left.left;
        this.right = newNode;
    }

    private void leftRotate() {
        //�����µĽڵ㣬�Ե�ǰ���ڵ��ֵ
        AVLNode newNode = new AVLNode(this.value);
        //���µĽڵ�����������Ϊ��ǰ�ڵ��������
        newNode.left = this.left;
        //���µĽڵ������������Ϊ��ǰ�ڵ����������������
        newNode.right = this.right.left;
        //�ѵ�ǰ�ڵ��ֵ�滻Ϊ���ӽڵ��ֵ
        this.value = this.right.value;
        //�ѵ�ǰ�ڵ������������Ϊ��������������
        this.right = this.right.right;
        //�ѵ�ǰ�ڵ�����ӽڵ�����Ϊ�µĽڵ�
        this.left = newNode;

    }

    //����Ҫɾ���Ľ��
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

    //����Ҫɾ�����ĸ��ڵ�
    public AVLNode searchParent(int value) {
        //�����ǰ�����Ҫɾ�����ĸ��ڵ㣬�ͷ���
        if ((this.left != null && this.left.value == value)
                || (this.right != null && this.right.value == value)) {
            return this;
        } else {

            //���Ҫ�ҵ�ֵС�ڵ�ǰֵ�����ҵ�ǰ�������ӽ�㲻Ϊ�գ�������ݹ�
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);

                //���Ҫ�ҵ�ֵ�ȵ�ǰֵ���ҵ�ǰ�������ӽ�㲻Ϊ�գ������ҵݹ�
            } else if (this.value <= value && this.right != null) {
                return this.right.searchParent(value);

                //������Ҳ���
            } else {
                return null;
            }
        }
    }

    //��ӽ��ķ���
    //�ݹ����ʽ��ӽ�㣬ע����Ҫ���������������Ҫ��
    public void add(AVLNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            //�����ǰ���ӽ��Ϊ��
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

        //�������ڵ������������ĸ߶ȱ��������ĸ߶Ȳ�ֵ����1������ת
        if (rightHeight() - leftHeight() > 1) {
            //������������������߶ȴ������������������ĸ߶ȣ��Ƚ�������ת�ٽ�������ת
            if (right != null && right.rightHeight() < right.leftHeight()) {
                //�ȶ�������������ת
                right.rightRotate();
                leftRotate();//����ת
            } else {
                leftRotate();//����ת
            }
            return;

        } else if (leftHeight() - rightHeight() > 1) {//����������ĸ߶ȱ��������ĸ߶Ȳ�ֵ����1������ת
            //����������������������߶ȴ��������������ĸ߶�
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //�ȶԵ�ǰ�ڵ����ڵ㣨�������� -> ����ת
                left.leftRotate();
                //�ٶԵ�ǰ�ڵ��������ת
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }

    //�������
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
