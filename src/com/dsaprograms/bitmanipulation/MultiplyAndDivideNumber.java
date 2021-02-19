package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
1. You are given a number n.
2. You have to calculate the value of 7n/8 without using division and multiplication.
Sample Input
15
Sample Output
13
 */
public class MultiplyAndDivideNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /*
        2^0 : 000001
        2^1 : 000010
        2^2 : 000100
        2^3 : 001000
        2^4 : 010000
        .
        .
       Example:
         Multiplication
            57:   111001
         57<<1:  1110010 (multiplied 57 by 2^1) : 114
         57<<3:111001000 (multiplied 57 by 2^3) : 171

         Division
            10: 1010
         10>>1:  101 ( 101|0 : To the right of | represents remainder:0 ) (Divided by 2^1) : 5 (Quotient)
         10>>2:   10 ( 10|10 : To the right of | represents remainder:2 )(Divided by 2^2) : 2 (Quotient)
        */

        // To calculate (7*n)/8 : We can represent 7*n as (8*n-n)
        int answer = (((n<<3) - n)>>3);
        System.out.println(answer);
    }
}
