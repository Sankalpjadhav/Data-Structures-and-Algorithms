package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
Quadruple sum : Method 2
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
public class QuadrupleSumMethod2 {
    public static ArrayList<ArrayList<Integer>> quadrupleSum(int [] nums, int target, int n){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                int startIndex = j+1;
                int endIndex = n-1;
                while(startIndex < endIndex){
                    int sum = nums[i] + nums[j] + nums[startIndex] + nums[endIndex];
                    if(sum > target){
                        endIndex--;
                    }
                    else if(sum < target){
                        startIndex++;
                    }
                    else{
                        result.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[startIndex], nums[endIndex])));
                        startIndex++;
                        endIndex--;
                        // To not include duplicates
                        while(nums[startIndex]==nums[startIndex-1]) startIndex++;
                        while(nums[endIndex]==nums[endIndex-1]) endIndex--;;
                    }
                }
            }
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
        System.out.println("Quadruple sum: "+quadrupleSum(nums, target, n));
    }
}
