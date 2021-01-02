package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
Buy And Sell Stocks - One Transaction Allowed.
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
Sample Input
9
11
6
7
19
4
1
6
18
4
Sample Output
17


 */
public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        int leastPriceSoFar = Integer.MAX_VALUE;
        int overallProfit = 0;
        int profitSoFar = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<leastPriceSoFar){
                leastPriceSoFar = prices[i];
            }
            profitSoFar = prices[i] - leastPriceSoFar;
            if(profitSoFar>overallProfit){
                overallProfit = profitSoFar;
            }
        }
        System.out.println("Maximum profit that can be earned is: "+overallProfit);
    }
}
