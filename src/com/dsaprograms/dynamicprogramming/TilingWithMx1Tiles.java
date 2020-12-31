package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
Tiling with M x 1
1. You are given a number n and a number m separated by line-break representing the length and breadth of a n * m floor.
2. You've an infinite supply of m * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 */
public class TilingWithMx1Tiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            if(i<m){
                dp[i]=1; // Vertical
            }
            else if(i==m){
                dp[i]=2; // Horizontal and vertical.
            }
            else{
                dp[i] = dp[i-1] + dp[i-m];
            }
        }
        System.out.println(dp[n]);
    }
}
