package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
LeetCode:1318. Minimum Flips to Make a OR b Equal to c
Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ).
(bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
Example 1:
Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
Example 2:
Input: a = 4, b = 2, c = 7
Output: 1
Example 3:
Input: a = 1, b = 2, c = 3
Output: 0
 */
public class LeetCode1318MinimumFlips {
    public static int minFlips(int a, int b, int c) {
        int count = 0;
        for(int i=0;i<32;i++){
            boolean ithBitOfA = false;
            boolean ithBitOfB = false;
            boolean ithBitOfC = false;

            if((a & (1 << i))!=0){ // Not equal to zero: Bit is set
                ithBitOfA = true;
            }
            if((b & (1 << i))!=0){ // Not equal to zero: Bit is set
                ithBitOfB = true;
            }
            if((c & (1 << i))!=0){ // Not equal to zero: Bit is set
                ithBitOfC = true;
            }

            if(ithBitOfC == false){ // That means its 0
                if(ithBitOfA==true && ithBitOfB==true){
                    count+=2;
                }
                else if(ithBitOfA==true || ithBitOfB==true) // If either one of them is set.
                {
                    count++;
                }
            }
            else{ // true
                if(ithBitOfA==false && ithBitOfB==false){
                    count++; // We can set only 1 bit since minimum is required.
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int count = minFlips( a, b, c);
        System.out.println(count);
    }
}
