package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Longest Bitonic Subsequence based on longest increasing subsequence program.
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest bitonic subsequence of array.
Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.
Sample Input
10
10
22
9
33
21
50
41
60
80
1
Sample Output
7
 */
public class LongestBitonicSubsequence {
    public static int getBitonicSubsequence(int []nums){
        /*
        We can solve by finding longest increasing subsequence + longest decreasing subsequence.
        */
        int [] longestIncSubsequence = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(longestIncSubsequence[j]>max){
                        max = longestIncSubsequence[j];
                    }
                }
            }
            longestIncSubsequence[i] = max + 1;
        }

        int [] longestDecSubsequence = new int[nums.length];
        for(int i = nums.length-1;i>=0;i--){
            int max = 0;
            for(int j = nums.length-1;j>i;j--){
                if(nums[i]>nums[j]){
                    if(longestDecSubsequence[j]>max){
                        max = longestDecSubsequence[j];
                    }
                }
            }
            longestDecSubsequence[i] = max + 1;
        }

        int maxLength = 0;
        for(int i=0;i<longestIncSubsequence.length;i++){
            if(longestIncSubsequence[i] + longestDecSubsequence[i] - 1 > maxLength){ // -1 because one common element is included in both
                maxLength = longestIncSubsequence[i]+longestDecSubsequence[i]-1;
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Length of longest bitonic subsequence: "+ getBitonicSubsequence(nums));
    }
}
