package com.dsaprograms.advanceddp;
import java.util.Arrays;
import java.util.Scanner;
/*
LeetCode Hard: 940. Distinct Subsequences II
https://leetcode.com/problems/distinct-subsequences-ii/submissions/
Given a string S, count the number of distinct, non-empty subsequences of S .
Since the result may be large, return the answer modulo 10^9 + 7.
Example 1:
Input: "abc"
Output: 7
Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
Example 2:
Input: "aba"
Output: 6
Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
Example 3:
Input: "aaa"
Output: 3
Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 */
public class LeetCode940DistinctSubsequences2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = "$"+str;
        int mod = (int)1e9 + 7; //1000000000 + 7
        int [] dp = new int[str.length()];
        int [] lastOccurence = new int[26];
        Arrays.fill(lastOccurence,-1);
        dp[0] = 1; // For empty subsequence
        for(int i=1;i<dp.length;i++){
            dp[i] = (2 * dp[i-1]) % mod;
            char ch = str.charAt(i); // If $ is not added in the string then we need to add char ch = str.charAt(i-1);
            if(lastOccurence[ch-'a']!=-1){
                dp[i] -= (dp[lastOccurence[ch-'a']-1])%mod;
            }
            lastOccurence[ch-'a'] = i;
        }
        System.out.println((dp[str.length()-1]%mod)-1); // -1 because in the question they have mentioned non-empty subsequences of String.
    }
}
/*
public int distinctSubseqII(String S) {
    S = "$"+S;
    int mod = (int)1e9 + 7;
    int n = S.length();
    int[] dp = new int[n]; //for storing the answer
    int []locc = new int[26]; // for storing the last occuring idx of a character

    Arrays.fill(locc,-1);
    dp[0] = 1;
    for(int i = 1;i<n;i++){
        char ch = S.charAt(i);
        dp[i] = (dp[i-1]*2) % mod;
        if(locc[ch-'a']!=-1){
            dp[i] = (dp[i] % mod - dp[locc[ch-'a']-1] % mod + mod) % mod;

        }
        locc[ch-'a'] = i;
    }
    return dp[n-1]-1;
    }

            why +mod is required in this line dp[i]-=(((dp[last[S[i-1]]]%mod)+mod)%mod);
            Now for example lets take mod = 5
            lets suppose dp[i-1] = 4 &  dp[i] = 6
            now since dp[i] is more than 5, we have to take mod. Now it will become 1

            now since I'm doing a subtraction
            dp[i]-=dp[i-1]  // dp[i] will become -3
            dp[i] has become negative, so I am adding mod, because technically it changes nothing in the answer! // now dp[i] will become -3+5 =2
            And because of that dp[i] has again become positive!
            we dont want dp[i] to be negative, so remember whenever there is a substraction involved in the question and a mod is involved, adding a mod becomes mandatory for us!
 */