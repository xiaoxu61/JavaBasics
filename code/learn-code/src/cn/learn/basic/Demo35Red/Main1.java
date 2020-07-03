package cn.learn.basic.Demo35Red;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        /*Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int[] score = new int[num];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }*/
        int[] candies = {5,6,2,1};
        int[] temp = new int[candies.length];
        temp = candies;
        //temp = Arrays.copyOf(candies,candies.length);
        System.out.println(candies + "   "  + temp);
        double r = 1.355645;
        int a = (int) Math.round((double) 5/2);
        System.out.println( Math.round((double) 5/2));
        System.out.printf("%.3f",r);

        //



       /* System.out.println(num);
        for (int i : score) {
            System.out.println(i);
        }
        scn.close();*/
    }
}
