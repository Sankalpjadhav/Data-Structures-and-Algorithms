package com.dsaprograms.basedonsorting;
import java.util.HashMap;
import java.util.Scanner;
/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 */
public class MaximumErasureValue {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr =new int [n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int maximumErasureValue = calculateMaxValue(arr);
        System.out.println(maximumErasureValue);
    }
    static int calculateMaxValue(int [] nums){
        if(nums.length==1){
            return nums[0];
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int left=0;
        int right=0;
        int n=nums.length;
        while(right<n){
            if(map.containsKey(nums[right])){
                left=Math.max(map.get(nums[right])+1,left);
            }
            map.put(nums[right],right);
            int s=0;
            for(int i=left;i<=right;i++){
                s+=nums[i];
            }
            sum=Math.max(sum,s);
            right++;
        }
        return sum;
    }
}
