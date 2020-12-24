package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.Scanner;
/*
1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner.
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).
4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.
2
2
[h1v1, v1h1, d1]
*/
public class GetMazePathsWithJumps {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<String> result = getMazePathsWithJumps(1,1,n,m);
        System.out.println(result);
    }

    public static ArrayList<String> getMazePathsWithJumps(int sourceRow, int sourceColumn, int destRow, int destColumn){
        if(sourceRow==destRow && sourceColumn==destColumn){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> result = new ArrayList<String>();
        // Horizontal Paths
        for(int move = 1;move<= destColumn-sourceColumn;move++){
            ArrayList<String> pathRow = getMazePathsWithJumps(sourceRow, sourceColumn+move, destRow, destColumn);
            for(String s: pathRow){
                result.add("h"+move+s);
            }
        }
        //Diagonal Paths
        for(int move = 1;move<= destRow-sourceRow && move<=destColumn-sourceColumn;move++){
            ArrayList<String> pathDiagonal = getMazePathsWithJumps(sourceRow+move, sourceColumn+move, destRow, destColumn);
            for(String s: pathDiagonal){
                result.add("d"+move+s);
            }
        }
        // Vertical Paths
        for(int move = 1;move<= destRow-sourceRow;move++){
            ArrayList<String> pathColumn = getMazePathsWithJumps(sourceRow+move, sourceColumn, destRow, destColumn);
            for(String s: pathColumn){
                result.add("v"+move+s);
            }
        }
        return result;
    }
}
