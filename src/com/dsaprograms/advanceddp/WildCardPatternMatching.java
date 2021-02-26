package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 44. Wildcard Matching
https://leetcode.com/problems/wildcard-matching/
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:
Input: s = "adceb", p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:
Input: s = "acdcb", p = "a*c?b"
Output: false
 */
public class WildCardPatternMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        boolean [][] dp = new boolean[pattern.length()+1][text.length()+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = true;
                }
                else if(i==dp.length-1){
                    dp[i][j] = false;
                }
                else if(j==dp[0].length-1){
                    if(pattern.charAt(i)=='*'){
                        dp[i][j] = dp[i+1][j];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else{
                    if(pattern.charAt(i)=='?'){
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else if(pattern.charAt(i)=='*'){
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    }
                    else if(pattern.charAt(i) == text.charAt(j)){
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        System.out.println("WildCard pattern can be matched with text? "+dp[0][0]);
    }
}
