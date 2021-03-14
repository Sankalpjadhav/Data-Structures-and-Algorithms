package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Longest Subarray With Equal Number Of 0s 1s And 2s
1. You are given an array that contains only 0s, 1s, and 2s.
2. You have to find length of the longest subarray with equal number of 0s, 1s, and 2s.
Sample Input
7
0 1 0 2 0 1 0
Sample Output
3
 */
public class LongSubarrayWithEqual012 {
    public static int getLongestSubarray(int [] nums){
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        int countOfZeros = 0;
        int countOfOnes = 0;
        int countOfTwos = 0;
        int delta10 = countOfOnes - countOfZeros;
        int delta21 = countOfTwos - countOfOnes;
        String key = delta10 + "#" + delta21;
        map.put(key, -1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                countOfZeros++;
            }
            else if(nums[i]==1){
                countOfOnes++;
            }
            else{
                countOfTwos++;
            }
            delta10 = countOfOnes - countOfZeros;
            delta21 = countOfTwos - countOfOnes;
            key = delta10 +"#"+ delta21;
            if(map.containsKey(key)){
                int possibleLength = i - map.get(key);
                if(possibleLength > answer){
                    answer = possibleLength;
                }
            }
            else{
                map.put(key,i);
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Longest subarray with equal 0s, 1s and 2s: "+getLongestSubarray(nums));
    }
}
