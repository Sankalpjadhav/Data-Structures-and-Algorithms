package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Longest common substring
Basically we will be finding longest common suffix from all the prefixes of string 1 and string 2.
1. You are given two strings S1 and S2.
2. You are required to print the length of the longest common substring of two strings.
Sample Input
abcdgh
acdghr
Sample Output
4
 */
public class LongestCommonSubstring {
    public static void longestCommonSubstring(String str1, String str2){
        int [][] dp = new int[str1.length()+1][str2.length()+1];
        // i=0 row and j=0 column is for blank and it will be zero
        int maxLength = Integer.MIN_VALUE;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                char ch1 = str1.charAt(i-1);
                char ch2 = str2.charAt(j-1);
                if(ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1] + 1; // +1 becoz we need to include current char too.
                    if(dp[i][j] > maxLength){
                        maxLength = dp[i][j];
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println("Length of longest common substring: "+maxLength);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        longestCommonSubstring(str1, str2);
    }
}
