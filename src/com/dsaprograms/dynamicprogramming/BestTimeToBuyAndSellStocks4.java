package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
Best Time to Buy and Sell Stocks with Cool down - Infinite Transaction.
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions with cooldown of 1 day.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
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
Sample Output
19
 */
public class BestTimeToBuyAndSellStocks4 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int [] prices = new int[n];
        for(int i=0;i<prices.length;i++){
            prices[i] = sc.nextInt();
        }
        int oldBuyStockProfit = -prices[0];
        int oldSellStockProfit = 0;
        int oldCoolDown = 0;
        for(int i=0;i<prices.length;i++){
            int newBuyStockProfit = 0;
            int newSellStockProfit = 0;
            int newCoolDown = 0;
            // Calculate newBuyStockProfit
            if(oldCoolDown - prices[i] > oldBuyStockProfit){
                newBuyStockProfit = oldCoolDown - prices[i];
            }else{
                newBuyStockProfit = oldBuyStockProfit;
            }
            // Calculate newSellStockProfit
            if(oldBuyStockProfit + prices[i] > oldSellStockProfit){
                newSellStockProfit = oldBuyStockProfit + prices[i];
            } else{
                newSellStockProfit = oldSellStockProfit;
            }
            //Calculate newCoolDown
            if(oldSellStockProfit > oldCoolDown){
                newCoolDown = oldSellStockProfit;
            } else{
                newCoolDown = oldCoolDown;
            }
            // Update
            oldBuyStockProfit = newBuyStockProfit;
            oldSellStockProfit = newSellStockProfit;
            oldCoolDown = newCoolDown;
        }

        System.out.println(oldSellStockProfit);
    }
}
