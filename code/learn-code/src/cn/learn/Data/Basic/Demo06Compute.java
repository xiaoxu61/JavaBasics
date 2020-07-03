package cn.learn.Data.Basic;
/*
    ����һ�����ʽ ��[7*2*2.5+1-5*3-3]
    �������õ����
    ˼·������
        ʹ��ջ��ɼ���һ�����ʽ�Ľ��������ջ��һ����ջ�����������һ������ջ����������
        ͨ��һ��indexֵ�����������ǵı��ʽ
        ������Ƿ���һ�����֣�ֱ������ջ
        ���������һ�����ţ��ͷ��������
            1��������ֵ�ǰ�ķ���ջΪ�գ�ֱ����ջ
            2.1���������ջ�в��������ͽ��бȽϣ������ǰ�����������ȼ�С�ڵ���ջ�еĲ���������Ҫ����ջ��pop����������
                �ٴӷ���ջ��pop��һ�����ţ��������㣬
                ���õ���������棬������ջ��Ϊ�գ�ֱ����ջ
                    ������ջ��Ϊ�գ�����ǰ�����������ȼ�С�ڵ���ջ�еĲ�����������ջ��pop��һ����
                         ����ջ��pop��һ�����ţ��������㣨����һ������ջ���������һ������λ��
            2.2�������ǰ�Ĳ����������ȼ�����ջ�еĲ���������ֱ�������ջ
        �����ʽɨ����ϣ���˳��Ĵ���ջ�ͷ���ջ��pop����Ӧ�����ͷ��ţ�������
        �������ջֻ��һ�����֣����Ǳ��ʽ�Ľ��

*/

public class Demo06Compute {
    public static void main(String[] args) {
        //����˼·��ɱ��ʽ
        String expression = "70-20*5+5-20*5";
        Stack numStack = new Stack();
        Stack operStack = new Stack();

        //������Ҫ����ر���
        int index = 0; //����ɨ��
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//��ÿ��ɨ��õ�char����ch
        String keepNum = ""; //����ƴ�Ӷ�λ��
        //��ʼѭ��ɨ����ʽ
        while (true) {
            //���εõ�expression��ÿһ���ַ�
            ch = expression.substring(index,index+1).charAt(0);
            //�ж�ch��ʲô������Ӧ�Ĵ���
            if (operStack.isOper(ch)) {
                //�ж���ǰ����ջ�Ƿ�Ϊ��
                if (!operStack.isEmpty()) {
                    //��Ϊ�� �����ж�
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop().getNo();
                        num2 = numStack.pop().getNo();
                        oper = operStack.pop().getNo();
                        res = numStack.cal(num1, num2, oper);
                        if (!operStack.isEmpty()){
                            if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                                num1 = res;
                                num2 = numStack.pop().getNo();
                                oper = operStack.pop().getNo();
                                res = numStack.cal(num1, num2, oper);
                            }
                        }
                        //����������ջ
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);//�����ǰ�����������ȼ�����ջ�еĵĲ���������ֱ�������ջ
                    }
                }else {
                    //���Ϊ��ֱ�������ջ
                    operStack.push(ch);
                }
            }else {
                //���ܷ�����һ������������ջ����Ϊ�����Ƕ�λ��
                //����һλ������������ӵ��ַ�����
                keepNum += ch;

                if (index == expression.length() - 1) {//�����������һλ��ֱ������ջ
                    numStack.push(ch - 48);
                } else if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                    //�����һλ�ǲ����������ַ���תΪ������ӵ���ջ��
                    numStack.push(Integer.parseInt(keepNum));
                    //��ʼ���ַ���
                    keepNum = "";
                }
            }
            //��index+1�����ж��Ƿ�ɨ�赽���
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        //��ɨ�����
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop().getNo();
            num2 = numStack.pop().getNo();
            oper = operStack.pop().getNo();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        System.out.printf("���ʽ%s = %d",expression,res);
    }
}

class Stack{
    private node head = new node(-1);

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    //�鿴��ǰջ����ֵ
    public int peek() {
        return head.getNext().getNo();
    }

    public void push(int no) {
        node newNode = new node(no);

        if (head.getNext() == null) {
            head.setNext(newNode);
            return;
        }
        newNode.setNext(head.getNext());
        head.setNext(newNode);
    }

    public node pop() {
        if (head.getNext() == null) {
            System.out.println("ջ�գ���");
            return null;
        }
        node temp = head.getNext();
        node value = temp;
        head.setNext(temp.getNext());
        return value;

    }
    public void list() {
        if (head.getNext() == null) {
            System.out.println("ջ��");
        }
        node temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    //��������������ȼ������ȼ�ʹ�����ֱ�ʾ������Խ���ʾ���ȼ�Խ��
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }else if (oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1;//Ŀǰ�ٶ����ʽֻ��   +-*/
        }
    }
    //�ж��ǲ���һ�������
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    //���㷽��
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2/num1;
                break;
        }
        return res;
    }
}

class node{
    private int no;
    private node next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }

    public node(int no) {
        this.no = no;
    }

    public String toString() {
        return "node [" + no +"]";
    }
}