package com.dsaprograms.hashmapandheap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/*
954. Array of Doubled Pairs
Given an array of integers arr of even length, return true if and only if it is possible to reorder it such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2.
Example 1:
Input: arr = [3,1,3,6]
Output: false
Example 2:
Input: arr = [2,1,2,6]
Output: false
Example 3:
Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
Example 4:
Input: arr = [1,2,4,16,8,4]
Output: false
Best test case:
arr = [-8,-3,8,8,4,-6,-4,2,0,2,1,4,0,16,8,4]
Output: true
 */
public class LeetCode954ArrayOfDoubledPairs {
    public static boolean canReorderDoubled(int[] arr) {
        if(arr.length==0){
            return true;
        }

        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int elem:arr){
            freqMap.put(elem, freqMap.getOrDefault(elem,0)+1);
        }

        Integer [] ar = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            ar[i] = arr[i];
        }

        Arrays.sort(ar,(a, b)->{
            return Math.abs(a)-Math.abs(b);
        });

        for(Integer elem:ar){
            if(freqMap.get(elem)==0) continue;

            if(freqMap.getOrDefault(2*elem,0)==0) return false;

            freqMap.put(elem,freqMap.get(elem)-1);
            freqMap.put(2*elem,freqMap.get(2*elem)-1);
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Is it possible to reorder it such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2: "+canReorderDoubled(arr));
    }
}
