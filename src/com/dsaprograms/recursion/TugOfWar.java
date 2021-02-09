package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.Scanner;
/*
Minimum Subset Sum Difference | Tug Of War
1. You are given an array of n integers.
2. You have to divide these n integers into 2 subsets such that the difference of sum of two subsets
     is as minimum as possible.
3. If n is even, both set will contain exactly n/2 elements. If  is odd, one set will contain (n-1)/2 and
    other set will contain (n+1)/2 elements.
3. If it is not possible to divide, then print "-1".
Sample Input
6
1
2
3
4
5
6
Sample Output
[1, 3, 6] [2, 4, 5]
 */
public class TugOfWar {
    static int minimumDifference = Integer.MAX_VALUE;
    static String result = "";
    public static void minimumSubsetSumDifference(int [] array, int index, ArrayList<Integer> set1, ArrayList<Integer> set2, int sumOfSet1, int sumOfSet2){
        if(index == array.length){
            int difference = Math.abs(sumOfSet1-sumOfSet2);
            if(difference < minimumDifference){
                minimumDifference = difference;
                result = set1+" "+set2;
            }
            return;
        }

        if(set1.size()< (array.length+1)/2){ // For Optimization purpose - If there are 4 numbers, no need to add in set 1 if it already contains 2 elements.
            set1.add(array[index]);
            minimumSubsetSumDifference(array, index+1, set1, set2, sumOfSet1+array[index], sumOfSet2);
            set1.remove(set1.size()-1);
        }
        if(set2.size()< (array.length+1)/2){ // array.length+1 handles both odd and even number of array elements.
            set2.add(array[index]);
            minimumSubsetSumDifference(array, index+1, set1, set2, sumOfSet1, sumOfSet2+array[index]);
            set2.remove(set2.size()-1);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        minimumSubsetSumDifference(array, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
        System.out.println(result);
    }
}
