package com.dsaprograms.practice;
import java.util.Scanner;
/*
1. You are given a number n, representing the number of rows of a matrix.
2. You are given a number m, representing the number of columns of a matrix.
3. You are given n * m numbers, representing elements of 2d array a.

4. You are given a shell number s.
5. You are given a number r, representing number of anti-clockwise rotations (for +ve numbers) of the shell s.
6. You are required to rotate the sth shell of matrix by r rotations and display the matrix using display function.
 */
public class ShellRotate {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int s =sc.nextInt();
        int r =sc.nextInt();
        shellrotate(arr, s, r);
        display(arr);
    }

    public static void shellrotate(int[][] arr, int s, int r) {
        int[] larr = fillLinear(arr, s);
        rotate(larr, r);
        fill2d(arr, larr, s);
    }

    public static int[] fillLinear(int[][] arr, int s) {



        int rmin = s - 1;
        int cmin = s - 1;
        int rmax = arr.length - s;
        int cmax = arr[0].length - s;
        /*
        size = lw + bw + rw + tw -4;
            lw = rmax - rmin + 1
            rw = rmax - rmin + 1

            bw = cmax - cmin + 1
            tw = cmax - cmin + 1

            So,
            lw==rw and bw==tw
            size =  2*lw + 2*bw -4
                 = 2(rmax - rmin + 1) + 2(cmax - cmin + 1) -4
                 = 2*rmax - 2*rmin +2 + 2*cmax - 2*cmin +2 - 4
                 = 2*(rmax - rmin + cmax - cmin)
         */
        int size = 2*(rmax - rmin + cmax - cmin);
        int[] larr = new int[size];
        // left wall
        int idx = 0;
        for (int i = rmin; i <= rmax; i++) {
            larr[idx] = arr[i][cmin];
            idx++;
        }

        // bottom wall
        for (int j = cmin + 1; j <= cmax; j++) {
            larr[idx] = arr[rmax][j];
            idx++;
        }

        // right wall
        for (int i = rmax - 1; i >= rmin; i--) {
            larr[idx] = arr[i][cmax];
            idx++;
        }

        // top wall
        for (int j = cmax - 1; j >= cmin + 1; j--) {
            larr[idx] = arr[rmin][j];
            idx++;
        }

        return larr;
    }

    public static void fill2d(int[][] arr, int[] larr, int s) {
        // Same as above but arr[i][cmin] = larr[idx]; is interchanged. larr is also given.
        int rmin = s - 1;
        int cmin = s - 1;
        int rmax = arr.length - 1 - (s - 1);
        int cmax = arr[0].length - 1 - (s - 1);

        // left wall
        int idx = 0;
        for (int i = rmin; i <= rmax; i++) {
            arr[i][cmin] = larr[idx];
            idx++;
        }

        // bottom wall
        for (int j = cmin + 1; j <= cmax; j++) {
            arr[rmax][j] = larr[idx];
            idx++;
        }

        // right wall
        for (int i = rmax - 1; i >= rmin; i--) {
            arr[i][cmax] = larr[idx];
            idx++;
        }

        // top wall
        for (int j = cmax - 1; j >= cmin + 1; j--) {
            arr[rmin][j] = larr[idx];
            idx++;
        }
    }

    public static void rotate(int[] larr, int r) {
        r = r % larr.length;
        if (r < 0) {
            r += larr.length;
        }

        reverse(larr, 0, larr.length - 1 - r);
        reverse(larr, larr.length - r, larr.length - 1);
        reverse(larr, 0, larr.length - 1);
    }

    public static void reverse(int[] arr, int i1, int i2) {
        int li = i1;
        int ri = i2;
        while (li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;

            li++;
            ri--;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
