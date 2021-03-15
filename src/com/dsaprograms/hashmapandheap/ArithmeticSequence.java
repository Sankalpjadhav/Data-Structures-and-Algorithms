package com.dsaprograms.hashmapandheap;
import java.util.HashSet;
import java.util.Scanner;
/*
Check Arithmetic Sequence
1. You are given an array(arr) of integers.
2. You have to find if the elements of the given array can be arranged to form an arithmetic progression.
3. Arithmetic progression is defined as a sequence of numbers where the difference between any two consecutive numbers is the same.
Note -> Try to solve this in linear time complexity.
Sample Input
3
3 5 1
Sample Output
true
 */
public class ArithmeticSequence {
    public static boolean checkAP(int [] nums){
        if(nums.length<=1){
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int val:nums){
            min = Math.min(min,val);
            max = Math.max(max,val);
            set.add(val);
        }
        // An = Ao + (n-1)*d ;
        int difference = (max - min)/ nums.length-1 ;
        for(int i=0;i<nums.length;i++){
            int val = min+(i*difference);
            if(!set.contains(val)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Arithmetic sequence: "+checkAP(nums));
    }
}
