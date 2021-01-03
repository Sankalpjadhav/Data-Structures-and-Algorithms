package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
LeetCode 123. Best Time to Buy and Sell Stock III
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
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
30

 */
// Not optimal Approach
public class BestTimeToBuyAndSellStocks5 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int [] prices = new int[n];
        for(int i=0;i<prices.length;i++){
            prices[i] = sc.nextInt();
        }
        // Travel from left to right
        int minSoFar = prices[0];
        int[] maxProfitUptoTodaySell = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            }
            int maxProfitUptoToday = prices[i] - minSoFar;
            if (maxProfitUptoToday > maxProfitUptoTodaySell[i - 1]) {
                maxProfitUptoTodaySell[i] = maxProfitUptoToday;
            } else {
                maxProfitUptoTodaySell[i] = maxProfitUptoTodaySell[i - 1];
            }
        }
        // Travel from right to left
        int maxSoFar = prices[prices.length - 1];
        int[] maxProfitUptoTodayBuy = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > maxSoFar) {
                maxSoFar = prices[i];
            }
            int maxProfitAfterToday = maxSoFar - prices[i];
            if (maxProfitAfterToday > maxProfitUptoTodayBuy[i + 1]) {
                maxProfitUptoTodayBuy[i] = maxProfitAfterToday;
            } else {
                maxProfitUptoTodayBuy[i] = maxProfitUptoTodayBuy[i + 1];
            }
        }

        int totalProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (maxProfitUptoTodaySell[i] + maxProfitUptoTodayBuy[i] > totalProfit) {
                totalProfit = maxProfitUptoTodaySell[i] + maxProfitUptoTodayBuy[i];
            }
        }

        System.out.println(totalProfit);
        
    }
}
