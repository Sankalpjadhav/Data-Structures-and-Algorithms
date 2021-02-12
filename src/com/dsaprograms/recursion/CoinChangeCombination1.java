package com.dsaprograms.recursion;
import java.util.Scanner;
/*
Coin Change Problem - Recursion | Coin Change Combination - 1
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amountt".
4. You are required to calculate and print the combinations of the n coins (non-duplicate) using
     which the amount "amt" can be paid.
Sample Input
5
2
3
5
6
7
12
Sample Output
2 3 7
5 7
 */
public class CoinChangeCombination1 {
    public static void printCombinations(int index, int [] coins, int amountSoFar, int amount, String combinationSoFar)
    {
        if(index==coins.length){
            if(amountSoFar==amount){
                System.out.println(combinationSoFar);
            }
            return;
        }
        printCombinations(index+1, coins, amountSoFar+coins[index],amount, combinationSoFar+coins[index]+" ");
        printCombinations(index+1, coins, amountSoFar, amount, combinationSoFar);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        printCombinations(0, coins, 0, amount, ""); // Duplicacy of coin not allowed.
    }
}
