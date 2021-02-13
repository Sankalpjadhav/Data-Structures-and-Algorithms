package com.dsaprograms.recursion;
import java.util.Scanner;
/*

Coin Change Problem - Recursion | Coin Change Combination - 2
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amount".
4. You are required to calculate and print the combinations of the n coins (Duplicacy allowed) using
     which the amount "amount" can be paid.
Sample Input
5
2
3
5
6
7
12
Sample Output
2 2 2 2 2 2
2 2 2 3 3
2 2 2 6
2 2 3 5
2 3 7
2 5 5
3 3 3 3
3 3 6
5 7
6 6
 */
public class CoinChangeCombination2 {
    public static void printCombinations(int index, int [] coins, int amountSoFar, int totalAmount, String combinationSoFar){
        if(index==coins.length){
            if(amountSoFar==totalAmount){
                System.out.println(combinationSoFar);
            }
            return;
        }
        for(int i=totalAmount/coins[index];i>=1;i--){ // Coins taking part.
            String combinations = "";
            for(int j=0;j<i;j++){
                combinations += coins[index]+" ";
            }
            printCombinations(index+1, coins, amountSoFar+coins[index]*i, totalAmount, combinationSoFar+combinations);
        }
        printCombinations(index+1, coins, amountSoFar, totalAmount, combinationSoFar); // Particular coin not taking part.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        printCombinations(0, coins, 0, amount, ""); // Duplicacy of coin is allowed.
    }
}
