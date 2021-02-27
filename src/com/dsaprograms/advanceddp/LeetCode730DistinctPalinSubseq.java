package com.dsaprograms.advanceddp;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode: 730. Count Different Palindromic Subsequences
Given a string S, find the number of different non-empty palindromic subsequences in S.
A subsequence of a string S is obtained by deleting 0 or more characters from S.
A sequence is palindromic if it is equal to the sequence reversed.
Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.
Example 1:
Input:
S = 'bccb'
Output: 6
Explanation:
The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
Note that 'bcb' is counted only once, even though it occurs twice.

Formula:
                                                                                prefix                                          Suffix
                                                    -> c!=c2 =>  distinctPalindromicSubsequences(c1MiddlePart) + distinctPalindromicSubsequences(MiddlePartc2) - distinctPalindromicSubsequences(MiddlePart)
distinctPalindromicSubsequences(c1MiddlePartc2) = |
                                                    -> c==c2 =>   -> a-------a (No a's in the MiddlePart)  2*distinctPalindromicSubsequences(MiddlePart) + 2
                                                               |
                                                               |        a
                                                               | -> a-------a (One 'a' in the MiddlePart) 2*distinctPalindromicSubsequences(MiddlePart) + 1
                                                               |
                                                               |      a M'a
                                                                 -> a-------a (More than one 'a' in the Middle Part) 2*distinctPalindromicSubsequences(MiddlePart) - distinctPalindromicSubsequences(M')



 */
public class LeetCode730DistinctPalinSubseq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int [] previous = new int[text.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<previous.length;i++){
            char ch = text.charAt(i);
            if(map.containsKey(ch)==false){
                previous[i] = -1;
            }
            else{
                previous[i] = map.get(ch);
            }
            map.put(ch,i);
        }
        int [] next = new int[text.length()];
        map.clear();
        for(int i=next.length-1;i>=0;i--){
            char ch = text.charAt(i);
            if(map.containsKey(ch)==false){
                next[i] = -1;
            }
            else{
                next[i] = map.get(ch);
            }
            map.put(ch,i);
        }
        int [][] dp = new int[text.length()][text.length()];
        for(int gap=0;gap<text.length();gap++){
            for(int i=0,j=gap;j<text.length();i++,j++){
                if(gap==0){
                    dp[i][j] = 1;
                }
                else if(gap==1){
                    dp[i][j] = 2;
                }
                else{
                    char startingChar = text.charAt(i);
                    char endingChar = text.charAt(j);
                    if(startingChar == endingChar){
                        int nextIndex = next[i];
                        int prevIndex = previous[j];
                        if(nextIndex < prevIndex){
                            // That means we have a middle(M') area
                            dp[i][j] = 2*dp[i+1][j-1] - dp[nextIndex+1][prevIndex-1];
                        }
                        else if(nextIndex > prevIndex){
                            // No a's
                            dp[i][j] = 2*dp[i+1][j-1] + 2;
                        }
                        else{
                            // Only single a
                            dp[i][j] = 2*dp[i+1][j-1] + 1;
                        }
                    }
                    else{
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                    }
                }
            }
        }
        System.out.println("Count of Distinct palindromic subsequences: "+ dp[0][text.length()-1]);
    }
}
