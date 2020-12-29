package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
 */
public class CountBinaryStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] zeroCount = new int[n+1]; // It represents count of appropriate binary strings(Which follows rule)of length i ending with zero.
        int [] oneCount = new int[n+1]; // It represents count of appropriate binary strings(Which follows rule)of length i ending with one.
        // zeroCount[0] = 0, oneCount[0] = 0 because there is no String with 0 length which has contains 0 or 1.
        zeroCount[1] = 1; // 0 - binary string
        oneCount[1] = 1; // 1- binary string
        for(int i=2;i<=n;i++){
            zeroCount[i] = oneCount[i-1];
            oneCount[i] = zeroCount[i-1] + oneCount[i-1];
        }
        System.out.println(zeroCount[n]+oneCount[n]);
    }
}
