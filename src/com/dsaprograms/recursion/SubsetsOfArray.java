package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.Scanner;
public class SubsetsOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> result = getSubsets(arr);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(int [] arr){
        if(arr.length==0){
            ArrayList<ArrayList<Integer>> base = new ArrayList<ArrayList<Integer>>();
            base.add(new ArrayList<Integer>());
            return base;
        }
        int first = arr[0];
        int [] remaining = getRemaining(arr);
        ArrayList<ArrayList<Integer>> remainingResult = getSubsets(remaining);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Without including first.
        for(ArrayList<Integer> sub:remainingResult){
            result.add(new ArrayList<>(sub));
        }
        // With including first.
        for(ArrayList<Integer> sub:remainingResult){
            sub.add(0,first);
            result.add(new ArrayList<>(sub));
        }
        return result;
    }
    public static int [] getRemaining(int [] arr){
        int [] result = new int [arr.length-1];
        int k=0;
        for(int i=1;i<arr.length;i++){
            result[k++] = arr[i];
        }
        return result;
    }
}
