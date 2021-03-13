package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Count Of Subarrays With Equal Number Of Zeroes And Ones
1. You are given an array that contains only 0s and 1s.
2. You have to find the count of subarrays with equal number of 0s and 1s.
Sample Input
6
0 1 1 0 1 1
Sample Output
4
 */
public class CountOfSubarraysWithEqual01 {
    public static int getCount(int [] nums){
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int sum = 0;
        frequency.put(sum,1); // 1 represent number of times we got sum=0
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum+=-1;
            }else{
                sum+=1;
            }

            if(frequency.containsKey(sum)){
                count +=  frequency.get(sum);
                frequency.put(sum,frequency.get(sum)+1);
            }else{
                frequency.put(sum,1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Count Of Subarrays With Equal Number Of Zeroes And Ones: "+getCount(nums));
    }
}
