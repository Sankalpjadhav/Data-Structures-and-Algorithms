package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.Scanner;
/*
1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.
input:
3
3
output:
[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
 */
public class GetMazePaths {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<String> result=getMazePaths(1,1,n,m);
        System.out.println(result);
    }

    static ArrayList<String> getMazePaths(int sourceRow, int sourceColumn, int destRow, int destColumn){
        if(sourceRow==destRow && destColumn==sourceColumn){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        else if(sourceRow>destRow || sourceColumn>destColumn){
            ArrayList<String> base2 = new ArrayList<String>();
            return base2;
        }

        ArrayList<String> pathRow = getMazePaths(sourceRow+1, sourceColumn, destRow,destColumn);
        ArrayList<String> pathColumn = getMazePaths(sourceRow, sourceColumn+1, destRow,destColumn);
        ArrayList<String> result = new ArrayList<String>();
        // Attach h for pathRow.
        for(String s:pathRow){
            result.add(s+'h');
        }
        // Attach v for pathColumn.
        for(String s:pathColumn){
            result.add(s+'v');
        }
        return result;
    }
}
