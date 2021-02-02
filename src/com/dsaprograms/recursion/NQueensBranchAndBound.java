package com.dsaprograms.recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can
     kill another.
Note - Queens kill at distance in all 8 directions
calculate and print all safe configurations of n-queens
Input Format
A number n
Output Format
Safe configurations of queens as suggested in sample output
Constraints
1 <= n <= 10
Sample Input
4
Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .
 */
public class NQueensBranchAndBound {

    static void nQueens(boolean [][]board, int row, boolean [] columns, boolean [] normalDiagonal, boolean [] reverseDiagonal, String answerSoFar){
        if(row==board.length){
            System.out.println(answerSoFar+".");
            return;
        }
        // For every row place at every column and check
        for(int col=0;col<board[0].length;col++)
        {
            if(columns[col]==false && normalDiagonal[row+col]==false && reverseDiagonal[row-col + board.length-1]==false){
                board[row][col] = true;
                columns[col] = true;
                normalDiagonal[row+col] = true;
                reverseDiagonal[row-col + board.length-1] = true;
                nQueens(board, row+1, columns, normalDiagonal, reverseDiagonal, answerSoFar+row+"-"+col+",");
                board[row][col] = false;
                columns[col] = false;
                normalDiagonal[row+col] = false;
                reverseDiagonal[row-col + board.length-1] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        // Adding queens row wise
        boolean [][] board = new boolean[n][n];
        boolean [] columns = new boolean[n]; // represents if that particular column has queen. So that no queen can be placed at that column.
        boolean [] normalDiagonal = new boolean[2*n-1]; // If it has true then in that diagonal, queen can't be placed.
        boolean [] reverseDiagonal = new boolean[2*n-1]; // If it has true then in that diagonal, queen can't be placed.
        nQueens(board, 0, columns, normalDiagonal, reverseDiagonal, "");
    }
}
