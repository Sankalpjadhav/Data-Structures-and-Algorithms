package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
XOR of Sum of All Pairs in an Array
1. You are given an array of integers.
2. You have to find the XOR of sum of all pairs in the array.
Sample Input
5
1
5
2
1
2
Sample Output
10
 */
public class XORSumOfAllPairs {
    public static int xorSumOfAllPairsInArray(int [] array){
        int answer = 0;
        /*
        1. Sum of all pairs :
            Consider array = [a,b,c,d];
            Then sum of all pairs:
            a+a b+a c+a d+a
            a+b b+b c+b d+b
            a+c b+c c+c d+c
            a+d b+d c+d d+d
        2. When we take xor of all pairs:
            All will get cancel except a+a, b+b, c+c, d+d (Since 1^1=0 0^0=0)
            Eg: a+b ^ b+a = 0
            Therefore just calculate xor of (2a+2b+2c).
        */
        for(int element: array){
            answer = answer ^ (2 * element);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        int result = xorSumOfAllPairsInArray(array);
        System.out.println(result);
    }
}
