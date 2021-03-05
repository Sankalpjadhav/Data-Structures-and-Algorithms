package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 583. Delete Operation for Two Strings
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
In one step, you can delete exactly one character in either string.
Example 1:
Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:
Input: word1 = "leetcode", word2 = "etco"
Output: 4
 */
public class LeetCode583DeleteOperationFor2Strings {
    public static int deleteOperation(String str1, String str2) {
        //Just apply longest common subsequence concept
        int [][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = 0;
                }
                else if(i==dp.length-1){
                    dp[i][j] = 0;
                }
                else if(j==dp[0].length-1){
                    dp[i][j] = 0;
                }
                else{
                    char ch1 = str1.charAt(i);
                    char ch2 = str2.charAt(j);
                    if(ch1==ch2){
                        dp[i][j] = 1 + dp[i+1][j+1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                    }
                }
            }
        }
        int result = str1.length() - dp[0][0] + str2.length() - dp[0][0];
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println("The minimum number of steps required to make String 1 and String 2 the same: "+deleteOperation(str1, str2));
    }
}
