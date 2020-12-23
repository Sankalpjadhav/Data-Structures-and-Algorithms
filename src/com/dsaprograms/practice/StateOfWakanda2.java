package com.dsaprograms.practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
1    2    3    4
5    6    7    8
9    10   11   12
13   14   15   16
The path followed by the visitor is: 1->6->11->16->2->7->12->3->8->4
You are required to print the path followed by the traveller to visit all the monuments.
Refer to the photo for a better clarification.
1. You are given a number n, representing the number of rows and columns of a square matrix.
2. You are given n * n numbers, representing elements of 2d array a.
3. You are required to diagonally traverse the upper half of the matrix and print the contents.
 */
public class StateOfWakanda2 {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        // diagonal traversal
        for(int g = 0; g < arr.length; g++){
            for(int i = 0, j = i + g; j < arr.length; i++, j++){
                System.out.println(arr[i][j]);
            }
        }

    }
}
