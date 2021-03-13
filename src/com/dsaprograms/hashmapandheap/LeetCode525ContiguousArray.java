package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode: 525. Contiguous Array
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class LeetCode525ContiguousArray {
    public static int findMaxLength(int [] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum,-1);
        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum+=-1;
            }else{
                sum+=1;
            }

            if(map.containsKey(sum)){
                int possibleAns = i - map.get(sum);
                if(possibleAns > result){
                    result = possibleAns;
                }
            }else{
                map.put(sum,i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Maximum length of contiguous array with equal number of 0'c and 1's: "+findMaxLength(nums));
    }
}
