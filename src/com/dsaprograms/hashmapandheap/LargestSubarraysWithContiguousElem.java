package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*
Largest Subarray With Contiguous Elements
1. You are given an array(arr) of integers. Values may be duplicated.
2. You have to find the length of the largest subarray with contiguous elements.
Note -> The contiguous elements can be in any order(not necessarily in increasing order).
Sample Input
3
10 12 11
Sample Output
Length of largest contiguous subarray: 3
Largest subarray with contiguous elements: [10, 12, 11]
Sample Input:
15
9 2 7 5 6 23 24 22 23 19 17 16 18 39 0
Sample Output:
Length of largest contiguous subarray: 4
Largest subarray with contiguous elements: [19, 17, 16, 18]
 */
public class LargestSubarraysWithContiguousElem {
    public static ArrayList<Integer> largestContiguousSubarray(int [] array){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = 0;
        for(int i=0;i<array.length-1;i++){
            int min = array[i];
            int max = array[i];
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(array[i]);
            for(int j=i+1;j<array.length;j++){
                if(set.contains(array[j])){
                    break;
                }
                set.add(array[j]);
                min = Math.min(min,array[j]);
                max = Math.max(max,array[j]);
                if(max-min == j-i){
                    int possibleLength = j-i+1;
                    if(possibleLength > length){
                        length = possibleLength;
                        result = new ArrayList<Integer>();
                        for(int k =i;k<=j;k++){
                            result.add(array[k]);
                        }
                    }
                }
            }
        }
        System.out.println("Length of largest contiguous subarray: "+length);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        System.out.println("Largest subarray with contiguous elements: "+largestContiguousSubarray(array));
    }
}
