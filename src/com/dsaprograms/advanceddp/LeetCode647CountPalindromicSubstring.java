package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 647. Palindromic Substrings
Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class LeetCode647CountPalindromicSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        boolean [][] dp = new boolean[n][n];
        int count = 0;
        for(int diagonal=0;diagonal<dp.length;diagonal++){
            for(int i=0,j=diagonal;j<dp.length;i++,j++){
                if(diagonal==0){
                    dp[i][j] = true;
                }
                else if(diagonal==1){
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = true;
                    }
                    else{
                        // Default value is already false
                    }
                }
                else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]==true){
                            dp[i][j] = true;
                    }
                    else{
                        // Default value is already false
                    }
                }
                if(dp[i][j]){
                    count++;
                }
            }
        }
        System.out.println("Count of palindromic subsequences: "+count);
    }
}
