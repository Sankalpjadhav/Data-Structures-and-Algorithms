package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 10. Regular Expression Matching
https://leetcode.com/problems/regular-expression-matching/
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
Example 0:
Input: s = "mississippi", p = "mis*i.*p*i"
Output: true
Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:
Input: s = "aab", p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:
Input: s = "mississippi", p = "mis*is*p*."
Output: false
 */
public class LeetCode10RegularExpressionMatching {
    public static boolean isMatch(String text, String pattern){
        boolean [][] dp = new boolean[pattern.length()+1][text.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i==0){
                    dp[i][j] = false;
                }
                else if(j==0){
                    if(pattern.charAt(i-1)=='*'){ // i-1 because at 0 we assume (_) character to solve the program.
                        dp[i][j] = dp[i-2][j];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else{
                    char patternChar = pattern.charAt(i-1);
                    char textChar = text.charAt(j-1);
                    if(patternChar == textChar){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else if(patternChar == '*'){
                        dp[i][j] = dp[i-2][j];
                        char patternSecondLastCharacter = pattern.charAt(i-2);
                        if(patternSecondLastCharacter=='.' || patternSecondLastCharacter==textChar){
                            dp[i][j] = dp[i][j] || dp[i][j-1];
                        }
                    }
                    else if(patternChar == '.'){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[pattern.length()][text.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        System.out.println("Is expression matches the pattern: "+isMatch(text, pattern));
    }
}
