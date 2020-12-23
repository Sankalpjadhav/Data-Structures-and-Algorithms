package com.dsaprograms.practice;
import java.util.Scanner;
/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers (1's and 0's), representing elements of 2d array a.
4. Consider this array a maze and a player enters from top-left corner in east direction.
5. The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
6. You are required to print the indices in (row, col) format of the point from where you exit the matrix.
 */
public class ExitPointOfaMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int i=0;
        int j=0;
        int dir=0; // 0-East,1-South,2-West,3-North
        while(true){
            dir = (dir + arr[i][j])%4;
            if(dir==0){
                //East
                j++;
            }
            else if(dir == 1){
                //South
                i++;
            }
            else if(dir == 2){
                //West
                j--;
            }
            else if(dir == 3){
                //North
                i--;
            }
            if(i<0){
                i++; // We dont want to output negative number instead the ending point(North).
                break;
            }
            else if(i>arr.length-1){ // Out of the matrix (South)
                i--;
                break;
            }
            else if(j<0){ // Out of the matrix (West)
                j++;
                break;
            }
            else if(j>arr[0].length-1){ // Out of the matrix (east)
                j--;
                break;
            }
        }
        System.out.println(i+" "+j);
    }
}
