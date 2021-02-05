package com.dsaprograms.recursion;
import java.util.Scanner;
/*
1. You are given a 10*10 2-D array(arr) containing only '+' and '-' characters, which represents a
    crossword puzzle.
2. You are also given n number of words which need to be filled into the crossword.
3. Cells containing '-' are to be filled with the given words.
Constraints
1 <= n <= 10
Sample Input
+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
4
LONDON
DELHI
ICELAND
ANKARA
Sample Output
+L++++++++
+O++++++++
+N++++++++
+DELHI++++
+O+++C++++
+N+++E++++
+++++L++++
++ANKARA++
+++++N++++
+++++D++++
 */
public class CrosswordPuzzle {
    static void solvePuzzle(char[][] puzzle, String [] words, int wordIndex){
        if(wordIndex==words.length){
            printPuzzle(puzzle);
            return;
        }
        String word = words[wordIndex];
        for(int row=0;row<puzzle.length;row++){
            for(int col=0;col<puzzle[0].length;col++){
                if(puzzle[row][col] == '-' || puzzle[row][col] == word.charAt(0)){ // We need to start filling if we encounter - or the start letter of the word which we want to fill.
                    if(canWordBePlacedHorizontally(puzzle, row, col, word)){
                        // If yes
                        boolean [] wePlaced = placeTheWordHorizontally(puzzle, row, col, word);
                        solvePuzzle(puzzle, words, wordIndex+1);
                        // After returning (Backtrack) - because if the word cannot be fit then we need to remove the added word and try to find new place for the same.
                        unplaceTheWordHorizontally(puzzle, row, col, wePlaced);
                    }

                    if(canWordBePlacedVertically(puzzle, row, col, word)){
                        // If yes
                        boolean [] wePlaced = placeTheWordVertically(puzzle, row, col, word);
                        solvePuzzle(puzzle, words, wordIndex+1);
                        // After returning (Backtrack) - because if the word cannot be fit then we need to remove the added word and try to find new place for the same.
                        unplaceTheWordVertically(puzzle, row, col, wePlaced);
                    }

                }
            }
        }
    }


    static boolean canWordBePlacedHorizontally(char[][] puzzle, int row, int col, String word){
        if(col-1>=0 && puzzle[row][col-1]!='+'){
            return false;
        }else if(col+word.length()<puzzle[0].length && puzzle[row][col+word.length()]!='+'){
            return false;
        }
        for(int colIndex=0;colIndex<word.length();colIndex++){
            if(col+colIndex>=puzzle[0].length){
                return false;
            }

            if(puzzle[row][col+colIndex]=='-' || puzzle[row][col+colIndex]== word.charAt(colIndex)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    static boolean canWordBePlacedVertically(char[][] puzzle, int row, int col, String word){
        if(row-1>=0 && puzzle[row-1][col]!='+'){
            return false;
        }else if(row+word.length()<puzzle.length && puzzle[row+word.length()][col]!='+'){
            return false;
        }
        for(int rowIndex=0;rowIndex<word.length();rowIndex++){
            if(row+rowIndex>=puzzle.length){
                return false;
            }

            if(puzzle[row+rowIndex][col]=='-' || puzzle[row+rowIndex][col]== word.charAt(rowIndex)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    static boolean[] placeTheWordHorizontally(char[][] puzzle, int row, int col, String word){
        boolean [] wePlaced = new boolean[word.length()];
        for(int colIndex=0;colIndex<word.length();colIndex++){
            if(puzzle[row][col+colIndex]=='-'){
                puzzle[row][col+colIndex]= word.charAt(colIndex);
                wePlaced[colIndex] = true;
            }
        }
        return wePlaced;
    }

    static void unplaceTheWordHorizontally(char[][] puzzle, int row, int col, boolean [] wePlaced){
        for(int colIndex=0;colIndex<wePlaced.length;colIndex++){
            if(wePlaced[colIndex]==true){
                puzzle[row][col+colIndex] = '-';
            }
        }
    }

    static boolean[] placeTheWordVertically(char[][] puzzle, int row, int col, String word){
        boolean [] wePlaced = new boolean[word.length()];
        for(int rowIndex=0;rowIndex<word.length();rowIndex++){
            if(puzzle[row+rowIndex][col]=='-'){
                puzzle[row+rowIndex][col]= word.charAt(rowIndex);
                wePlaced[rowIndex] = true;
            }
        }
        return wePlaced;
    }

    static void unplaceTheWordVertically(char[][] puzzle, int row, int col, boolean [] wePlaced){
        for(int rowIndex=0;rowIndex<wePlaced.length;rowIndex++){
            if(wePlaced[rowIndex]==true){
                puzzle[row+rowIndex][col] = '-';
            }
        }
    }

    static void printPuzzle(char [][] puzzle){
        for(int i=0;i<puzzle.length;i++){
            System.out.println(puzzle[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [][] puzzle = new char[10][10];
        for(int i=0;i<puzzle.length;i++){
                puzzle[i] = sc.next().toCharArray();
        }
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = sc.next();
        }
        solvePuzzle(puzzle, words, 0);
    }
}
