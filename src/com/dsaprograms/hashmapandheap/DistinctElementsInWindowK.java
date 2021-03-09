package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
Count Distinct Elements In Every Window Of Size K
1. You are given an array(arr) of integers and a number K.
2. You have to find the count of distinct numbers in all windows of size k.
Sample Input
7
1 2 1 3 4 2 3
4
Sample Output
3 4 4 3
*/
public class DistinctElementsInWindowK {
    public static ArrayList<Integer> distinctElementsInWindowK(int [] array, int k){
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k-1;i++){ //for window of size 4 only add 0,1,2 (3 elements)
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }

        for(int release = 0, i = k-1;i<array.length;i++,release++){
            map.put(array[i],map.getOrDefault(array[i],0)+1); // Acquire
            result.add(map.size());// Work
            // Release
            int frequency = map.get(array[release]);
            if(frequency == 1){
                map.remove(array[release]);
            }
            else{
                map.put(array[release], frequency-1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[sc.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        ArrayList<Integer> result  = distinctElementsInWindowK(array,k);
        System.out.println(result);
    }
}
