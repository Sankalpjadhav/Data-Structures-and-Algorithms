package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
1. You are given two numbers A and B.
2. You are given two more numbers left and right, representing a range [left,right].
3. You have to set bits in B which are set in A lying in the above mentioned range.
4. Print the updated number B.
Sample Input
10
13
2
3
Sample Output
15
 */
public class CopySetBitsInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int left = sc.nextInt();
        int right = sc.nextInt();
        /*
            Example:
            Let A: 10101010101
                B: 10010011001
                left: 3
                right: 7
            ------------------------
                A: 1010[10101]01 -> For this whichever bits are set, set it for B too.
                B: 1001[00110]01
            ------------------------
           Result: 1001[10111]01

          Solution:
               1: 00000000001
               1<<(right-left+1): 00000100000
               mask - 1: 00000011111
               mask << (left-1): 00001111100
               mask & a: 0000[10101]00
               mask | b :
                         00001010100
                         10010011001
                      ----------------
                  Result:10011011101
        */
        int mask = (1<<(right-left+1));
        mask = mask - 1;
        mask =  (mask << (left-1));
        mask = (mask & a);
        b |= mask;
        System.out.println(b);
    }
}
