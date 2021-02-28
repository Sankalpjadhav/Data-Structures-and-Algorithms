package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Circle And Chords
Application of Catalan number
1. You are given a number N.
2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
3. You have to find the number of ways in which these chords can be drawn.
Sample Input
3
Sample Output
5
Sample Input
8
Sample Output
14
 */
public class NonIntersectingChords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        int [] dp = new int[line+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        System.out.println("Number of chords: "+dp[line]);
    }
}
