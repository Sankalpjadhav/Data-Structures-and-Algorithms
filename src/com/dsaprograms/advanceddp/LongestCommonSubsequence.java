package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 1143. Longest Common Subsequence
https://leetcode.com/problems/longest-common-subsequence/
longestCommonSubsequence(s1,s2) = longestCommonSubsequence(c1(r1),c2(r2))
eg:
s1= abcd
then, c1=a and r1=bcd ... similarly for s2 => c2(r2)
Therefore, longestCommonSubsequence(s1,s2) = longestCommonSubsequence(c1(r1),c2(r2))
It depends on setOfSubsequences(c1(r1)) * setOfSubsequences(c2(r2)) - (1)

Also subsequences(abc) = [_]subsequences(bc)
                         [a]subsequences(bc)
Therefore (1) can be written as
[_]setOfSubsequences(r1)  -       - [_]setOfSubsequences(r2)
                           |  *  |
[c1]setOfSubsequences(r1) -       - [c2]setOfSubsequences(r2)

*****(2)*****
[_]setOfSubsequences(r1) * [_]setOfSubsequences(r2) - (3)
[_]setOfSubsequences(r1) * [c2]setOfSubsequences(r2) - (4)
[c1]setOfSubsequences(r1) * [_]setOfSubsequences(r2) - (5)
[c1]setOfSubsequences(r1) * [c2]setOfSubsequences(r2) - (6)

Eg:
longestCommonSubsequence(abc,aeb) = setOfSubsequences(abc) * setOfSubsequences(aeb)
from (2)
setOfSubsequences(bc) * setOfSubsequences(eb)
setOfSubsequences(bc) * [a]setOfSubsequences(eb)
[a]setOfSubsequences(bc) * setOfSubsequences(eb)
[a]setOfSubsequences(bc) * [a]setOfSubsequences(eb)

from   (3)  (4)  (5)  (6)
if c1==c2
only (6) needs to be consider since longest common subsequence is possible whenever we have c1==c2 and subsequence is larger.
longestCommonSubsequence(s1,s2) = (3) + 1

<*>longestCommonSubsequence(s1,s2) = longestCommonSubsequence(r1,r2) + 1

if c1!=c2
(6) will be ruled out since the longest common subsequences start with c1 in (String1) and with c2 in (String2).

<*>longestCommonSubsequence(s1,s2) = Math.max(longestCommonSubsequence(s1,r2), longestCommonSubsequence(s2,r1))

{
longestCommonSubsequence(s2,r2) = longestCommonSubsequence(s2) * longestCommonSubsequence(r1)
Therefore we can write longestCommonSubsequence(s2) = [_]setOfSubsequences(r1)
                                                      [c2]setOfSubsequences(r1)             Which is (3) and (4)
                       longestCommonSubsequence(r1) = [_]setOfSubsequences(r1)              Which is (5)
Similarly longestCommonSubsequence(s1,r2)
                       longestCommonSubsequence(s2) = [_]setOfSubsequences(r2)
                                                      [c1]setOfSubsequences(r2)
                       longestCommonSubsequence(r2) = [_]setOfSubsequences(r2)

}
 */
public class LongestCommonSubsequence {
    public static void lengthOfLongestCommonSubsequence(String str1, String str2){
        int [][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=dp.length-2;i>=0;i--){ // Not last spots because it is 0
            for(int j=dp[0].length-2;j>=0;j--){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        System.out.println("Length of longest common subsequence: "+dp[0][0]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        lengthOfLongestCommonSubsequence(str1, str2);
    }
}
