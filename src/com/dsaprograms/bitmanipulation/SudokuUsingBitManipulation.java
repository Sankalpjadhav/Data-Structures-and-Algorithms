package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
Solve Sudoku using Bit Manipulation
1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.
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
public class SudokuUsingBitManipulation {
    public static void sudoku(int [][] puzzle, int [] rows, int [] columns, int [][] grid, int i, int j){
        if(i==puzzle.length ){
            display(puzzle);
            return;
        }
        if(puzzle[i][j]>0){
            sudoku(puzzle, rows, columns, grid, j== puzzle[0].length-1?i+1:i, j== puzzle[0].length-1?0:j+1);
        }
        else{
            for(int num=1;num<=9;num++){
                if((rows[i] & (1 << num))==0 && (columns[j] & (1 << num))==0 && (grid[i/3][j/3] & (1 << num))==0){
                    puzzle[i][j] = num;
                    rows[i] ^= (1 << num);
                    columns[j] ^= (1 << num);
                    grid[i/3][j/3] ^= (1 << num);
                    sudoku(puzzle, rows, columns, grid, j== puzzle[0].length-1?i+1:i, j== puzzle[0].length-1?0:j+1);
                    grid[i/3][j/3] ^= (1 << num);
                    columns[j] ^= (1 << num);
                    rows[i] ^= (1 << num);
                    puzzle[i][j] = 0;
                }
            }
        }
    }

    public static void display(int [][] puzzle){
        for(int i=0;i<puzzle.length;i++){
            for(int j=0;j<puzzle[0].length;j++){
                System.out.print(puzzle[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] puzzle = new int[9][9];
        int [] rows = new int[9];
        int [] columns = new int[9];
        int [][] grid = new int[3][3];
        for(int i=0;i< puzzle.length;i++){
            for(int j=0;j< puzzle[0].length;j++){
                int digit = sc.nextInt();
                puzzle[i][j] = digit;
                rows[i] |= (1<<digit);
                columns[j] |= (1<<digit);
                grid[i/3][j/3] |=(1<<digit);
            }
        }
        sudoku(puzzle, rows, columns, grid, 0, 0);
    }
}
