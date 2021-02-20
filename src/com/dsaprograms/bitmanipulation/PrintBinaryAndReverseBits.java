package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
LeetCode:190 Reverse Bits
1. You are given a number.
2. You have to print its binary representation.
3. You also have to reverse the bits of n and print the number obtained after reversing the bits.

Sample Input
11
Sample Output
1011
Reverse number: 13
 */
public class PrintBinaryAndReverseBits {
    public static void printBinaryAndReverseNumber(int number){
        int reverseNumber = 0;
        int j=0;
        boolean isSetBitEncountered = false;
        for(int i=31;i>=0;i--){
            int ithMask = (1<<i);
            if(isSetBitEncountered) {
                if ((number & ithMask) != 0) {
                    System.out.print(1);
                    int jthMask = (1<<j);
                    reverseNumber |= jthMask;
                } else {
                    System.out.print(0);
                }
                j++;
            }
            else{
                if ((number & ithMask) != 0) {
                    isSetBitEncountered = true;
                    System.out.print(1);
                    int jthMask = (1<<j);
                    reverseNumber |= jthMask;
                    j++;
                } else {
                    // Do nothing since it is 0
                }
            }
        }
        System.out.println();
        System.out.println("Reverse number: "+reverseNumber);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        printBinaryAndReverseNumber(number);
    }
}
