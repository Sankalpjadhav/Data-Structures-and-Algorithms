package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/*
LeetCode:47. Permutations II(Containing duplicates)
https://leetcode.com/problems/permutations-ii/
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class LeetCodePermutations2 {
    public static void getPermutations(int currentState, int totalState, List<List<Integer>> result, ArrayList<Integer> box, HashMap<Integer, Integer> frequencyMap){
        if(currentState > totalState ){
            result.add(new ArrayList<>(box));
            return;
        }
        for(Integer elem: frequencyMap.keySet()){
            if(frequencyMap.get(elem)>0){
                frequencyMap.put(elem, frequencyMap.get(elem)-1);
                box.add(elem);
                getPermutations(currentState+1, totalState, result, box, frequencyMap);
                box.remove(box.size()-1);
                frequencyMap.put(elem, frequencyMap.get(elem)+1);
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(frequencyMap.containsKey(nums[i])){
                frequencyMap.put(nums[i], frequencyMap.get(nums[i])+1);
            }
            else{
                frequencyMap.put(nums[i], 1);
            }
        }
        getPermutations(1, nums.length, result, new ArrayList<>(), frequencyMap);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }
}
