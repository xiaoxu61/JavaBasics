package cn.learn.Data.Basic.Tree;
/*
    ������
        ������������ǰ�����򡢺�������Ĳ���
        1������һ�ö�����
        2��ǰ�����
            2.1�������ǰ�ڵ�(��ʼ��ʱ����root�ڵ�)
            2.2������ӽڵ㲻Ϊ�գ���ݹ����ǰ�����
            2.2������ӽڵ㲻Ϊ�գ���ݹ����ǰ�����
        3���������
            3.1�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ���ݹ��������
            3.2�����ǰ�ڵ�
            3.2�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ���ݹ��������
        4����������
            4.1�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ���ݹ�������
            4.2�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ���ݹ�������
            4.3�����ǰ�ڵ�

       �������������ҵ�˼·��
       ǰ����ң�
       1�����жϵ�ǰ�ڵ��no�Ƿ����Ҫ���ҵ�
       2�������ȣ��򷵻ص�ǰ�ڵ�
       3��������ȣ����жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
       4�������ݹ�ǰ����ң��ҵ��ڵ㣬�򷵻أ���������жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
       ������ң�
       1���жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
       2������ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ�ڵ�Ƚϣ�������򷵻ص�ǰ�ڵ㣬������������ҵݹ���������
       3�������ݹ�������ң��ҵ��ͷ��أ����򷵻�null
       ��������
       1���жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
       2������ҵ����ͷ��أ����û���ҵ������жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ����ҵݹ���к�����ң�
       3������ҵ����ͷ��أ�������Ǿͺ͵�ǰ�ڵ���бȽϣ�������򷵻أ����򷵻�null

       ɾ���ڵ��˼·����
       �涨��
        1�����ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
        2�����ɾ�����Ƿ�Ҷ�ӽڵ㣬��ɾ��������
       ˼·��
        1����Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�ڵ���ӽڵ��Ƿ���Ҫɾ���ڵ㣬
           ������ȥ�жϵ�ǰ����ڵ��ǲ�����Ҫɾ���ڵ�
        2�������ǰ�ڵ����������Ϊ�գ��������ӽڵ����Ҫɾ���Ľڵ㣬�ͽ�this.left = null
        3�������ǰ�ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľڵ㣬�ͽ�this.right = null
        4�������2��3��û��ɾ���ڵ㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
        5��������Ĳ�Ҳû��ɾ���ڵ㣬��Ӧ�����������еݹ�ɾ��
        5��������ǿ��������ֻ��rootһ���ڵ㣬��ȼ۶������ÿ�

*/

public class Demo14Tree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNodeTree root = new HeroNodeTree(1, "�ν�");
        HeroNodeTree hero2 = new HeroNodeTree(2, "����");
        HeroNodeTree hero3 = new HeroNodeTree(3, "¬����");
        HeroNodeTree hero4 = new HeroNodeTree(4, "�ֳ�");
        HeroNodeTree hero5 = new HeroNodeTree(5, "��ʤ");

        //���ֶ�����������
        root.setLeft(hero2);
        root.setRight(hero3);
        hero3.setRight(hero4);
        hero3.setLeft(hero5);
        binaryTree.setRoot(root);

        //����
        System.out.println("ǰ�����");//12354
        binaryTree.preOrder();

        System.out.println("�������");//21534
        binaryTree.infixOrder();

        System.out.println("�������");//25431
        binaryTree.postOrder();

        System.out.println("ǰ�����");
        HeroNodeTree resNode = binaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.printf("�ҵ��ˣ���ϢΪid = %d��name = %s\n",resNode.getNo(),resNode.getName());
        }
        System.out.println("�������");
        resNode = binaryTree.infixOrderSearch(5);
        if (resNode != null) {
            System.out.printf("�ҵ��ˣ���ϢΪid = %d��name = %s\n",resNode.getNo(),resNode.getName());
        }
        System.out.println("�������");
        resNode = binaryTree.postOrderSearch(5);
        if (resNode != null) {
            System.out.printf("�ҵ��ˣ���ϢΪid = %d��name = %s\n",resNode.getNo(),resNode.getName());
        }

        System.out.println("ɾ���ڵ�");
        binaryTree.deleteNode(1);

        binaryTree.preOrder();
    }
}

//������
class BinaryTree{
    private HeroNodeTree root;

    public void setRoot(HeroNodeTree root) {
        this.root = root;
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
