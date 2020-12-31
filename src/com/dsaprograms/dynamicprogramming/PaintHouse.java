package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
1. You are given a number n, representing the number of houses.
2. In the next n rows, you are given 3 space separated numbers representing the cost of
painting nth house with red or blue or green color.
3. You are required to calculate and print the minimum cost of painting all houses without
painting any consecutive house with same color.
Input Format
A number n
n1red n1blue n1green
n2red n2blue n2green
.. n number of elements
Output Format
A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
Constraints
1 <= n <= 1000
0 <= n1red, n1blue, .. <= 1000
Sample Input
4
1 5 7
5 8 4
3 2 9
1 2 4
Sample Output
8
 */
public class PaintHouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int houses = sc.nextInt();
        int [][] array = new int[houses][3]; // 3 Colors
        int [][] dp = new int[houses][3];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                array[i][j] = sc.nextInt();
            }
        }

        dp[0][0]=array[0][0];
        dp[0][1]=array[0][1];
        dp[0][2]=array[0][2];
        for(int i = 1;i<array.length;i++){
            dp[i][0] = array[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = array[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = array[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }
        System.out.println(Math.min(dp[houses-1][0],Math.min(dp[houses-1][1],dp[houses-1][2])));
    }
}
