package com.dsaprograms.hashmapandheap;
import java.util.HashSet;
import java.util.Scanner;
/*
Pairs with equal sum
1. You are given an array(arr) of distinct integers.
2. You have to find if there are two pairs(A, B) and (C, D) present in the given array which satisfies the condition A+B = C+D.
Sample Input:
8
1 2 998 72 87576 21 45 -1
Sample Output:

 */
public class PairsWithEqualSum {
    public static boolean getPairs(int [] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int key = nums[i]+nums[j];
                if(set.contains(key)){
                    return true;
                }
                else{
                    set.add(key);
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Pairs with equal sum: "+getPairs(nums));
    }
}
