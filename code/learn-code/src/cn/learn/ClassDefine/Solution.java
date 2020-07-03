package cn.learn.ClassDefine;


import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String S = "1-2--3--4-5--6--7";

        int temp = Integer.valueOf(S.substring(0,1));
        TreeNode root = new TreeNode(temp);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < S.length();) {
            int level = 0;
            int value = 0;
            while(S.charAt(i) == '-') {
                level++;
                i++;
            }
            while (i < S.length() && Character.isDigit(S.charAt(i))) {
                value = value*10 + (S.charAt(i) - '0');
                i++;
            }

            while (stack.size() > level) {
                stack.pop();
            }
            TreeNode node = new TreeNode(value);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.push(node);
        }


    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "{val = "+ val+"}";
    }
}
