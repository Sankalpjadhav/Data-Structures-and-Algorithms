package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
1. You are given an array of n numbers.
2. You have to find the sum of bit differences in all pairs that can be formed from n numbers.
3. Bit difference of two numbers is defined as the count of different bits at same positions in binary representations of two numbers.
Sample Input
3
1 2 3
Sample Output
8
 */
public class SumOfBitDiffAmongAllPairs {
    public static long sumOfBitDifference(int [] array){
        long sum = 0;
        for(int i=0;i<32;i++){
            int onCount = 0;
            for(int element:array){
                if((element & (1<<i))!=0){ //bit is set
                    onCount++;
                }
            }
            int offCount = array.length-onCount;
            sum += onCount * offCount * 2 ;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        long result = sumOfBitDifference(array);
        System.out.println("Sum of bit difference among all pairs: "+result);
    }
}
