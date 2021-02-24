package com.dsaprograms.advanceddp;
import java.util.ArrayDeque;
import java.util.Scanner;
/*
Print all longest increasing subsequences.
1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print
    3.1) Length of "Longest Increasing Subsequence"(LIS).
    3.2) All "Longest Increasing Subsequence(s)"(LIS).
Sample Input
10
10 22 9 33 21 50 41 60 80 1
Sample Output
6
10 -> 22 -> 33 -> 41 -> 60 -> 80
10 -> 22 -> 33 -> 50 -> 60 -> 80
*/
public class PrintAllLongestIncSubseq {
    public static class Pairs{
        int index;
        int length;
        int value;
        String pathSoFar;

        Pairs(int index,int length, int value, String pathSoFar){
            this.index = index;
            this.length = length;
            this.value = value;
            this.pathSoFar = pathSoFar;
        }
    }
    public static void printAllLIS(int [] nums){
        // Time complexity to find LIS : O(n^2)
        int [] dp = new int[nums.length];
        int longestLength = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<=nums[i]){
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i]>longestLength){
                longestLength = dp[i];
            }
        }
        System.out.println("Longest increasing subsequence length: "+longestLength);
        // If there are two or more longest length value exist in dp then we need to consider all of them to print all subsequences.
        ArrayDeque<Pairs> queue = new ArrayDeque<>();
        for(int i=0;i<dp.length;i++){
            if(dp[i]==longestLength){
                queue.add(new Pairs(i, dp[i], nums[i], nums[i]+""));
            }
        }

        while(queue.size()>0){
            Pairs removedPair = queue.removeFirst();
            if(removedPair.length==1){
                System.out.println(removedPair.pathSoFar);
            }
            for(int j=0;j<removedPair.index;j++) {
                if (dp[j]==removedPair.length-1 && removedPair.value >= nums[j]){
                    queue.add(new Pairs(j, dp[j], nums[j], nums[j]+" -> "+removedPair.pathSoFar));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        printAllLIS(nums);
    }
}
