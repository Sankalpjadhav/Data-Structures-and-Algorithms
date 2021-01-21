package com.dsaprograms.hashmapandheap;

import java.util.HashMap;
import java.util.Scanner;
/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<array.length;i++){
            array[i] = sc.nextInt();
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        /*
        boolean = true represents the key is the start point of the sequence.
        boolean = false represents the key is not the start point of the sequence.
        */
        // Initially consider all elements as start point
        for(int element: array){
            map.put(element, true);
        }
        // For each element see if (element - 1) is present in map.
        // If yes then mark it false.(If element-1 element is present then that element is not a starting point of the sequence.)
        for(int element: array){
            if(map.containsKey(element-1)){
                map.put(element,false);
            }
        }

        int maxSequenceLength=0;
        int maxSequenceElement=0;
        for(int element: array){
            if(map.get(element)==true){
                int temporaryLength = 1;
                int temporaryElement = element;
                while(map.containsKey(temporaryElement+temporaryLength)){
                    temporaryLength++;
                }
                if(temporaryLength > maxSequenceLength){
                    maxSequenceLength = temporaryLength;
                    maxSequenceElement = temporaryElement;
                }
            }
        }
        for(int i = 0;i<maxSequenceLength;i++) {
            System.out.print(maxSequenceElement+i+" ");
        }

    }
}
