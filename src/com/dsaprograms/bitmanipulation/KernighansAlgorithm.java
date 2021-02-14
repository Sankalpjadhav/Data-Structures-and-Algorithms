package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
Kernighan's Algorithm | Count Set Bits in an Integer
Concept based on right most set bit mask program.
1. You are given a number n.
2. You have to count the number of set bits in the given number.
Sample Input
58
Sample Output
Number of set bits are: 4
 */
public class KernighansAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        int number = sc.nextInt();
        while(number>0){
            int rightMostSetBit = (number & -number);
            number -= rightMostSetBit;
            counter++;
        }
        System.out.println("Number of set bits are: "+counter);
    }
}
