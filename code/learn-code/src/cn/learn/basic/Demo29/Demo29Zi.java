package cn.learn.basic.Demo29;
/*
super�ؼ����������ʸ������ݣ���this�ؼ����������ʱ�������
super�ؼ��ֵ��÷������֣�
1���������Ա�����У����ʸ���ĳ�Ա����
2���������Ա�����У����ʸ���ĳ�Ա����
3��������Ĺ��췽���У����ʸ���Ĺ��췽��

this�ؼ��ֵ��÷���
1���ڱ���ĳ�Ա�����У����ʱ���ĳ�Ա����
2���ڱ���ĳ�Ա�����У����ʱ������һ����Ա����
3���ڱ����Ĺ��췽���У����ʱ������һ�����췽��
   this(...)����Ҳ�����ǹ��췽���ĵ�һ����䣬Ψһһ��
   super��this���ֹ�����ã�����ͬʱʹ��
*/

public class Demo29Zi extends Demo29Fu {
    int numZi = 20;

    int num = 200;

    public void methodZi() {
        //��Ϊ���൱����num�����������õ��Ǳ����num
        System.out.println(num);
        System.out.println(numFu);
        System.out.println("���෽��ִ�У�");
    }

    public void method() {
        int num = 30;
        System.out.println("�ֲ�����" + num);
        System.out.println("����ĳ�Ա����" + this.num);
        System.out.println("����ĳ�Ա����" + super.num);
        System.out.println("������������ִ��");
    }

    @Override
    public String method1() {
        return null;
    }

    public Demo29Zi() {
//        super();//�ڵ��ø����޲ι��췽��
        super(15);//�ڵ��ø������صĹ��췽��
        System.out.println("���๹�췽��");
    }
}
