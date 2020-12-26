package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
1. You are given a number n, representing the number of rows.
        2. You are given a number m, representing the number of columns.
        3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
        4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from
        any row in the left wall.

        /                   4
        you can traverse  ->     eg: 2 3  (find  maximum within that next col and add it to 2-> represents maximum gold it can get by traversing from 2)
        \	                5
*/
public class GoldMine {
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
        for(int col=arr[0].length-1;col>=0;col--){
            for(int row=0;row<arr.length;row++){ // doesn't matter if it is traversed from top or bottom.
                if(col==arr[0].length-1){ //last Column
                    dp[row][col]=arr[row][col];
                }
                else if(row==0){// first row
                    dp[row][col]=arr[row][col]+ Math.max(dp[row][col+1],dp[row+1][col+1]);
                }
                else if(row==arr.length-1){ // last row
                    dp[row][col]=arr[row][col]+ Math.max(dp[row][col+1],dp[row-1][col+1]);
                }
                else{// inbetween elements
                    dp[row][col]=arr[row][col] + Math.max(dp[row][col+1],Math.max(dp[row-1][col+1],dp[row+1][col+1]));
                    // used two Math.max because in that we can compare only two but we have to compare three.
                }
            }
        }
        // return the maximum number from col 0
        int max=dp[0][0];
        for(int row=0;row<arr.length;row++){
            if(dp[row][0]>max){
                max=dp[row][0];
            }
        }
        System.out.println(max);
    }
}
