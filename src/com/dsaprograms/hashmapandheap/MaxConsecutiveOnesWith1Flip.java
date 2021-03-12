package com.dsaprograms.hashmapandheap;
import java.util.Scanner;
/*
Maximum Consecutive Ones - 1
1. You are given an array(arr) which contains only 0's and 1's.
2. You have to find the maximum number of consecutive 1's in the given array if you can flip at most one zero.
Sample Input
6
1 1 0 0 1 1
Sample Output
3
 */
public class MaxConsecutiveOnesWith1Flip {
    public static int longestConsecutiveOnes(int [] array){
        int countOfZeros = 0;
        int answer = 0;
        int j=-1;
        for(int i=0;i<array.length;i++){
            if(array[i]==0){
                countOfZeros++;
            }
            while(countOfZeros > 1){
                j++;
                if(array[j]==0){
                    countOfZeros--;
                }
            }
            int length = i - j;
            if(length > answer){
                answer = length;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        System.out.println("the maximum number of consecutive 1's in the given array if you can flip at most one zero: "+longestConsecutiveOnes(array));
    }
}
