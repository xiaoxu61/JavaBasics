package cn.learn.ClassDefine;
/*
    С������һ����Ϸ����һ��N��ߵĽ��������Խ�����Ϊ��һ�㣬��i����i����㣬ÿ�����������ö���
 ��������������б�»�������б�µ���㣬��֪���������Ĳ���N��ÿ��Ľ�������ֲ���������ڱ�����Ϸ��
 ���Ի�õ����Ľ��������
    ����������
        ���빲��N+1�У�N��1024������һ��Ϊ�߶ȣ��ڶ�����N+1�У�Ϊ�ý������Ľ�������ֲ�
    ���������
        ����������
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
        BufferedReader br = new BufferedReader(new FileReader("c:\\demo\\������.txt"));
        int[] list = new int[10];
        List<int[]> ints = Arrays.asList(list);
        String line = br.readLine();
        int high = Integer.parseInt(line);
        System.out.println("�������߶�" + high);
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
        System.out.println("������Ϊ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%2d ",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.print("�������Ϊ��");
        System.out.println(res[0]);
        ArrayList<int[]> arr = new ArrayList<>();
        int[] i = {1,2};
        arr.add(i);
        System.out.println(arr);
        String s = "13g46g";
        Character.isDigit(s.charAt(1));
    }
}