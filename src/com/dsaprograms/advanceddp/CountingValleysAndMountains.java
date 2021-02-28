package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Counting Valleys And Mountains Dynamic Programming
Application of catalan numbers
1. You are given a number n, representing the number of upstrokes / and number of downstrokes .
2. You are required to find the number of valleys and mountains you can create using strokes.
Sample Input
4
Sample Output
14
 */
public class CountingValleysAndMountains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfUpandDownStrokes = sc.nextInt();
        int []dp = new int[numOfUpandDownStrokes+1];
        dp[0] = 1;
        dp[1] = 1;
        /*
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        OR
        */
        for(int i=2;i<dp.length;i++){
            int insideStroke = i - 1;
            int outsideStroke = 0;
            while(insideStroke>=0){
                dp[i] += dp[outsideStroke]*dp[insideStroke];
                insideStroke--;
                outsideStroke++;
            }
        }
        System.out.println("Number of valleys and mountains: "+dp[numOfUpandDownStrokes]);
    }
}
