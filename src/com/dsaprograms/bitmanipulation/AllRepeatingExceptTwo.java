package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
All repeating except two.
1. You are given an array of numbers.
2. You have to find 2 non-repeating numbers in an array.
3. All repeating numbers are repeating even number of times.
Sample Input
6
23 27 23 17 17 37
Sample Output
27
37
 */
public class AllRepeatingExceptTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        int xXORy = 0;
        for(int i=0;i<n;i++){
            xXORy = xXORy ^ array[i];
        }
        int rightmostSetBit = xXORy & -xXORy;
        int x = 0;
        int y = 0;
        for(int i=0;i<n;i++){
            if((array[i] & rightmostSetBit) == 0){
                x = x ^ array[i];
            }
            else{ // 1
                y = y ^ array[i];
            }
        }
        System.out.println("Two unique numbers are: "+x+" "+y);
    }
}
