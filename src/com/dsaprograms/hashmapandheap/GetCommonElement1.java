package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Input:
Array1: 1 1 2 3 2 2 5
Array2: 5 4 1 1 2 1 2
Output:
5 1 2
 */
public class GetCommonElement1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int [] array1 = new int[n1];
        int n2 = sc.nextInt();
        int [] array2 = new int[n2];
        for(int i=0;i<array1.length;i++){
            array1[i] = sc.nextInt();
        }
        for(int j=0;j<array2.length;j++){
            array2[j] = sc.nextInt();
        }

        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int element: array1){
            if(!map.containsKey(element)){
                map.put(element, true);
            }
        }

        for(int element: array2){
            if(map.containsKey(element)){
                System.out.print(element+" ");
                map.remove(element);
            }
        }
    }
}
