package com.dsaprograms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeetCodeNQueens2 {
    static int count = 0;
    public static void nQueens(boolean[][] board, int row, boolean[]columns, boolean [] normalDiagonal, boolean [] reverseDiagonal){
        if(row==board.length){
            count++;
            return;
        }

        for(int col=0;col<board[0].length;col++){
            if(columns[col]==false && normalDiagonal[row+col]==false && reverseDiagonal[row-col+board.length-1]==false){
                board[row][col]= true;
                columns[col]=true;
                normalDiagonal[row+col]=true;
                reverseDiagonal[row-col+board.length-1]=true;
                nQueens(board, row+1, columns, normalDiagonal, reverseDiagonal);
                board[row][col]= false;
                columns[col]=false;
                normalDiagonal[row+col]=false;
                reverseDiagonal[row-col+board.length-1]=false;
            }
        }
    }


    public static int solveNQueens(int n) {
        if(n==1){
            return 1;
        }
        boolean[][] board = new boolean[n][n];
        // We will be placing queens row wise.
        boolean [] columns = new boolean[n]; // While placing queen we will check if that particular column already has queen(true).
        boolean [] normalDiagonal = new boolean[2*n-1];// Diagonal: / && Number of diagonals possible: 2*n-1
        boolean [] reverseDiagonal = new boolean[2*n-1];// Diagonal: \ && Number of diagonals possible: 2*n-1
        nQueens(board, 0, columns, normalDiagonal, reverseDiagonal);
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        System.out.println(solveNQueens(n));
    }
}
