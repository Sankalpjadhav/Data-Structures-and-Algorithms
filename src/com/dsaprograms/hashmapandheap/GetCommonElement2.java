package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to find the intersection of a1 and a2. To get an idea check the example below:

if a1 -> 1 1 2 2 2 3 5
and a2 -> 1 1 1 2 2 4 5
intersection is -> 1 1 2 2 5

Note -> Don't assume the arrays to be sorted.
 */
public class GetCommonElement2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int [] array1 = new int[n1];
        for(int i=0;i<array1.length;i++){
            array1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int [] array2 = new int[n2];
        for(int j=0;j<array2.length;j++){
            array2[j] = sc.nextInt();
        }

        System.out.println();

        // Make a frequency count map for array1.
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int element1:array1){
            if(map.containsKey(element1)){
                int oldValue = map.get(element1);
                map.put(element1,oldValue+1);
            }
            else{
                map.put(element1,1);
            }
        }
        for(int element2:array2){
            if(map.containsKey(element2) && map.get(element2)>0){
                    System.out.print(element2+" ");
                    int oldValue = map.get(element2);
                    int newValue = oldValue - 1;
                    map.put(element2,newValue);
                }
            }
        }

    }

