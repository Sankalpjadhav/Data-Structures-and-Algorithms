package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Combinations of Balanced Parentheses| Count brackets (Application of Catalan numbers)
1. You are given a number n, representing the number of opening brackets ( and closing brackets )
2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
e.g.
for 1, answer is 1 -> ()
for 2, answer is 2 -> ()(), (())
for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))
Sample Input
4
Sample Output
14

 */
public class CountBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pairOfOpenAndClosedBrackets = sc.nextInt();
        int [] dp = new int[pairOfOpenAndClosedBrackets+1];
        dp[0] =1;
        dp[1] =1;
        for(int i=2;i<dp.length;i++){
            int insideBracket = i-1;
            int outsideBracket = 0;
            while(insideBracket>=0){
                dp[i] += dp[outsideBracket]*dp[insideBracket];
                insideBracket--;
                outsideBracket++;
            }
        }
        System.out.println("Number of ways we can arrange brackets: "+dp[pairOfOpenAndClosedBrackets]);
    }
}
