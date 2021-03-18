package com.dsaprograms.hashmapandheap;
import java.util.Scanner;
/*
Pair with given Sum in Two Sorted Matrices using Binary Search
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
4
 */
public class PairWithGivenSumInSortedMatrix2 {
    public static int firstIndex(int elem, int [][] A, int n){
        // this 2D array converted into 1D array
        // TO get 2D array index: row = index/n and column = index % n
        int startIndex = 0;
        int endIndex = n*n-1;
        int firstI = -1;
        while(startIndex <= endIndex){
            int mid = (startIndex + endIndex)/2;
            if(elem == A[mid/n][mid%n]){
                firstI = mid;
                endIndex = mid - 1;
            }
            else if(elem > A[mid/n][mid%n]){
                startIndex = mid + 1;
            }
            else{
                endIndex = mid - 1;
            }
        }
        return firstI;
    }

    public static int lastIndex(int elem, int [][] A, int n){
        // this 2D array converted into 1D array
        // TO get 2D array index: row = index/n and column = index % n
        int startIndex = 0;
        int endIndex = n*n-1;
        int lastI = -1;
        while(startIndex <= endIndex){
            int mid = (startIndex + endIndex)/2;
            if(elem == A[mid/n][mid%n]){
                lastI = mid;
                startIndex = mid + 1;
            }
            else if(elem > A[mid/n][mid%n]){
                startIndex = mid + 1;
            }
            else{
                endIndex = mid - 1;
            }
        }
        return lastI;
    }

    public static int findCount(int [][] A, int [][] B, int sum, int n){
        if(A.length==0 || A[0].length==0 || B.length==0 || B[0].length==0){
            return 0;
        }
        int count = 0;
        for(int [] arr:B){
            for(int elem:arr){
                int firstIndex = firstIndex(sum - elem, A, n);
                if(firstIndex == -1) continue;
                int lastIndex = lastIndex(sum - elem, A, n);
                int numOfElements = (lastIndex - firstIndex + 1);
                // If there are more than 1 (sum - elem) in A then for each element it is a valid pair. If there is only 1 then lastIndex - firstIndex + 1 becomes 0.
                count += numOfElements;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] A = new int[n][n];
        int [][] B = new int[n][n];
        for(int i = 0; i<n ;i++){
            for(int j=0;j<n;j++) {
                A[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i<n ;i++){
            for(int j=0;j<n;j++) {
                B[i][j] = sc.nextInt();
            }
        }

        int sum = sc.nextInt();
        System.out.println("The count of all valid pairs from matrices whose sum is equal to X: "+findCount(A,B,sum,n));

    }
}
