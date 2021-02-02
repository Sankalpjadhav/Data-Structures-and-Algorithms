package com.dsaprograms.recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
LeetCode:51. N-Queens
https://leetcode.com/problems/n-queens/
*/
public class LeetCodeNQueens1 {
    public static List<String> constructString(char[][] board) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void nQueens(char[][] board, int row, boolean[]columns, boolean [] normalDiagonal, boolean [] reverseDiagonal, List<List<String>> result){
        if(row==board.length){
            result.add(constructString(board));
            return;
        }

        for(int col=0;col<board[0].length;col++){
            if(columns[col]==false && normalDiagonal[row+col]==false && reverseDiagonal[row-col+board.length-1]==false){
                board[row][col]= 'Q';
                columns[col]=true;
                normalDiagonal[row+col]=true;
                reverseDiagonal[row-col+board.length-1]=true;
                nQueens(board, row+1, columns, normalDiagonal, reverseDiagonal, result);
                board[row][col]= '.';
                columns[col]=false;
                normalDiagonal[row+col]=false;
                reverseDiagonal[row-col+board.length-1]=false;
            }
        }
    }


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char [][] board = new char[n][n];
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                board[row][col]='.';
            }
        }
        // We will be placing queens row wise.
        boolean [] columns = new boolean[n]; // While placing queen we will check if that particular column already has queen(true).
        boolean [] normalDiagonal = new boolean[2*n-1];// Diagonal: / && Number of diagonals possible: 2*n-1
        boolean [] reverseDiagonal = new boolean[2*n-1];// Diagonal: \ && Number of diagonals possible: 2*n-1
        nQueens(board, 0, columns, normalDiagonal, reverseDiagonal, result);
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        List<List<String>> result = solveNQueens(n);
        System.out.println(result);
    }
}
