package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.Scanner;
/*
Leetcode: 698. Partition to K Equal Sum Subsets
Similar to Partition In K Subsets problem
1. You are given an array of n distinct integers.
2. You have to divide these n integers into k non-empty subsets such that sum of integers of every
     subset is same.
3. If it is not possible to divide, then print "-1".
Sample Input
6
1
2
3
4
5
6
3
Sample Output
[1, 6] [2, 5] [3, 4]
 */
public class EqualSumSubsets {

    public static void kEqualSumSubsets(int [] array, int index, int n, int k, int [] subsetSum, int nonEmptySetSoFar, ArrayList<ArrayList<Integer>> answer){

        if (index == array.length) {
            if (nonEmptySetSoFar == k) {
                boolean flag = true;
                for(int i=0;i<subsetSum.length-1;i++){
                    if(subsetSum[i]!=subsetSum[i+1]){
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    for (ArrayList < Integer > a: answer) {
                        System.out.print(a + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for (int j = 0; j < answer.size(); j++) {
            if (answer.get(j).size() == 0) {
                answer.get(j).add(array[index]);
                subsetSum[j] += array[index];
                kEqualSumSubsets(array, index + 1, n, k, subsetSum, nonEmptySetSoFar + 1, answer);
                answer.get(j).remove(answer.get(j).size() - 1);
                subsetSum[j] -= array[index];
                break;
            } else { // Non Empty subset
                answer.get(j).add(array[index]);
                subsetSum[j] += array[index];
                kEqualSumSubsets(array, index + 1, n, k, subsetSum, nonEmptySetSoFar, answer);
                answer.get(j).remove(answer.get(j).size() - 1);
                subsetSum[j] -= array[index];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        int sum = 0;
        for(int i=0;i<array.length;i++){
            array[i] = sc.nextInt();
            sum+=array[i];
        }
        int k = sc.nextInt();
        if (k == 1) {
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println("]");
            return;
        }
        //if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
        if (k > n || sum % k != 0) {
            System.out.println("-1");
            return;
        }
        int[] subsetSum = new int[k];
        ArrayList <ArrayList< Integer >> answer = new ArrayList < > ();
        for (int i = 0; i < k; i++) {
            answer.add(new ArrayList < > ());
        }
        kEqualSumSubsets(array, 0, n, k, subsetSum, 0, answer);
    }
}
