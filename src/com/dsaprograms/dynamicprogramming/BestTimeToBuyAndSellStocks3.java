package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
Buy And Sell Stocks With Transaction Fee - Infinite Transactions Allowed.
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are give a number fee, representing the transaction fee for every transaction.
4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
A number fee
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions with transaction fee.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= fee <= 5
Sample Input
12
10
15
17
20
16
18
22
20
22
20
23
25
3
Sample Output
13
 */
public class BestTimeToBuyAndSellStocks3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] prices = new int[n];
        for(int i=0;i<prices.length;i++){
            prices[i] = sc.nextInt();
        }
        int fee = sc.nextInt();

        int oldBuyStockProfit = -prices[0];
        int oldSellStockProfit = 0;
        for(int i=0;i<prices.length;i++){
            int newBuyStockProfit = 0;
            int newSellStockProfit = 0;
            // Calculate newBuyStockProfit
            if(oldSellStockProfit - prices[i] > oldBuyStockProfit){
                newBuyStockProfit = oldSellStockProfit - prices[i];
            }else{
                newBuyStockProfit = oldBuyStockProfit;
            }
            // Calculate newSellStockProfit
            if(oldBuyStockProfit + prices[i] - fee > oldSellStockProfit){
                newSellStockProfit = oldBuyStockProfit + prices[i] - fee;
            } else{
                newSellStockProfit = oldSellStockProfit;
            }
            // Update
            oldBuyStockProfit = newBuyStockProfit;
            oldSellStockProfit = newSellStockProfit;
        }

        System.out.println(oldSellStockProfit);
    }
}
