package com.dsaprograms.advanceddp;
import java.util.ArrayDeque;
import java.util.Scanner;
/*
Print All Paths With Minimum Cost
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze(Cost matrix).
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
7. You are required to traverse through the matrix and print the cost of the path which is least costly.
8. Also, you have to print all the paths with minimum cost.
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
    Minimum cost: 23
    Minimum cost paths:
    HVVHHVHVHV
    HVVHHVHHVV
 */
public class PrintAllMinimumCostPaths {
    public static class Pairs{
        int row;
        int column;
        String pathSoFar;

        Pairs(int row, int column, String pathSoFar){
            this.row = row;
            this.column = column;
            this.pathSoFar = pathSoFar;
        }
    }

    public static void printAllMinimumPaths(int [][] costMatrix){
        int [][] dp = new int[costMatrix.length][costMatrix[0].length];
        for(int row = costMatrix.length-1;row >= 0;row--){
            for(int column = costMatrix[row].length-1;column >= 0;column--){
                /*
                For reference: 4 regions
                    0 0 0 0 0 3
                    0 0 0 0 0 3
                    0 0 0 0 0 3
                    0 0 0 0 0 3
                    0 0 0 0 0 3
                    2 2 2 2 2 1
                 */
                // last cell(Represented by 1 in figure)
                if(row == dp.length-1 && column == dp[row].length-1){
                    dp[row][column] = costMatrix[row][column];
                }
                else if(row == dp.length-1){ // last row(Represented by 2 in figure)
                    dp[row][column] = costMatrix[row][column] + dp[row][column+1];
                }
                else if(column == dp[row].length-1){ // last column (Represented by 3 in figure)
                    dp[row][column] = costMatrix[row][column] + dp[row+1][column];
                }
                else{ // inbetween cells (Represented by 0 in figure)
                    dp[row][column] = costMatrix[row][column] + Math.min(dp[row][column+1],dp[row+1][column]);
                }
            }
        }
        System.out.println("Minimum cost: "+dp[0][0]);
        System.out.println("Minimum cost paths:");
        ArrayDeque<Pairs> queue = new ArrayDeque<>();
        queue.add(new Pairs(0,0,""));
        while(queue.size()!=0){
            Pairs removedPair = queue.removeFirst();
            if(removedPair.row == dp.length-1 && removedPair.column == dp[0].length-1){
                // We are in last cell
                System.out.println(removedPair.pathSoFar);
            }
            else if(removedPair.row == dp.length-1){
                queue.add(new Pairs(removedPair.row, removedPair.column+1, removedPair.pathSoFar+"H"));
            }
            else if(removedPair.column == dp[0].length-1){
                queue.add(new Pairs(removedPair.row+1, removedPair.column, removedPair.pathSoFar+"V"));
            }
            else{
                if(dp[removedPair.row+1][removedPair.column] < dp[removedPair.row][removedPair.column+1]){
                    queue.add(new Pairs(removedPair.row+1, removedPair.column, removedPair.pathSoFar+"V"));
                }
                else if(dp[removedPair.row][removedPair.column+1] < dp[removedPair.row+1][removedPair.column]){
                    queue.add(new Pairs(removedPair.row, removedPair.column+1, removedPair.pathSoFar+"H"));
                }else{ // If equal
                    queue.add(new Pairs(removedPair.row+1, removedPair.column, removedPair.pathSoFar+"V"));
                    queue.add(new Pairs(removedPair.row, removedPair.column+1, removedPair.pathSoFar+"H"));
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int columns = Integer.parseInt(sc.nextLine());
        int [][] costMatrix = new int[rows][columns];
        for(int i=0;i<rows;i++){
            String line = sc.nextLine();
            for(int j=0;j<columns;j++){
                costMatrix[i][j] = Integer.parseInt(line.split(" ")[j]);
            }
        }
        printAllMinimumPaths(costMatrix);
    }
}
