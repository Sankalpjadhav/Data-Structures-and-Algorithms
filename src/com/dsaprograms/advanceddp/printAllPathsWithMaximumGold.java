package com.dsaprograms.advanceddp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up, 1 cell right or 1 cell right-down.
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
8. Also, you have to print all paths with maximum gold.
Sample Input:
4
4
3 2 3 1
2 4 6 0
5 0 1 3
9 1 5 1
Sample output:
Maximum gold: 18
5 4 6 3
9 0 6 3
9 1 5 3
*/

public class printAllPathsWithMaximumGold {
    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        int[][] dp = new int[arr.length][arr[0].length];

        for(int j = arr[0].length - 1; j >= 0; j--){
            for(int i = 0; i < arr.length; i++){
                if(j == arr[0].length - 1){
                    dp[i][j] = arr[i][j];
                } else if(i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if(i == arr.length - 1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++){
            if(dp[i][0] > max){
                max = dp[i][0];
            }
        }

        System.out.println("Maximum gold: "+max);

        ArrayDeque<Pair> que = new ArrayDeque<>();

        for(int i = 0; i < dp.length; i++){
            if(dp[i][0] == max){
                que.add(new Pair(arr[i][0]+ "", i, 0));
            }
        }

        while(que.size() > 0){
            Pair rem = que.removeFirst();

            if(rem.j == arr[0].length - 1){
                System.out.println(rem.psf);
            } else if(rem.i == 0){
                int g = Math.max(dp[rem.i][rem.j + 1], dp[rem.i + 1][rem.j + 1]);


                if(g == dp[rem.i][rem.j + 1]){
                    que.add(new Pair(rem.psf +" "+arr[rem.i][rem.j+1], rem.i, rem.j + 1));
                }

                if(g == dp[rem.i + 1][rem.j + 1]){
                    que.add(new Pair(rem.psf +" "+arr[rem.i+1][rem.j+1], rem.i + 1, rem.j + 1));
                }
            } else if(rem.i == arr.length - 1){
                int g = Math.max(dp[rem.i][rem.j + 1], dp[rem.i - 1][rem.j + 1]);


                if(g == dp[rem.i - 1][rem.j + 1]){
                    que.add(new Pair(rem.psf +" "+arr[rem.i-1][rem.j+1], rem.i - 1, rem.j + 1));
                }

                if(g == dp[rem.i][rem.j + 1]){
                    que.add(new Pair(rem.psf +" "+arr[rem.i][rem.j+1], rem.i, rem.j + 1));
                }
            } else {
                int g = Math.max(dp[rem.i][rem.j + 1], Math.max(dp[rem.i - 1][rem.j + 1], dp[rem.i + 1][rem.j + 1]));

                if(g == dp[rem.i - 1][rem.j + 1]){
                    que.add(new Pair(rem.psf +" "+arr[rem.i-1][rem.j+1], rem.i - 1, rem.j + 1));
                }

                if(g == dp[rem.i][rem.j + 1]){
                    que.add(new Pair(rem.psf +" "+arr[rem.i][rem.j+1], rem.i, rem.j + 1));
                }

                if(g == dp[rem.i + 1][rem.j + 1]){
                    que.add(new Pair(rem.psf +" "+arr[rem.i+1][rem.j+1], rem.i + 1, rem.j + 1));
                }
            }
        }
    }
}



