package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Minimum Cost To Make Two Strings Identical
1. You are given two strings S1, S2, and two numbers x and y.
2. The cost of deleting a character from S1 is x and the cost of deleting a character from S2 is y.
3. You can delete characters from both the strings.
4. You have to find the minimum cost required to make the given two strings identical.
Sample Input
sea
eat
10
7
Sample Output
17
 */
public class MinimumCostToMakeStringsEqual {
    public static int minimumCost(String str1, String str2, int cost1, int cost2){
        //Just apply longest common subsequence concept
        int [][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = 0;
                }
                else if(i==dp.length-1){
                    dp[i][j] = 0;
                }
                else if(j==dp[0].length-1){
                    dp[i][j] = 0;
                }
                else{
                    char ch1 = str1.charAt(i);
                    char ch2 = str2.charAt(j);
                    if(ch1==ch2){
                        dp[i][j] = 1 + dp[i+1][j+1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                    }
                }
            }
        }
        int str1DeletionRequired = str1.length() - dp[0][0];
        int str2DeletionRequired = str2.length() - dp[0][0];
        int cost1ForStr1 = str1DeletionRequired * cost1;
        int cost2ForStr2 = str2DeletionRequired * cost2;
        return cost1ForStr1 + cost2ForStr2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int cost1 = sc.nextInt();
        int cost2 = sc.nextInt();
        System.out.println("The minimum cost required to make the given two strings identical: "+minimumCost(str1, str2, cost1, cost2));
    }
}
