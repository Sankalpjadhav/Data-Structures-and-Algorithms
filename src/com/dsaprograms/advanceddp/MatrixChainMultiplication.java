package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Matrix Chain Multiplication Dynamic Programming
1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
Sample Input
3
1
2
3
Sample Output
6
 */
public class MatrixChainMultiplication {
    public static void minimumNumberOfMultiplications(int [] matrixDimensions){
        int [][] dp = new int[matrixDimensions.length-1][matrixDimensions.length-1];
        //Gap strategy
        for(int gap=0;gap<dp.length;gap++){
            for(int i=0,j=gap;j<dp[0].length;i++,j++){
                if(gap==0){
                    dp[i][j] = 0; // Since it exist only 1 matrix , no number of multiplications needed.
                }
                else if(gap==1){
                    // We have 2 matrix A*B
                    dp[i][j] = matrixDimensions[i]*matrixDimensions[j]*matrixDimensions[j+1];
                }
                else{
                    // Here we have more than 2 matrices
                    int minimum = Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        int leftCost = dp[i][k];
                        int rightCost = dp[k+1][j];
                        int multiplicationCost = matrixDimensions[i] * matrixDimensions[k+1];
                        int totalCost = leftCost + multiplicationCost + rightCost;
                        if(totalCost < minimum) {
                            minimum = totalCost;
                        }
                    }
                    dp[i][j] = minimum;
                }
            }
        }
        System.out.println("Minimum number of multiplications needed to multiply the given chain of matrices: "+dp[0][dp.length-1]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dimensions = sc.nextInt();
        int [] matrixDimensions = new int[dimensions];
        for(int i=0;i<dimensions;i++){
            matrixDimensions[i] = sc.nextInt();
        }
        minimumNumberOfMultiplications(matrixDimensions);
    }
}
