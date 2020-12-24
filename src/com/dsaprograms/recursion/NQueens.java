package com.dsaprograms.recursion;
import java.util.Scanner;
public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] chess = new int[n][n];
        nQueens(chess,"", 0);
    }
    public static void nQueens(int [][] chess, String queenSoFar,int row){
        if(row==chess.length){
            System.out.println(queenSoFar+".");
            return;
        }
        for(int col=0;col<chess[0].length;col++){
            if(isOurQueenSafe(chess,row,col)){
                chess[row][col]=1;
                nQueens(chess, queenSoFar+row+"-"+col+", ",row+1);
                chess[row][col]=0;
            }
        }
    }
    public static boolean isOurQueenSafe(int [][]chess, int row, int col){
        // Look for upwards
        for(int i=row-1, j=col;i>=0;i--){
            if(chess[i][j]==1){
                return false;
            }
        }
        // Look diagonaly left
        for(int i=row-1, j=col-1;i>=0 && j>=0;i--,j--){
            if(chess[i][j]==1){
                return false;
            }
        }
        // Look diagonaly right
        for(int i=row-1, j=col+1;i>=0 && j<chess[0].length;i--,j++){
            if(chess[i][j]==1){
                return false;
            }
        }
        return true;

    }
}
