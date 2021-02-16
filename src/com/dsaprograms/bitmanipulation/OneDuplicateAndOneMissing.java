package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
1. You are given an array of length n containing numbers from 1 to n.
2. One number is present twice in array and one is missing.
3. You have to find these two numbers.
Can you solve the problem without modifying the array?
Can you solve the problem using only constant, O(1) extra space?
Can you solve the problem with runtime complexity less than O(n2)?
Sample input:
7
1
3
4
5
1
6
2
Sample output:
Duplicate number is: 1
Missing number is: 7
 */
public class OneDuplicateAndOneMissing {
    public static void oneDuplicateAndOneMissingNumber(int [] array, int n)
    {
        int xor = 0;
        /*
            Take the xor of all the elements: duplicate elements will be 0. Since, x^x=0
            In xor variable we have xor of all other elements except the duplicate elements.
        */
        for(int i=0;i<n;i++){
            xor = xor ^ array[i];
        }
        /*
            Now from 1 to n calculate xor, then only the missing element and duplicate element will exist.
        */
        for(int i=1;i<=n;i++){
            xor = xor ^ i;
        }
        // xor variable contains xor of duplicate element and missing element.
        int rightMostSetBit = xor & -xor;
        int x = 0;
        int y = 0;
        for(int element: array){
            if((element & rightMostSetBit)==0){
                x ^= element;
            }
            else{ // 1
                y ^= element;
            }
        }
        for(int i=1;i<=n;i++){
            if((i & rightMostSetBit)==0){
                x ^= i;
            }
            else{ // 1
                y ^= i;
            }
        }
        // We need to see which is missing and duplicate number(x,y)
        for(int elem: array){
            if(elem==x){
                System.out.println("Duplicate number is: "+x);
                System.out.println("Missing number is: "+y);
                break;
            }
            else{
                System.out.println("Duplicate number is: "+y);
                System.out.println("Missing number is: "+x);
                break;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        oneDuplicateAndOneMissingNumber(array, array.length);
    }
}
