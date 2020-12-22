package com.dsaprograms.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetsOfArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> result = findAllSubsets(arr,0);
        System.out.println(result);
    }


    public static ArrayList<ArrayList<Integer>> findAllSubsets(int [] arr, int index){
        if(index==arr.length) {
            ArrayList<ArrayList<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        int first = arr[index];
        ArrayList<ArrayList<Integer>> remainingResult = findAllSubsets(arr,index+1);
        ArrayList<ArrayList<Integer>> result =new ArrayList<>();
        for(ArrayList<Integer> ad:remainingResult){
            result.add(0,new ArrayList<>(ad));
        }
        for(ArrayList<Integer> ar:remainingResult){
            ar.add(0,first);
            result.add(0,new ArrayList<>(ar));
        }
        return result;
    }
}
