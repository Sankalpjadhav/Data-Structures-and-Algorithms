package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
Quadruple sum : Method 1 (More generic)
Time complexity: O(n^3)
Duplicate numbers are allowed.
1. You are given an array(arr) of N integers and an integer X.
2. You have to find all unique quadruplets(a,b,c,d) which satisfies this condition -
   a+b+c+d = X.
Sample Input
6
1 0 -1 0 -2 2
0
Sample Output
-2 -1 1 2
-2 0 0 2
-1 0 0 1
 */
public class QuadrupleSumMethod1 {
    public static void createResult(ArrayList<ArrayList<Integer>> result, ArrayList<ArrayList<Integer>> smallAnswer, int val){
        for(ArrayList<Integer> list:smallAnswer){
            list.add(0,val);
            result.add(list);
        }
    }
    public static ArrayList<ArrayList<Integer>> twoSum(int [] nums, int target, int startIndex, int endIndex){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(startIndex < endIndex){
            int sumPair = nums[startIndex] + nums[endIndex];
            if(sumPair > target){
                endIndex--;
            }
            else if(sumPair < target){
                startIndex++;
            }
            else{
                result.add(new ArrayList<>(Arrays.asList(nums[startIndex],nums[endIndex])));
                startIndex++;
                endIndex--;
                while(nums[startIndex]==nums[startIndex-1]) startIndex++;
                while(nums[endIndex]==nums[endIndex-1]) endIndex++;
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int [] nums, int target, int startIndex, int endIndex){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=startIndex;i<=endIndex;i++){
            if(i!=startIndex && nums[i]==nums[i-1]) continue;
            ArrayList<ArrayList<Integer>> smallAnswer = twoSum(nums, target - nums[i],i+1,endIndex);
            createResult(result,smallAnswer,nums[i]);
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> quadrupleSum(int [] nums, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int startIndex = 0;
        int endIndex = nums.length-1;
        for(int i=startIndex;i<=endIndex;i++){
            if(i!=startIndex && nums[i]==nums[i-1]) continue;
            ArrayList<ArrayList<Integer>> smallAnswer = threeSum(nums, target - nums[i],i+1,endIndex);
            createResult(result,smallAnswer,nums[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println("Quadruple sum: "+quadrupleSum(nums, target));
    }
}
