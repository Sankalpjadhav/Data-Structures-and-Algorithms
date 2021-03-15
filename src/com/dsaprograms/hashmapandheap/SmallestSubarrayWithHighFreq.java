package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Smallest Subarray With All Occurrences Of The Most Frequent Element
1. You are given an array(arr) of integers.
2. You have to find the element(x) with maximum frequency in the given array.
3. Also, you have to find the smallest subarray which has all occurrences of the most frequent element i.e x.
Note -> If there are two or more elements with maximum frequency and the same subarray size then print the subarray which occurs first in the given array.
Sample Input
8
4 1 1 2 2 1 3 3
Sample Output
Highest frequency element: 1
Start index and end index: 1 5
Sample input:
13
1 3 2 4 2 3 4 2 5 6 5 5 7
Sample output:
Highest frequency element: 5
Start index and end index: 8 11
 */
public class SmallestSubarrayWithHighFreq {
    public static void solution(int [] nums){
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        HashMap<Integer, Integer> startingPointMap = new HashMap<>();
        int highestFreq = 0;
        int startIndex = 0;
        int endIndex = 0;
        int length = endIndex - startIndex + 1;
        for(int i=0;i<nums.length;i++){
            if(frequencyMap.containsKey(nums[i])){
                frequencyMap.put(nums[i], frequencyMap.get(nums[i])+1);
            }else{
                frequencyMap.put(nums[i],1);
                startingPointMap.put(nums[i],i);
            }
            if(frequencyMap.get(nums[i]) > highestFreq){
                highestFreq = frequencyMap.get(nums[i]);
                startIndex = startingPointMap.get(nums[i]);
                endIndex = i;
                length = endIndex - startIndex + 1;
            }
            else if(frequencyMap.get(nums[i]) == highestFreq){
                int possibleLength = i - startingPointMap.get(nums[i]) + 1;
                if(possibleLength < length){
                    length = possibleLength;

                    highestFreq = frequencyMap.get(nums[i]);
                    startIndex = startingPointMap.get(nums[i]);
                    endIndex = i;
                    length = endIndex - startIndex + 1;
                }
            }
        }
        System.out.println("Highest frequency element: "+nums[startIndex]);
        System.out.println("Start index and end index: "+startIndex+" "+endIndex);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        solution(nums);
    }
}
