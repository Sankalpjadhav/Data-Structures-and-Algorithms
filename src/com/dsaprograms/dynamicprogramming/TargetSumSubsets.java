package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add
     up to "tar" or not.
 */
public class TargetSumSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] numbers = new int[n];
        for(int i=0;i<n;i++){
            numbers[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        boolean [][] dp = new boolean [numbers.length+1][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }
                else if(i==0){
                    dp[i][j]=false;
                }
                else if(j==0){
                    dp[i][j]=true;
                }
                else{
                    if(dp[i-1][j]==true){
                        dp[i][j]=true;
                    }
                    else{
                        int value = numbers[i-1];
                        if(j>=value){
                            if(dp[i-1][j-value]==true){
                                dp[i][j]=true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[numbers.length][target]);


    }
}
