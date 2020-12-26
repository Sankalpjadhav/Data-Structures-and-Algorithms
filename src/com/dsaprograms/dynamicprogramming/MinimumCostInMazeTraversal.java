package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
public class MinimumCostInMazeTraversal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][] arr =new int[n][m];
        int [][] dp =new int[n][m];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==arr.length-1 && j==arr[0].length-1){
                    dp[i][j]=arr[i][j];
                }
                else if(i==arr.length-1){
                    dp[i][j]=dp[i][j+1]+arr[i][j];
                }
                else if(j==arr[0].length-1){
                    dp[i][j]=dp[i+1][j]+arr[i][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i][j+1],dp[i+1][j])+arr[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
