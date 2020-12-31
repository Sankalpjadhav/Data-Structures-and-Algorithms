package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of
the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive
house with same color.
Input Format
A number n
n1-0th n1-1st n1-2nd .. n1-kth
n2-0th n2-1st n2-2nd .. n2-kth
.. n number of elements
Output Format
A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
Constraints
1 <= n <= 1000
1 <= k <= 10
0 <= n1-0th, n1-1st, .. <= 1000
Sample Input
4 3
1 5 7
5 8 4
3 2 9
1 2 4
Sample Output
8
 */
public class PaintHouse2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        int houses = sc.nextInt();
        int colors = sc.nextInt();
        int[][] arr = new int[houses][colors];
        for (int i = 0; i < houses; i++) {
            for (int j = 0; j < colors; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE; //second minimum
        for (int j = 0; j < colors; j++) {
            if (arr[0][j] <= min) {
                smin = min;
                min = arr[0][j];
            } else if (arr[0][j] <= smin) {
                smin = arr[0][j];
            }
        }

        for (int i = 1; i < houses; i++) {
            int cmin = Integer.MAX_VALUE;
            int csmin = Integer.MAX_VALUE;

            for (int j = 0; j < colors; j++) {
                if (arr[i - 1][j] != min) {
                    arr[i][j] += min;
                } else {
                    arr[i][j] += smin;
                }

                if (arr[i][j] <= cmin) {
                    csmin = cmin;
                    cmin = arr[i][j];
                } else if (arr[i][j] <= csmin) {
                    csmin = arr[i][j];
                }
            }

            min = cmin;
            smin = csmin;
        }

        System.out.println(min);
    }
}
