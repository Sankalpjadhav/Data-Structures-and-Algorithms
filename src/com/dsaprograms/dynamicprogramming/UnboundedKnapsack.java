package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without
    overflowing it's capacity.
Note -> Each item can be taken any number of times. You are allowed to put the same item again
                  and again
 */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] values = new int[n];
        int [] weights = new int[n];
        for(int i=0;i<values.length;i++){
            values[i] = sc.nextInt();
        }
        for(int i=0;i<weights.length;i++){
            weights[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();
        int [] dp = new int[capacity+1];
        dp[0]=0;
        for(int bagCapacity=1;bagCapacity<=capacity;bagCapacity++)
        {
            int max=0;
            for(int i = 0; i<n ; i++){
                if(weights[i]<=bagCapacity){
                    int remainingBagCapacity = bagCapacity - weights[i];
                    int remainingBagValue = dp[remainingBagCapacity];
                    int totalValue = remainingBagValue + values[i];
                    if(totalValue > max){
                        max = totalValue;
                    }
                }
            }
            dp[bagCapacity]= max;
        }
        System.out.println(dp[capacity]);
    }
}
