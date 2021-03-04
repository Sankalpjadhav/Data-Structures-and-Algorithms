package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 877. Stone Game
Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.
This continues until there are no more piles left, at which point the person with the most stones wins.
Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
Example 1:
Input: piles = [5,3,4,5]
Output: true
Explanation:
Alex starts first, and can only take the first 5 or the last 5.
Say he takes the first 5, so that the row becomes [3, 4, 5].
If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 */
public class LeetCode877StoneGame {
    public static boolean stoneGame(int[] piles) {
        int [][] dp = new int[piles.length][piles.length];
        int alexScore = 0; // Actually not required
        int LeeScore = 0; // Actually not required
        for(int gap=0;gap<dp.length;gap++){
            for(int i=0,j=gap;j<piles.length;j++,i++){
                if(gap==0){
                    dp[i][j] = piles[i];
                }
                else if(gap==1){
                    dp[i][j] = Math.max(piles[i],piles[j]);
                }
                else{
                    int value1 = piles[i] + Math.min(dp[i+2][j],dp[i+1][j-1]);
                    int value2 = piles[j] + Math.min(dp[i+1][j-1],dp[i][j-2]);

                    if(value1 > value2){
                        //alexScore = value1; // Make alex win
                        dp[i][j] = value1;
                    }
                    else{
                        //alexScore = value2; // Make alex win
                        dp[i][j] = value2;
                    }
                }
            }
        }
        return dp[0][dp.length-1]>0;
        // or just return true
        //return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] piles = new int[n];
        for(int i=0;i<n;i++){
            piles[i] = sc.nextInt();
        }
        System.out.println("Does Alex win?  "+stoneGame(piles));
    }
}
