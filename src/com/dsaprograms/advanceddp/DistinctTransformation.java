package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Distinct transformations.
1. You are given two strings S1 and S2.
2. You have to find the number of unique ways in which you can transform S1 to S2.
3. Transformation can be achieved by removing 0 or more characters from S1, such that the sequence formed by the remaining characters of S1 is identical to S2.
Sample Input
abcccdf
abccdf
Sample Output
3
 */
public class DistinctTransformation {
    public static int distinctTransformation(String source , String destination){
        int [][] dp = new int[destination.length()+1][source.length()+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = 1;
                }
                else if(i==dp.length-1){
                    dp[i][j] = 1;
                }
                else if(j==dp[0].length-1){
                    dp[i][j] = 0;
                }
                else {
                    char ch1 = destination.charAt(i);
                    char ch2 = source.charAt(j);
                    if(ch1==ch2){
                        dp[i][j] = dp[i][j+1] + dp[i+1][j+1];
                    }
                    else{
                        dp[i][j] = dp[i][j+1];
                    }
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        String destination = sc.nextLine();
        System.out.println("Number of unique ways in which we can transform S1 to S2: "+distinctTransformation(source, destination));
    }
}
