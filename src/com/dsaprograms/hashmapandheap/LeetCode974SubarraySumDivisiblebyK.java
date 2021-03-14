package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode: 974. Subarray Sums Divisible by K
In leetcode they have just asked the count of all the subarrays. Actually its easy to find count. But here I have also found out the subarrays.
https://leetcode.com/problems/subarray-sums-divisible-by-k/
Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
Example 1:
Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

For this program:
Sample input:
6
4 5 0 -2 -3 1
5
Sample output:
Subarrays with sum divisble by K: [[5], [5, 0], [0], [5, 0, -2, -3], [0, -2, -3], [-2, -3], [4, 5, 0, -2, -3, 1]]
 */
public class LeetCode974SubarraySumDivisiblebyK {
    public static class Pair{
        int count;
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static ArrayList<ArrayList<Integer>> subarrayDivisbleByK(int [] nums, int k){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int sum=0;
        int remainder = 0;
        HashMap<Integer, Pair> map = new HashMap<>();
        Pair pair = new Pair();
        pair.count = 1;
        pair.list.add(-1);
        map.put(remainder,pair);

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            remainder = sum % k;
            if(remainder < 0){
                remainder += k;
            }

            if(map.containsKey(remainder)){
                Pair existingPair = map.get(remainder);
                for(Integer start: existingPair.list){
                    ArrayList<Integer> subarray = new ArrayList<>();
                    for(int j=start+1;j<=i;j++){
                        subarray.add(nums[j]);
                    }
                    result.add(subarray);
                }
                existingPair.count++;
                existingPair.list.add(i);
                map.put(remainder, existingPair);
            }else{
                Pair newPair = new Pair();
                newPair.count = 1;
                newPair.list.add(i);
                map.put(remainder,newPair);
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
        int k = sc.nextInt();
        System.out.println("Subarrays with sum divisble by K: "+subarrayDivisbleByK(nums, k));
    }
}
