package com.dsaprograms.advanceddp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
5. Also, you have to print the indices of items that should be selected to make maximum profit.
6. You have to print all such configurations.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.
Input:
5
15 14 10 45 30
2 5 1 3 4
8
Output:
Maximum value can be filled :85
1 3 4
 */
public class PathsOf01Knapsack {
    public static class Pairs{
        int row;
        int col;
        String pathSoFar;

        public Pairs(int row, int col, String pathSoFar){
            this.row = row;
            this.col = col;
            this.pathSoFar = pathSoFar;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] weights = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int capacity = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i < dp.length; i++) { // For i=0 and j=0 it will be zero
            for(int j = 1; j < dp[0].length; j++){
                int value = values[i - 1];
                int weight = weights[i - 1];

                if(j >= weight){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Maximum value can be filled :"+dp[n][capacity]);
        Queue<Pairs> q = new ArrayDeque<>();
        q.add(new Pairs(n,capacity,""));


        while (q.size() > 0) {
            Pairs removePair = q.remove();
            if (removePair.row == 0 || removePair.col == 0) {
                System.out.println(removePair.pathSoFar);
            } else {
                int exc = dp[removePair.row - 1][removePair.col];
                int inc = removePair.col - weights[removePair.row - 1] >= 0 ? (dp[removePair.row - 1][removePair.col - weights[removePair.row - 1]] + values[removePair.row - 1]) : Integer.MIN_VALUE;

                if (dp[removePair.row][removePair.col] == inc) {
                    q.add(new Pairs(removePair.row - 1, removePair.col - weights[removePair.row - 1], weights[removePair.row - 1] + " " + removePair.pathSoFar));
                }
                if (dp[removePair.row][removePair.col] == exc) {
                    q.add(new Pairs(removePair.row - 1, removePair.col, removePair.pathSoFar));
                }
            }
        }
    }
}
