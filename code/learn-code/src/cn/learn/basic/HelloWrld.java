package cn.learn.basic;


import java.util.ArrayList;
import java.util.List;

public class HelloWrld {
    public static void main(String[] args) {
        System.out.println("HelloWorld!!!");
        Byte a = null;
        System.out.println(a);

        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        boolean find = Find(7, new int[0][0]);
        System.out.println(find);
    }
    public static boolean Find(int target, int [][] array) {
        if (array.length == 0) {
            return false;
        }

        int row = array.length;
        int column = array[0].length;
        if (target > array[row - 1][column - 1]) {
            return false;
        } else {
            List<Integer> indexRow = new ArrayList<>();
            int indexCol = 0;

            for (int i = row - 1; i >= 0; i--) {
                if (target > array[i][column - 1]) {
                    break;
                }
                if (target < array[i][column - 1] && target > array[i][0]) {
                    indexRow.add(i);
                }
            }
            boolean flag = false;
            for (int i = 0; i < indexRow.size(); i++) {
                for (int j = 0; j < column; j++) {
                    if (target == array[indexRow.get(i)][j]) {
                        flag = true;
                        break;
                    }
                }
            }
            return flag;
        }
    }
}
