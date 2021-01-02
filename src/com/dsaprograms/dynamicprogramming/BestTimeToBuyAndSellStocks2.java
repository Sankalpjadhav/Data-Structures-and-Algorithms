package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
Buy And Sell Stocks - Infinite Transactions Allowed
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions.
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
public class BestTimeToBuyAndSellStocks2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] prices = new int[n];
        for(int i=0;i<prices.length;i++){
            prices[i] = sc.nextInt();
        }
        int buyTime = 0;
        int sellTime = 0;
        int totalProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=prices[i-1]){
                sellTime++;
            }
            else{
                totalProfit += (prices[sellTime]-prices[buyTime]);
                buyTime = sellTime = i;
            }
        }
        // We are calculating profit when there is sudden dip in  the graph (prices[i]<prices[i-1]).
        // We need to handle the case when we have increasing slope at the end.
        totalProfit += (prices[sellTime]-prices[buyTime]);
        System.out.println("Total profit earned is "+totalProfit);
    }
}
