package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
Count of Equivalent Subarrays
1. You are given an array of integers(arr).
2. You have to find the count of equivalent subarrays.
3. A subarray is equivalent if,
   count of unique integers in the subarray = count of unique integers in the given array.
Sample Input
5
2 1 3 2 3
Sample Output
5
 */
public class CountOfEquivalentSubarrays {
    public static int getCount(int [] array){
        HashSet<Integer> set = new  HashSet<>();
        for(int element: array){
            set.add(element);
        }
        int distinctElements = set.size();
        int i=-1,j=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count =0;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            //Acquire
            while(i< array.length-1){
                flag1 = true;
                i++;
                int  element = array[i];
                map.put(element,map.getOrDefault(element,0)+1);
                if(map.size()==distinctElements){
                    count += array.length-i;
                    break;
                }
            }
            //Release and collect answer
            while (j<i){
                flag2 = true;
                j++;
                int element = array[j];
                if(map.get(element)==1){
                    map.remove(element);
                }
                else{
                    map.put(element,map.get(element)-1);
                }

                if(map.size()==distinctElements){
                    count += array.length - i;
                }
                else if(map.size()<distinctElements){
                    break;
                }
            }

            if(flag1==false && flag2==false){
                break;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        System.out.println("Count of equivalent subarrays: "+getCount(array));
    }
}
