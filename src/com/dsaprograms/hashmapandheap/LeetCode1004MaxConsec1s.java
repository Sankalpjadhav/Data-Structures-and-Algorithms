package com.dsaprograms.hashmapandheap;
import  java.util.Scanner;
/*
LeetCode: 1004. Max Consecutive Ones III
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
Return the length of the longest (contiguous) subarray that contains only 1s.
Example 1:
Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation:
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:
Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation:
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 */
public class LeetCode1004MaxConsec1s {
    public static int longestOnes(int[] A, int k) {
        int answer = 0;
        int count=0;
        int j=-1;
        for(int i=0;i<A.length;i++){
            if(A[i]==0){
                count++;
            }

            while(count > k){
                j++;
                if(A[j]==0){
                    count--;
                }
            }

            int length = i-j;
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
        int k = sc.nextInt();
        System.out.println("The length of the longest (contiguous) subarray that contains only 1s: "+longestOnes(array,k));
    }
}
