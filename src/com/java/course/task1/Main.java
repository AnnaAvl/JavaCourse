package com.java.course.task1;

import java.util.Arrays;
import java.util.Scanner;

// Справа - налево, сверху - вниз

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the matrix");
        int raz = s.nextInt();
        int[][] arr = new int[raz][raz];
        System.out.println("Enter the matrix by lines");
        for (int i = 0; i < raz; i++) {
            for (int j = 0; j < raz; j++) {
//                arr[i][j] = s.nextInt();
                arr[i][j] = (int) (Math.random() * 10);
            }
        }

        print(arr);
        int[] arr_s = sum(arr);
    }

    public static void print(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[] sum(int[][]arr){
        int raz = arr.length;
        int[] arr_1 = new int[2 * raz - 1];
        Arrays.setAll(arr_1, a -> (a = 0));


        System.out.println();

        for (int i = 0; i < raz; i++) {
            for (int j = raz - 1; j >= 0; j--) {
                arr_1[(j + i)] += arr[i][j];
            }
        }
        for (int i = 0; i < (2 * raz - 1); i++) {
            System.out.print(arr_1[i] + " ");
        }

        return arr_1;
    }
}
