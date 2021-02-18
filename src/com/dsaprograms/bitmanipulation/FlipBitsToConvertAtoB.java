package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
1. You are given two numbers A and B.
2. You have to print the count of bits needed to be flipped to convert 'A' to 'B'.
Sample Input
57
76
Sample Output
5
 */
public class FlipBitsToConvertAtoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int countBits = 0;
        /*
        Example:
        A: 111001
        B: 101010
      A^B: 010011 - That means we require 3 flips of bits.
         */
        int ans = a ^ b; // This will create a new number: It contains 1 if there is change in bits of two numbers.
        // Apply Kernighan's Algorithm to count number of 1's
        while(ans!=0){
            int rightMostSetBit = ans & (-ans);
            ans -= rightMostSetBit;
            countBits++;
        }

        System.out.println("Number of flips required to convert A to B is : "+countBits);
    }
}
