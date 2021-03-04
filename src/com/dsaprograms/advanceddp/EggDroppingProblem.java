package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 887. Super Egg Drop
Not a efficient approach, gives TLE in leetcode.
1. You are given two integers N and K. N represents the number of eggs and K represents the number of floors in a building.
2. You have to find the minimum number of attempts you need in order to find the critical floor in the worst case while using the best strategy.
3. The critical floor is defined as the lowest floor from which you drop an egg and it doesn't break.
4. There are certain which you have to follow -
   a. All eggs are identical.
   b. An egg that survives a fall can be used again.
   c. A broken egg can't be used again.
   d. If the egg doesn't break at a certain floor, it will not break at any floor below.
   e. If the egg breaks at a certain floor, it will break at any floor above.
Sample Input
3
10
Sample Output
4
 */
public class EggDroppingProblem {
    public static int eggDrop(int eggs, int floors){
        int [][] dp = new int[eggs+1][floors+1];
        /*
            When eggs are 0 then 0
            When floors are 0 then 0
            when floors are 1 then 1
            when eggs are 1 then it depends on the floor we are on.
        */
        for(int egg=1;egg<dp.length;egg++){
            for(int floor=1;floor<dp[0].length;floor++){
                if(egg==1){
                    dp[egg][floor] = floor;
                }
                else if(floor==1){
                    dp[egg][floor] = 1;
                }
                else{
                    int minimum = Integer.MAX_VALUE;
                    for(int currentRowJ=floor-1,previousRowJ=0;currentRowJ>=0;currentRowJ--,previousRowJ++){
                        int value = Math.max(dp[egg-1][previousRowJ], dp[egg][currentRowJ]);
                        if(value < minimum){
                            minimum = value;
                        }
                    }
                    dp[egg][floor] = minimum + 1;
                }
            }
        }
        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int eggs = sc.nextInt();
        int floors = sc.nextInt();
        System.out.println("The minimum number of attempts you need in order to find the critical floor in the worst case while using the best strategy: "+eggDrop(eggs,floors));
    }
}
