package com.dsaprograms.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class TargetSumPair {
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        ArrayList<ArrayList<Integer>> result = targetSumPairs(arr,target);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> targetSumPairs(int [] arr, int  target){
        int left=0;
        int right=arr.length-1;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(left<right){
            int a=arr[left];
            int b=arr[right];
            if(a+b<target){
                left++;
            }
            else if(a+b>target){
                right--;
            }
            else{
                ArrayList<Integer> sum = new ArrayList<>();
                sum.add(arr[left]);
                sum.add(arr[right]);
                result.add(sum);
                left++;
                right--;
            }
        }
        return result;
    }
}
