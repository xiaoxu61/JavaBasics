package cn.learn.Data.Basic;
/*
问题：在8x8的棋盘格上摆放八个皇后，任意两个皇后都不能处于同一行、同一列、同一斜线上，问有多少种摆法
    八皇后问题的思路分析：
        1、第一个皇后先放第一行，第一列
        2、第二个皇后放在第二行，第一列，然后判断是否OK，如果不OK，继续放在第二列、第三列、依次把所有列放完，找到一个合适
        3、继续第三个皇后，....直到第8个皇后也能放在一个不冲突的位置，就算是找到了一个正解
        3、当得到一个正解后，在栈回退到上一个栈时，开始回溯，即将第一个皇后，放到第一列的所有正解，全部得到
        4、然后回头继续第一个皇后放第二列，后面继续执行1、2、3、4步骤
*/

public class Demo10Queen8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果比如 arr = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        new Demo10Queen8().check(0);
        System.out.println("总共解法：" + count);
        System.out.println("z总共判定多少次" + judgeCount);
    }

    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            judgeCount++;
            //先把当前皇后，放到该行的第一列
            array[n] = i;
            if (judge(n)) {
                //若不冲突，接着放n+1皇后
                check(n+1);
            }
            //如果冲突，就继续执行array[n] = i，即 将第n个皇后，放置在本行的 后移一个位置
        }
    }
    //判断是否冲突，查看我们放置第n个皇后时，检测该皇后是否和前面已摆放皇后冲突
    private boolean judge(int n) {

        for (int i = 0; i < n; i++) {
            //   表示是否在同一列                表示是否在统一斜线
            if (array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

    //皇后摆放位置的输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
