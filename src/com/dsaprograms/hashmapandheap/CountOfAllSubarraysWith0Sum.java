package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Count Of All Subarrays With Zero Sum
1. You are given an array(arr) of integers.
2. You have to find the count of all subarrays with sum 0.
Sample Input
8
15 -2 2 -8 1 7 10 23
Sample Output
3
 */
public class CountOfAllSubarraysWith0Sum {
    public static void countOfAllSubArraysWithZeroSum(int [] array ){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(sum,1); // 1 is the frequency
        for(int i=0;i<array.length;i++){
            sum += array[i];
            if(map.containsKey(sum)){
                int oldFrequency = map.get(sum);
                count += oldFrequency;
                map.put(sum,oldFrequency+1);
            }
            else{
                map.put(sum,1);
            }
        }
        System.out.println("Count Of All Subarrays With Zero Sum: "+count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        countOfAllSubArraysWithZeroSum(array);
    }
}
