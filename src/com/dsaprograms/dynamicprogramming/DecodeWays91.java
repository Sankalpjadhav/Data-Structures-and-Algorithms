package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
91. Decode Ways
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.
The answer is guaranteed to fit in a 32-bit integer.
Example 1:
Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:
Input: s = "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int [] dp = new int[str.length()];
        dp[0]=1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1)=='0' && str.charAt(i)=='0'){
                dp[i]=0;
            }
            else if(str.charAt(i-1)=='0' && str.charAt(i)!='0'){
                dp[i]= dp[i-1];
            }
            else if(str.charAt(i-1)!='0' && str.charAt(i)=='0'){
                if(Integer.parseInt(str.substring(i-1,i+1))<=26){
                    dp[i]=i>=2?dp[i-2]:0;
                }
                else{
                    dp[i]=0;
                }
            }
            else{ //str.charAt(i-1)!='0' && str.charAt(i)!='0'
                if(Integer.parseInt(str.substring(i-1,i+1))<=26){
                    dp[i] = dp[i-1] + (i>=2 ?dp[i-2]:1);
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
        }
        System.out.println(dp[str.length()-1]);
    }
}
