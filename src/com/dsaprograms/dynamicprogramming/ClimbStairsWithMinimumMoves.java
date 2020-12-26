package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
public class ClimbStairsWithMinimumMoves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Integer[] dp = new Integer[n + 1]; // Integer array is used because there is a requirement, if there is not path then return null
        // In integer array by default it stores null
        dp[n] = 0; //jab path pooche hain na to 1 lenge kyunki destination to destination 1 path hota hai (keep standing and don't move).
        //Jab steps ya minimum moves poocha jae to 0 hota hai (kyunki destination to destination 0 move lagta hai)
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        System.out.println(dp[0]);
    }
}
