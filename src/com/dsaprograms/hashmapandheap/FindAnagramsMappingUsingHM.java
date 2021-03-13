package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
Find Anagram Mappings
1. You are given two integer arrays(A and B), where B is an anagram of A.
2. B is an anagram of A means B is made by randomizing the order of the elements in A.
3. For every element in A, you have to print the index of that element in B.
Note -> Both arrays(A and B) are of the same length.

Sample Input
6
1 2 3 4 5 2
4 3 2 1 5 2
Sample Output
3 2 1 0 4 5
 */
public class FindAnagramsMappingUsingHM {
    private static class Pair{
        int index=0;
        ArrayList<Integer> indexes = new ArrayList<>();
    }
    public static ArrayList<Integer> findMappings(int [] arr1, int [] arr2){
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Pair> map = new HashMap<>();
        for(int i=0;i<arr2.length;i++) {
            if(map.containsKey(arr2[i])){
                Pair pair = map.get(arr2[i]);
                pair.indexes.add(i);
                map.put(arr2[i],pair);
            }
            else{
                Pair newPair = new Pair();
                newPair.indexes.add(i);
                map.put(arr2[i],newPair);
            }
        }

        for(int i=0;i<arr1.length;i++){
            // We need not check whether map contains arr1[i] since it is anagram it does contains all the elements in second array.
            Pair pair = map.get(arr1[i]);
            int index = pair.indexes.get(pair.index);
            result.add(index);
            pair.index++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr1 = new int[n];
        int [] arr2 = new int[n];
        for(int i=0;i<n;i++){
            arr1[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            arr2[i] = sc.nextInt();
        }

        System.out.println("Anagram Mappings: "+findMappings(arr1,arr2));
    }
}
