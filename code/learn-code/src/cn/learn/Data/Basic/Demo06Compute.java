package cn.learn.Data.Basic;
/*
    输入一个表达式 如[7*2*2.5+1-5*3-3]
    点击计算得到结果
    思路分析：
        使用栈完成计算一个表达式的结果，两个栈，一个数栈：存放数；另一个符号栈：存放运算符
        通过一个index值，来遍历我们的表达式
        如果我们发现一个数字，直接如数栈
        如果发现是一个符号，就分如下情况
            1、如果发现当前的符号栈为空，直接入栈
            2.1、如果符号栈有操作符，就进行比较，如果当前操作符的优先级小于等于栈中的操作符，需要从数栈中pop出两个数，
                再从符号栈中pop出一个符号，进行运算，
                将得到结果入留存，若符号栈中为空，直接入栈
                    若符号栈不为空，若当前操作符的优先级小于等于栈中的操作符，从数栈中pop出一个数
                         符号栈中pop出一个符号，进行运算（这样一来符号栈中至多出现一个符号位）
            2.2、如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
        当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        最后在数栈只有一个数字，就是表达式的结果

*/

public class Demo06Compute {
    public static void main(String[] args) {
        //根据思路完成表达式
        String expression = "70-20*5+5-20*5";
        Stack numStack = new Stack();
        Stack operStack = new Stack();

        //定义需要的相关变量
        int index = 0; //用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到char保存ch
        String keepNum = ""; //用于拼接多位数
        //开始循环扫描表达式
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么，做相应的处理
            if (operStack.isOper(ch)) {
                //判定当前符号栈是否为空
                if (!operStack.isEmpty()) {
                    //不为空 进行判断
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
                        //把运算结果入栈
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);//如果当前操作符的优先级大于栈中的的操作符，就直接入符号栈
                    }
                }else {
                    //如果为空直接入符号栈
                    operStack.push(ch);
                }
            }else {
                //不能发现是一个数就立即入栈，因为可能是多位数
                //若下一位还是数，则叠加到字符串中
                keepNum += ch;

                if (index == expression.length() - 1) {//若索引是最后一位，直接入数栈
                    numStack.push(ch - 48);
                } else if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                    //如果后一位是操作符，将字符串转为数，添加到数栈中
                    numStack.push(Integer.parseInt(keepNum));
                    //初始化字符串
                    keepNum = "";
                }
            }
            //让index+1，并判断是否扫描到最后
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        //当扫描完毕
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

        System.out.printf("表达式%s = %d",expression,res);
    }
}

class Stack{
    private node head = new node(-1);

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    //查看当前栈顶的值
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
            System.out.println("栈空！！");
            return null;
        }
        node temp = head.getNext();
        node value = temp;
        head.setNext(temp.getNext());
        return value;

    }
    public void list() {
        if (head.getNext() == null) {
            System.out.println("栈空");
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

    //返回运算符的优先级，优先级使用数字表示，数字越大表示优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }else if (oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1;//目前假定表达式只有   +-*/
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    //计算方法
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