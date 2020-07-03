package cn.learn.Data.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo07PolandNotation {
    public static void main(String[] args) {
        //�ȶ���һ���沨�����ʽ
        //(3+4)*5-6  --->  34+5*6-
        //4*5-8+60+8/2 ��׺���ʽ--->>  4 5 * 8 - 60 + 8 2 / +  ��׺���ʽ
//        String suffixExpression = "3 40 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";


        /*
        1���Ƚ� "3 4 + 5 * 6 - "  �ŵ�ArrayList��
        2����ArrayList ���ݸ�һ�����������ջ ��ɼ���
        */
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);

        int res = calculate(rpnList);
        System.out.println(res);
        //��׺���ʽת��׺���ʽ�ķ���
        String expression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        List<String> listString = getListString(expression);
        String s = parseSuffixExpressionList(listString);
        List<String> listString1 = getListString(s);
        int calculate = calculate(listString1);
        System.out.println(listString);
        System.out.println(s);
        System.out.println(calculate);
    }

    //��һ���沨�����ʽ�����ν����ݺ������ ���뵽ArrayList��
    public static List<String> getListString(String suffixExpression) {
        //���ַ����ָ�
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    /*
        ��׺���ʽת��׺���ʽ��˼·����
            1����ʼ������ջ�������ջs1�ʹ洢�м�����ջs2
            2����������ɨ����׺���ʽ
            3������������ʱ������ѹ��s2
            4�����������ʱ���Ƚ�����ջ������������ȼ�
                ���s1Ϊ�գ���ջ�������Ϊ������ ��ֱ�ӽ����������ջ
                ���s1��Ϊ�գ������ȼ���ջ���ĸߣ�Ҳ�������ѹ��s1
                ���s1��Ϊ�գ���s1ջ���������������ѹ�뵽s2�У��ٴ�ת��4.1��s1���µ�ջ���������Ƚ�
            5����������ʱ
                ����������ţ���ֱ��ѹ��s1
                ����������ţ������ε���s1ջ�������������ѹ��s2��ֱ������������Ϊֹ����ʱ����һ�����Ŷ���
            6���ظ�����2~5��֪�����ʽ�����ұ�
            7����s1��ʣ�����������ε�����ѹ��s2
            8�����ε���s2�е�Ԫ�ز���������������Ϊ��׺���ʽ��Ӧ�ĺ�׺���ʽ
    */
    public static String parseSuffixExpressionList(List<String> list) {
        Stack<String> stack1 = new Stack<>();//����ջ
        Stack<String> stack2 = new Stack<>();//�洢�м�ջ

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
                stack1.pop();//��С���ŵ���
            }else {
                //��s�����ȼ�С�ڵ��� stack1 �����ȼ� ��s1ջ���������������ѹ�뵽s2�У��ٴ�ת��4.1��s1���µ�ջ���������Ƚ�

                while (stack1.size() != 0 && Operation.getValue(stack1.peek()) >= Operation.getValue(s)) {
                    stack2.push(stack1.pop());
                }
                //����Ҫ��sѹ��ջ��
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

    //��ɶ��沨�����ʽ�ļ���
    /*
        1����������ɨ�裬��3��4ѹ��ջ��
        2������+���������˵���4��3 ��4Ϊջ��Ԫ�أ�3Ϊ�ζ�Ԫ�أ��������3+4����7���ٽ�7��ջ
        3����5��ջ
        4����������*���������˵���5��7�������7*5=35����35��ջ
        5����6��ջ
        �����-������������35-6=29���ó����ս��
    */
    public static int calculate(List<String> ls) {
        //����һ��ջ��ֻ��Ҫһ��վ����
        Stack<String> stack = new Stack<>();
        //����ls
        for(String s : ls) {
            //����ʹ��������ʽ��ȡ����
            if (s.matches("\\d+")) {//ƥ����Ƕ�λ��
                //��ջ
                stack.push(s);
            }else {
                //pop���������������㣬����ջ
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
                    throw new RuntimeException("���������");
                }
                //��res��ջ
                stack.push(res+"");
            }
        }
        //�������stack�е����ݽ����
        return Integer.parseInt(stack.pop());
    }
}

//��дһ����Operation ���Է���һ������� ��Ӧ�����ȼ�
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