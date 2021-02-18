package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
Solved already using branch and bound & backtracking.
NQueens using bit manipulation
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
     Use sample input and output to get more idea.
Sample Input
4
Sample Output
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0

0 0 1 0
1 0 0 0
0 0 0 1
0 1 0 0
 */
public class NQueensUsingBitManipulation {
    public static void nQueens(int [][] board, int row, int columnBit, int normalDiagonalBit, int reverseDiagonalBit){
        if(row==board.length){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int col=0;col<board[0].length;col++){
            if(
                    ((columnBit & (1<<col))==0) && ((normalDiagonalBit & (1 << (row+col)))==0) && ((reverseDiagonalBit & (1<<(row - col + board[0].length - 1)))==0)
            ){
                board[row][col] = 1;
                columnBit ^= (1<<col);
                normalDiagonalBit ^= (1 << (row+col));
                reverseDiagonalBit ^= (1<<(row-col+board[0].length-1));
                nQueens(board, row+1, columnBit, normalDiagonalBit, reverseDiagonalBit);
                columnBit ^= (1<<col);
                normalDiagonalBit ^= (1 << (row+col));
                reverseDiagonalBit ^= (1<<(row-col+board[0].length-1));
                board[row][col] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] board = new int[n][n];
        // Using bits
        int columnBit = 0;
        int normalDiagonalBit = 0;
        int reverseDiagonalBit = 0;
        nQueens(board, 0, columnBit, normalDiagonalBit, reverseDiagonalBit);
    }
}
