package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
LeetCode: 338. Counting Bits
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
Example 1:
Input: 2
Output: [0,1,1]
Example 2:
Input: 5
Output: [0,1,1,2,1,2]
Follow up:
It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
 */
public class LeetCodeCountingBits {
    public static int[] countBits(int num){
        int [] result = new int[num+1];
        for(int i=1;i<=num;i++){
            int count = 0;
            int temp = i;
            while(temp>0){
                int rightMostSetBit = temp & -temp;
                temp = temp - rightMostSetBit;
                count++;
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] result = countBits(num);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
