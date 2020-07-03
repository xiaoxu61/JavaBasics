package cn.learn.Data.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo07PolandNotation {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //(3+4)*5-6  --->  34+5*6-
        //4*5-8+60+8/2 中缀表达式--->>  4 5 * 8 - 60 + 8 2 / +  后缀表达式
//        String suffixExpression = "3 40 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";


        /*
        1、先将 "3 4 + 5 * 6 - "  放到ArrayList中
        2、将ArrayList 传递给一个方法，配合栈 完成计算
        */
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);

        int res = calculate(rpnList);
        System.out.println(res);
        //中缀表达式转后缀表达式的方法
        String expression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        List<String> listString = getListString(expression);
        String s = parseSuffixExpressionList(listString);
        List<String> listString1 = getListString(s);
        int calculate = calculate(listString1);
        System.out.println(listString);
        System.out.println(s);
        System.out.println(calculate);
    }

    //将一个逆波兰表达式，依次将数据和运算符 放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将字符串分隔
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    /*
        中缀表达式转后缀表达式的思路分析
            1、初始化两个栈：运算符栈s1和存储中间结果的栈s2
            2、从左至右扫描中缀表达式
            3、遇到操作数时，将其压入s2
            4、遇到运算符时，比较其与栈顶运算符的优先级
                如果s1为空，或栈顶运算符为左括号 则直接将此运算符入栈
                如果s1不为空，若优先级比栈顶的高，也将运算符压入s1
                如果s1不为空，将s1栈顶的运算符弹出并压入到s2中，再次转到4.1与s1中新的栈顶运算符相比较
            5、遇到括号时
                如果是左括号，则直接压入s1
                如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
            6、重复步骤2~5，知道表达式的最右边
            7、将s1中剩余的运算符依次弹出并压入s2
            8、依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
    */
    public static String parseSuffixExpressionList(List<String> list) {
        Stack<String> stack1 = new Stack<>();//符号栈
        Stack<String> stack2 = new Stack<>();//存储中间栈

        String expression = "";

        for (String s : list) {
            if (s.matches("\\d+")) {
                stack2.push(s);
            }else if (s.equals("(")) {
                stack1.push(s);
            }else if (s.equals(")")) {
                while (!stack1.peek().equals("(")) {
                    stack2.push(stack1.pop());
                }
                stack1.pop();//将小括号弹出
            }else {
                //当s的优先级小于等于 stack1 的优先级 将s1栈顶的运算符弹出并压入到s2中，再次转到4.1与s1中新的栈顶运算符相比较

                while (stack1.size() != 0 && Operation.getValue(stack1.peek()) >= Operation.getValue(s)) {
                    stack2.push(stack1.pop());
                }
                //还需要将s压入栈中
                stack1.push(s);
            }

        }
        while (true) {
            if (stack1.empty()) {
                break;
            }
            stack2.push(stack1.pop());
        }
        while (true) {
            if (stack2.empty()) {
                break;
            }
            expression = stack2.pop() + " "+ expression ;
        }
        return expression;
    }

    //完成对逆波兰表达式的计算
    /*
        1、从左至右扫描，将3和4压入栈堆
        2、遇到+运算符，因此弹出4和3 （4为栈顶元素，3为次顶元素），计算出3+4，得7，再将7入栈
        3、将5入栈
        4、接下来是*运算符，因此弹出5和7，计算出7*5=35，将35入栈
        5、将6入栈
        最后是-运算符，计算出35-6=29，得出最终结果
    */
    public static int calculate(List<String> ls) {
        //创建一个栈，只需要一个站即可
        Stack<String> stack = new Stack<>();
        //遍历ls
        for(String s : ls) {
            //这里使用正则表达式来取出数
            if (s.matches("\\d+")) {//匹配的是多位数
                //入栈
                stack.push(s);
            }else {
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")){
                    res = num1 + num2;
                }else if (s.equals("-")) {
                    res = num1 - num2;
                }else if (s.equals("*")) {
                    res = num1 * num2;
                }else if (s.equals("/")) {
                    res = num1/num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res+"");
            }
        }
        //最后留在stack中的数据结果是
        return Integer.parseInt(stack.pop());
    }
}

//编写一个类Operation 可以返回一个运算符 对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
        }
        return result;
    }
}