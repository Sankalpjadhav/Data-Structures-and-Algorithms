package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*
Pairs With Given Sum In Two Sorted Matrices
1. You are given a number N and two sorted matrices(A and B) of N*N dimensions.
2. You are also given a number X.
3. You have to find the count of all valid pairs from matrices whose sum is equal to X.
4. A pair is called valid if one element of the pair is selected from A and the second element is selected from B.
Sample Input
3
1 5 6
8 10 11
15 16 18
2 4 7
9 10 12
13 16 20
21
Sample Output
4 ([[11, 10], [8, 13], [5, 16], [1, 20]])
 */
public class PairsWithGivenSumInSortedMatrices {
    public static ArrayList<ArrayList<Integer>> solve(int [][] matrix1, int [][] matrix2, int target, int N){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        /*
        Approach 1 Time: O(n^2) Space: O(n^2)
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<matrix1.length;i++){
            for(int j=0;j< matrix1[0].length;j++){
                set.add(matrix1[i][j]);
            }
        }
        for(int i=0;i<matrix2.length;i++){
            for(int j=0;j< matrix2[0].length;j++){
                if(set.contains(target - matrix2[i][j])){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(target-matrix2[i][j]);
                    pair.add(matrix2[i][j]);
                    result.add(pair);
                }
            }
        }
        */
        //Approach 2 Time: O(n^2) Space: O(1)
        int i=0,j=0;
        int k= N-1,l=N-1;
        while((i < N) && (k >=-1)){
            int val = matrix1[i][j] + matrix2[k][l];

            if(val == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(matrix1[i][j]);
                pair.add(matrix2[k][l]);
                result.add(pair);
                j++;
                l--;
            }
            else if(val < target){
                j++;
            }
            else{
                l--;
            }

            if(j > N-1){
                i++;
                j=0;
            }

            if(l < 0){
                l = N-1;
                k--;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix1 = new int[N][N];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        int[][] matrix2 = new int[N][N];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        System.out.println(solve(matrix1, matrix2, target, N));
    }
}
