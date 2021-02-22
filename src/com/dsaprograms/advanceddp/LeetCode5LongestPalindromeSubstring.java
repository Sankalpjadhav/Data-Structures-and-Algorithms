package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 5. Longest Palindromic Substring
Based on Count Palindromic Subsequence program.
Given a string s, return the longest palindromic substring in s.
Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:
Input: s = "cbbd"
Output: "bb"
Example 3:
Input: s = "a"
Output: "a"
Example 4:
Input: s = "ac"
Output: "a"
 */
public class LeetCode5LongestPalindromeSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        boolean [][] dp = new boolean[n][n];
        String longestPalindromicSubstring = "";
        int maxLength= 0;
        for(int diagonal = 0;diagonal<dp.length;diagonal++){
            for(int i=0,j=diagonal;j<dp.length;i++,j++){
                if(diagonal==0){
                    dp[i][j]=true;
                    longestPalindromicSubstring = str.charAt(0)+"";
                }
                else if(diagonal==1){
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = true;
                        longestPalindromicSubstring = j<str.length()-1?str.substring(i,j+1):str.substring(i);
                    }
                }
                else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                        if(j-i>maxLength){
                            maxLength = j-i;
                            longestPalindromicSubstring = j<str.length()-1?str.substring(i,j+1):str.substring(i);
                        }
                    }
                }
            }
        }
        System.out.println("Longest palindromic substring: "+longestPalindromicSubstring);
    }
}
