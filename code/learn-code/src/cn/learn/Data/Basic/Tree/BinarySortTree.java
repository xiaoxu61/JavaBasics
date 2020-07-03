package cn.learn.Data.Basic.Tree;
/*
����������
    ���ڶ������������κ�һ����Ҷ�ӽ�㣬Ҫ�����ӽڵ��ֵ�ȵ�ǰ����ֵС�����ӽ���ֵ�ȵ�ǰ����ֵ��
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
        System.out.println("ɾ������");
        binarySort.infixOrder();
    }
}

//��������������
class BinarySortT {
    private BinaryNode root;

    //����Ҫɾ���Ľ��
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

    //ɾ�����
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1����Ҫ��ȥ�ҵ�ɾ���Ľ�㣬targetNode
            BinaryNode targetNode = search(value);
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
            BinaryNode parentNode = searchParent(value);

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
                BinaryNode tempTarget = targetNode.right;
                boolean flag = false;
                while (tempTarget.left != null) {//һֱ��������ͻ�һֱѭ��
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

    public void add(BinaryNode node) {
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

    //����Ҫɾ���Ľ��
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

    //����Ҫɾ�����ĸ��ڵ�
    public BinaryNode searchParent(int value) {
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
    public void add(BinaryNode node) {
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
