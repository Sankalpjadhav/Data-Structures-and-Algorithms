package com.dsaprograms.practice;

import java.util.Scanner;

public class SpiralTraverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int [] result = spiralTraverse(arr,m,n);
        for(int i = 0; i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    public static int[] spiralTraverse(int [][] arr, int m,int n){
        int [] result = new int [m*n];
        int startRow=0,startColumn=0;
        int k=0;
        int endRow=arr.length-1, endColumn=arr[0].length-1;
        while(startRow<=endRow && startColumn<=endColumn){
            for(int row=startRow;row<=endRow;row++){
                result[k++] = arr[row][startColumn];
            }
            startColumn++;
            for(int col=startColumn;col<=endColumn;col++){
                result[k++] = arr[endRow][col];
            }
            endRow--;
            if(startColumn<=endColumn){
                for(int row=endRow;row>=startRow;row--){
                    result[k++] = arr[row][endColumn];
                }
                endColumn--;
            }
            if(startRow<=endRow){
                for(int col=endColumn;col>=startColumn;col--){
                    result[k++] = arr[startRow][col];
                }
                startRow++;
            }
        }
        return result;
    }
}
