package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode: 1497. Check If Array Pairs Are Divisible by k
Given an array of integers arr of even length n and an integer k.
We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
Return True If you can find a way to do that or False otherwise.
Example 1:
Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
Output: true
Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
Example 2:
Input: arr = [1,2,3,4,5,6], k = 7
Output: true
Explanation: Pairs are (1,6),(2,5) and(3,4).
Example 3:
Input: arr = [1,2,3,4,5,6], k = 10
Output: false
Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.
Example 4:
Input: arr = [-10,10], k = 2
Output: true
Example 5:
Input: arr = [-1,1,-2,2,-3,3,-4,4], k = 3
Output: true

Approach: Maintain a remainder frequency array such that,
    Frequency of x == frequency of k-x
    Frequency of 0 -> Even
    Frequency of k/2 -> Even
 */
public class LeetCode1497PairsDivisibleByK {
    public static boolean canArrange(int[] arr, int k) {
        if(arr.length%2==1|| arr.length<=1){
            return false;
        }
        HashMap<Integer, Integer> remainderFrequencyMap = new HashMap<>();
        for(int val:arr){
            int remainder = (k + val % k)%k; // To handle negative numbers added k and took mod of entire number with k
            int oldFrequenxy = remainderFrequencyMap.getOrDefault(remainder , 0);
            remainderFrequencyMap.put(remainder , oldFrequenxy+1);
        }

        for(int val : arr){
            int remainder = (k + val % k)%k;
            if(remainder==0){
                int frequency = remainderFrequencyMap.get(remainder);
                if(frequency % 2==1){
                    return false;
                }
            }
            else if(2*remainder==k){
                int frequency = remainderFrequencyMap.get(remainder);
                if(frequency % 2==1){
                    return false;
                }
            }
            else{
                int frequency = remainderFrequencyMap.get(remainder);
                int oldFrequency = remainderFrequencyMap.getOrDefault(k - remainder,0);
                if(frequency != oldFrequency){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println("Array Pairs are Divisible by K: "+canArrange(arr,k));
    }
}
