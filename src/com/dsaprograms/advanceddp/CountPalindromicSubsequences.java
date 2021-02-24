package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Count palindromic subsequences.
https://www.youtube.com/watch?v=YHSjvswCXC8&list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG&index=12
1. You are given a string str.
2. You are required to print the count of palindromic subsequences in string str.
Sample Input
ccbbgd
Sample Output
8

Approach:
We can partition our string into
[c1][MiddleString][c2]
where,
c1- First character
MiddleString- String which is palindrome
c2- Last character
Let us take str = abcd (2^4 = 16 subsequences possible)
Possible subsequences
____
___d
__c_
__cd
_b__
_b_d
_bc_
_bcd
a___
a__d
a_c_
a_cd
ab__
ab_d
abc_
abcd
From subsequence of bc we can able to get all 16 subsequences
Subsequence of bc : __
                    _c
                    b_
                    bc
a & d has 2 choices:(Total 4 choices)
1. Do not contribute
2. Contribute

Both            Only            Only            Both
a & d            a               d              a & d
do not          Contribute      Contribute      contribute
contribute
[_]__[_]        [a]__[_]        [_]__[d]        [a]__[d]
[_]_c[_]        [a]_c[_]        [_]_c[d]        [a]_c[d]
[_]b_[_]        [a]b_[_]        [_]b_[d]        [a]b_[d]
[_]bc[_]        [a]bc[_]        [_]bc[d]        [a]bc[d]

Therefore,
Subsequences(abcd) = [_]Subsequences(bc)[_] + [a]Subsequences(bc)[_] + [_]Subsequences(bc)[d] + [a]Subsequences(bc)[d]
In general:
Subsequences(str) = [_]Subsequences(middlePart)[_] + [c1]Subsequences(middlePart)[_] + [_]Subsequences(middlePart)[c2] + [c1]Subsequences(middlePart)[c2]

Subsequences([c1]middlePart) = [_]Subsequences(middlePart)[_] + [c1]Subsequences(middlePart)[_]        ->1
Subsequences(middlePart[c2]) = [_]Subsequences(middlePart)[_] + [_]Subsequences(middlePart)[c2]        ->2

We are required to find count:
Count(Subsequences(str)) = Count([_]Subsequences(middlePart)[_])                 -> Count1
                                             +
                           Count([c1]Subsequences(middlePart)[_])                -> Count2
                                             +
                           Count([_]Subsequences(middlePart)[c2])                -> Count3
                                             +
                           Count([c1]Subsequences(middlePart)[c2])               -> Count4

Therefore, Count = Count1 + Count2 + Count3 + Count4

Now we have 2 cases: c1==c2 & c1!=c2
1. c1==c2
Then Count4 = Count1 + 1
Eg: [a]bc[a]
Possible subsequences of bc
__  Not Palindrome
_c  Palindrome
b_  Palindrome
bc  Not Palindrome

Now for [a]bc[a]

[_]__[_]  Not Palindrome
[_]_c[_]  Palindrome                => 2 Palindromes
[_]b_[_]  Palindrome
[_]bc[_]  Not Palindrome

[a]__[_]  Palindrome
[a]_c[_]  Not Palindrome
[a]b_[_]  Not Palindrome
[a]bc[_]  Not Palindrome

[_]__[a]  Palindrome
[_]_c[a]  Not Palindrome
[_]b_[a]  Not Palindrome
[_]bc[a]  Not Palindrome

[a]__[a]  Palindrome
[a]_c[a]  Palindrome                => 3 Palindromes
[a]b_[a]  Palindrome
[a]bc[a]  Not Palindrome

Therefore Count4 = Count1 + 1
Count = Count1 + Count2 + Count3 + (Count 1 + 1)
      = (Count1 + Count2) + (Count1 + Count3) + 1
From 1 and 2:
Subsequences([c1]middlePart) = [_]Subsequences(middlePart)[_] + [c1]Subsequences(middlePart)[_]
Count(Subsequences([c1]middlePart))=        Count1            +               Count2
Subsequences(middlePart[c2]) = [_]Subsequences(middlePart)[_] + [_]Subsequences(middlePart)[c2]
Count(Subsequences(middlePart[c2]))=        Count1            +               Count3

Count  = Count(Subsequences([c1]middlePart)) + Count(Subsequences(middlePart[c2])) + 1

2. c1!=c2
Then Count 4 will be 0
Count = Count1 + Count2 + Count3 + 0 + Count1 - Count1
Count = (Count1 + Count2) + (Count1 + Count3) + 0 - Count1

from 1 and 2:
Subsequences([c1]middlePart) = [_]Subsequences(middlePart)[_] + [c1]Subsequences(middlePart)[_]
Count(Subsequences([c1]middlePart))=        Count1            +               Count2
Subsequences(middlePart[c2]) = [_]Subsequences(middlePart)[_] + [_]Subsequences(middlePart)[c2]
Count(Subsequences(middlePart[c2]))=        Count1            +               Count3

Therefore,
Count = Count(Subsequences([c1]middlePart)) + Count(Subsequences(middlePart[c2])) - Count([_]Subsequences(middlePart)[_])

So we have come up with
When c1==c2, Count  = Count(Subsequences([c1]middlePart)) + Count(Subsequences(middlePart[c2])) + 1
When c1!=c2, Count = Count(Subsequences([c1]middlePart)) + Count(Subsequences(middlePart[c2])) - Count([_]Subsequences(middlePart)[_])
 */
public class CountPalindromicSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[][] dp = new int[str.length()][str.length()];
        for(int g = 0; g < dp.length; g++){
            for(int i = 0, j = g; j < dp[0].length; i++, j++){
                if(g == 0){
                    dp[i][j] = 1;
                } else if(g == 1){
                    dp[i][j] = str.charAt(i) == str.charAt(j)? 3: 2;
                } else {
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
            }
        }

        System.out.println("Count of palindromic subsequences: "+dp[0][dp[0].length - 1]);
    }
}
