package com.dsaprograms.bitmanipulation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
Minimum XOR Pairs
1. You are given an array of distinct integers.
2. You have to print all pairs of integers in the array whose XOR value is minimum.
Sample Input
4
2
0
5
7
Sample Output
0, 2
5, 7
 */
public class MinimumXORPairs {
    public static void minimumXORPairs(int [] array){
        ArrayList<String> result = new ArrayList<String>();
        Arrays.sort(array);
        int minimum = Integer.MAX_VALUE;
        for(int i=0;i<array.length-1;i++){
            int min = array[i] ^ array[i+1];
            if(min < minimum){
                minimum = min;
                result = new ArrayList<String>();
                result.add(array[i]+", "+array[i+1]);
            }
            else if(min == minimum){
                result.add(array[i]+", "+array[i+1]);
            }
        }
        for(String pairs: result){
            System.out.println(pairs);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        minimumXORPairs(array);
    }
}
