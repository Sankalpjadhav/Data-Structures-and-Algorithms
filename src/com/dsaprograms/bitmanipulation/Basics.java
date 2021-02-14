package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
1. You are given a number n.
2. Print the number produced on setting its i-th bit.
3. Print the number produced on unsetting its j-th bit.
4. Print the number produced on toggling its k-th bit.
5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.
Sample Input
57
3
3
3
3
Sample Output
57
49
49
true
 */
public class Basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int onBit = sc.nextInt();
        int offBit = sc.nextInt();
        int toggleBit = sc.nextInt();
        int checkBit = sc.nextInt();

        int onMask = (1 << onBit);
        int offMask = ~(1 << offBit);
        int toggleMask = (1 << toggleBit);
        int checkMask = (1 << checkBit);

        System.out.println(number | onMask);
        System.out.println(number & offMask);
        System.out.println(number ^ toggleMask);
        System.out.println((number & checkMask)==0?false:true);
        // true represents on
        // false represents off
    }
}
