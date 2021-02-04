package com.dsaprograms.recursion;
import java.util.Scanner;
/*
37. Sudoku Solver(Hard) , 36. Valid Sudoku(Medium)
https://leetcode.com/problems/sudoku-solver/
https://leetcode.com/problems/valid-sudoku/
1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.
Input Format
9*9 integers ranging from 1 to 9.
0 represents an empty cell.
Output Format
You have to print the solved sudoku.
Constraints
0 <= arr[i][j] <= 9
Sample Input
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
Sample Output
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9
 */
public class SudokoSolverUsingBacktracking {

    static void solveSudoku(int [][] board, int row, int col){
        if(row == board.length){
            display(board);
            return;
        }
        int nextRow = 0;
        int nextColumn = 0;
        if(col==board[0].length-1){
            nextRow = row + 1;
            nextColumn = 0;
        }else{
            nextRow = row;
            nextColumn = col + 1;
        }
        if(board[row][col]!=0){
            solveSudoku(board, nextRow, nextColumn);
        }
        else {
            for (int possibleOption = 1; possibleOption < 10; possibleOption++) {
                if (isValidEntry(board, row, col, possibleOption)) {
                    board[row][col] = possibleOption;
                    solveSudoku(board, nextRow, nextColumn);
                    board[row][col] = 0;
                }
            }
        }

    }

    static boolean isValidEntry(int [][] board, int row, int col, int value){
        // Check in the entire row if that value is present.
        for(int j=0;j<board[0].length;j++){
            if(board[row][j]==value){
                return false;
            }
        }

        // Check in the entire column if that value is present.
        for(int i=0;i<board.length;i++){
            if(board[i][col]==value){
                return false;
            }
        }

        //Check in sub-matrix if that value is present.
        int subMatrixStartRow = (row/3)*3;
        int subMatrixStartCol = (col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[subMatrixStartRow+i][subMatrixStartCol+j] == value){
                    return false;
                }
            }
        }

        return true;
    }

    static void display(int [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] board = new int[9][9];
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                board[row][col] = sc.nextInt();
            }
        }
        solveSudoku(board, 0, 0);
    }
}
