package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 712. Minimum ASCII Delete Sum for Two Strings
Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 */
public class LeetCode719AciiDeleteSum {
    public static int minimumASCIIDeleteSum(String str1, String str2){
        int [][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = 0;
                }
                else if(i==dp.length-1){
                    dp[i][j] = str2.charAt(j) + dp[i][j+1];
                }
                else if(j==dp[0].length-1){
                    dp[i][j] = str1.charAt(i) + dp[i+1][j];
                }
                else{
                    char ch1 = str1.charAt(i);
                    char ch2 = str2.charAt(j);
                    if(ch1 == ch2){
                        dp[i][j] = dp[i+1][j+1]; // Since we need not remove character since it is already equal.
                    }
                    else{
                        dp[i][j] = Math.min(str1.charAt(i)+dp[i+1][j], str2.charAt(j)+dp[i][j+1]);
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println("Minimum ASCII delete sum of two strings: "+minimumASCIIDeleteSum(str1,str2));
    }
}
