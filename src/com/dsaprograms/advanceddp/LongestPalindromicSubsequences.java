package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 516. Longest Palindromic Subsequence
https://leetcode.com/problems/longest-palindromic-subsequence/
Given a string s, find the longest palindromic subsequence's length in s.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
Example 1:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

   (1)             (2)             (3)             (4)
[_]__[_]        [a]__[_]        [_]__[d]        [a]__[d]
[_]_c[_]        [a]_c[_]        [_]_c[d]        [a]_c[d]
[_]b_[_]        [a]b_[_]        [_]b_[d]        [a]b_[d]
[_]bc[_]        [a]bc[_]        [_]bc[d]        [a]bc[d]
String = [c1][SetOfSubsequences(middlePart)][c2]
[c1][longestPalindromicSubsequence(middlePart)][c2]
To get the insights,  I have explained how to come up with formula in CountPalindromicSubsequences.java
if c1==c2
Then we can find longest palindromic subsequence in (4)  [c1][Set(middlePart)][c2]
which results into:
lengthOfLongestPalindromicSubsequence = 2 + lengthOfLongestPalindromicSubsequence(middlePart)

if c1!=c2
Then we can find longest palindromic subsequence in (1)(2)(3)  [c1][Set(middlePart)][c2]
which results into:
lengthOfLongestPalindromicSubsequence = Math.max([c1][Set(middlePart)], [Set(middlePart)][c2])
*/
public class LongestPalindromicSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int [][] dp = new int[str.length()][str.length()];
        for(int gap=0;gap<dp.length;gap++){
            for(int i=0,j=gap;j<dp[0].length;i++,j++){
                if(gap==0){
                    dp[i][j] = 1;
                }
                else if(gap==1){
                    dp[i][j] = str.charAt(i)==str.charAt(j)?2:1;
                }
                else{
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                        }
                    }
                }
            }
        System.out.println("Length of longest palindromic subsequence possible is : "+dp[0][str.length()-1]);
        }
}
