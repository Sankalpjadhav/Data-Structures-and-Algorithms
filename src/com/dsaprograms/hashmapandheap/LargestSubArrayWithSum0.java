package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Largest Subarray with 0 Sum
1. You are given an array(arr) of integers.
2. You have to find the length of the largest subarray with sum 0.
Sample Input
8
15 -2 2 -8 1 7 10 23
Sample Output
5
 */
public class LargestSubArrayWithSum0 {
    public static void largestSubArray(int [] array){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum,-1); // Imp: What if at the start itself we have a subarray which results to 0 therefore add sum=0 and index of that as -1.
        int maxLength = 0;
        for(int i=0;i<array.length;i++){
            sum += array[i];
            if(map.containsKey(sum)){
                int length = i - map.get(sum);
                if(length > maxLength){
                    maxLength = length;
                }
            }
            else{
                map.put(sum,i);
            }
        }

        System.out.println("The length of the largest subarray with sum 0: "+maxLength);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        largestSubArray(array);
    }
}
