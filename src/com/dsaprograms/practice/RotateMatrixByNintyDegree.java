package com.dsaprograms.practice;
import java.util.Scanner;
/*
Inorder too rotate the matrix by 90 = first transpose the matrix then reverse each row

1. You are given a number n, representing the number of rows and number of columns.
2. You are given n*n numbers, representing elements of 2d array a.
3. You are required to rotate the matrix by 90 degree clockwise and then display the contents using display function.
*Note - you are required to do it in-place i.e. no extra space should be used to achieve it .*

Input:		       Transpose      Reverse=Output
11 12 13 14       11 21 31 41      41 31 21 11
21 22 23 24  ==>  12 22 32 42  ==> 42 32 22 12
31 32 33 34       13 23 33 43      43 33 23 13
41 42 43 44       14 24 34 44      44 34 24 14
 */
public class RotateMatrixByNintyDegree {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        rotateByNinty(arr);
    }

    public static void rotateByNinty(int [][] arr){
        // Rotate = first transpose the matrix then reverse each row
        // Transpose
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr[0].length;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        // Reverse each row
        for(int i=0;i<arr.length;i++){
            int left=0;
            int right=arr[i].length-1;
            while(left<right){
                int temp=arr[i][left];
                arr[i][left]=arr[i][right];
                arr[i][right]=temp;
                left++;
                right--;
            }
        }
        display(arr);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
