package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.
Example:
Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
Note:
N will be between 1 and 25.
K will be between 0 and 100.
The knight always initially starts on the board.

 */
public class LeetCode688KnightProbability {
    public static boolean isValid(int nextI, int nextJ, int N){
        if(nextI>=0 && nextJ>=0 && nextI<N && nextJ<N){
            return true;
        }
        return false;
    }

    public static double knightProbability(int N, int K, int r, int c) {
        double [][] current = new double[N][N];
        double [][] next = new double[N][N];
        int[][] moves = { { 1, 2 }, { 2, 1 }, { -1, 2 }, { 1, -2 }, { -2, 1 }, { 2, -1 }, { -1, -2 }, { -2, -1 } };
        current[r][c] = 1;
        for(int m=1;m<=K;m++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(current[i][j]!=0){
                        // 1st method
                        for (int move = 0; move < moves.length; move++) {
                            int nr = i + moves[move][0];
                            int nc = j + moves[move][1];
                            if (isValid(nr,nc,N)){
                                next[nr][nc] += current[i][j] / 8.0;

                            }
                        }
                        /*
                        2nd method
                        int nextI = 0;
                        int nextJ = 0;

                        nextI = i-2;
                        nextJ = j+1;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0);
                        }
                        nextI = i-1;
                        nextJ = j+2;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0);
                        }
                        nextI = i+1;
                        nextJ = j+2;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0);
                        }
                        nextI = i+2;
                        nextJ = j+1;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0);
                        }
                        nextI = i+2;
                        nextJ = j-1;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0);
                        }
                        nextI = i+1;
                        nextJ = j-2;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0);
                        }
                        nextI = i-1;
                        nextJ = j-2;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0);
                        }
                        nextI = i-2;
                        nextJ = j-1;
                        if(isValid(nextI, nextJ, N)){
                            next[nextI][nextJ] += (current[i][j]/8.0);
                        }
                        */
                    }
                }
            }
            current =  next;
            next = new double[N][N];
        }
        double probability = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                probability += current[i][j];
            }
        }
        return probability;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K= sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Knight Probability: "+knightProbability(N, K, r, c));
    }
}
