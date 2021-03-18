package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode: 454. 4Sum II
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
Example:
Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
Output:
2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class LeetCode454FourSum2 {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int target = 0;
        for(int elem1:A){
            for(int elem2:B){
                map.put(elem1+elem2,map.getOrDefault(elem1+elem2,0)+1);
            }
        }

        for(int elem1:C){
            for(int elem2:D){
                count += map.getOrDefault(target-(elem1+elem2),0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] A = new int[n];
        int [] B = new int[n];
        int [] C = new int[n];
        int [] D = new int[n];

        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            B[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            C[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            D[i] = sc.nextInt();
        }

        System.out.println("Count of tuples: "+fourSumCount(A, B, C, D));
    }
}
