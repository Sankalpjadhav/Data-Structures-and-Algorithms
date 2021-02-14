package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
1. You are given a number n.
2. You have to print the right-most set bit mask.
Sample Input
58
Sample Output
Decimal representation : 2
Binary representation : 10
 */
public class RightMostSetBitMask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int twosCompliment = (~number+1);
        int rightMostSetBitMask = (number & twosCompliment);
        // Or we can find 2's compliment of a given number x : by -x
        System.out.println("Decimal representation : "+rightMostSetBitMask);
        System.out.println("Binary representation : "+Integer.toBinaryString(rightMostSetBitMask));
    }
}
