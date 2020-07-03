package cn.learn.ClassDefine;
/*
    小昭在玩一款游戏：在一个N层高的金字塔，以金字塔为第一层，第i层有i个落点，每个落点有若干枚金币
 在落点可以跳向左斜下或者向右斜下的落点，若知道金字塔的层数N及每层的金币数量分布，请计算在本次游戏中
 可以获得的最多的金币数量。
    输入描述：
        输入共有N+1行（N≤1024），第一行为高度；第二行至N+1行，为该金字塔的金币数量分布
    输出描述：
        输出金币数量
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class practice {
    public static void main(String[] args) throws IOException {
        System.out.println(Math.random());
        BufferedReader br = new BufferedReader(new FileReader("c:\\demo\\金字塔.txt"));
        int[] list = new int[10];
        List<int[]> ints = Arrays.asList(list);
        String line = br.readLine();
        int high = Integer.parseInt(line);
        System.out.println("金字塔高度" + high);
        int[][] matrix = new int[high][high];
        int count = 0;
        String str = null;
        int[] res = new int[high];
        while((str = br.readLine()) != null) {
            String[] split = str.split(" ");
            for (int i = 0; i < split.length; i++) {
                matrix[count][i] = Integer.parseInt(split[i]);
                res[i] = Integer.parseInt(split[i]);
            }
            count++;
        }
        for (int i = high -2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[j] = Math.max(res[j],res[j + 1]) + matrix[i][j];
            }
        }
        System.out.println("金字塔为");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%2d ",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.print("金币数量为：");
        System.out.println(res[0]);
        ArrayList<int[]> arr = new ArrayList<>();
        int[] i = {1,2};
        arr.add(i);
        System.out.println(arr);
        String s = "13g46g";
        Character.isDigit(s.charAt(1));
    }
}