package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Count Number of Binary Search Trees with N Nodes
Application of Catalan Numbers
1. You are given a number n, representing the number of elements.
2. You are required to find the number of Binary Search Trees you can create using the elements.
Sample Input
4
Sample Output
14
 */
public class CountNumberOfBSTPossible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfNodes = sc.nextInt();
        int []dp = new int[numberOfNodes+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        System.out.println("Number of Binary Search Trees possible with N Nodes: "+dp[numberOfNodes]);
    }
}
