package cn.learn.Data.Basic;
/*
    读取指定txt文件的稀疏数组内容，将其恢复为二位数组
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo01Qipan {
    public static void main(String[] args) throws IOException {
        FileReader r = new FileReader("C:\\demo\\1.txt");
        BufferedReader br = new BufferedReader(r);
        List<String> strArr  =new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null){
            strArr.add(str);
        }
        br.close();
        r.close();

        System.out.println(strArr.size());

        int spareArr[][] = new int[strArr.size()][3];

        System.out.println(strArr);
        for (int i = 0; i < strArr.size(); i++) {
           String[] split = strArr.get(i).split("\\s+");
            System.out.println(split[2]);
           spareArr[i][0] = Integer.valueOf(split[0]);
           spareArr[i][1] = Integer.valueOf(split[1]);
           spareArr[i][2] = Integer.valueOf(split[2]);
            System.out.println(i);
        }

        for(int[] row : spareArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        int row = spareArr[0][0];
        int col = spareArr[0][1];
        int chaseArr[][] = new int[row][col];
        for (int i = 1; i < spareArr.length; i++) {
            row = spareArr[i][0];
            col = spareArr[i][1];
            chaseArr[row][col] = spareArr[i][2];
        }

        for (int[] ro : chaseArr) {
            for (int co : ro) {
                System.out.printf("%d\t",co);
            }
            System.out.println();
        }

    }
}
