package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
All Repeating Except One
1. You are given an array of numbers.
2. All numbers occur twice in the array except one.
3. You have to find that number by traversing only once in the array and without using any extra
     space.
Sample Input
5
23 27 23 17 17
Sample Output
27
x^x = 0
x^0 = x
x^y^z = x^(y^z) = (x^y)^z
 */
public class ElementThatAppearsOnce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        int result=0;
        for (int i = 0; i < n; i++) {
            result = result ^ array[i];
        }
        System.out.println("The element which is not repeating twice is:"+result);
    }
}
