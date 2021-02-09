package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
LeetCode: 77. Combinations
https://leetcode.com/problems/combinations/
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
You may return the answer in any order.
Example 1:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:
Input: n = 1, k = 1
Output: [[1]]
 */
public class Combinations {

    public static void combinations(int start, ArrayList<Integer> tempList, List<List<Integer>> result, int n, int k){
        if(k==0){
            result.add(new ArrayList<Integer>(tempList));
            return;
        }
        for(int i=start;i<=n;i++){
            tempList.add(i);
            combinations(i+1, tempList, result, n, k-1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(1,new ArrayList<Integer>(), result, n, k);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
    }
}
