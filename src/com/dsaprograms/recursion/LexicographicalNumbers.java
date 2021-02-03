package com.dsaprograms.recursion;
import java.util.Scanner;
/*
LeetCode:386. Lexicographical Numbers
1. You are given a number.
2. You have to print all the numbers from 1 to n in lexicographical order.
Constraints
1 <= n <= 50000
Sample Input
14
Sample Output
1
10
11
12
13
14
2
3
4
5
6
7
8
9
 */
public class LexicographicalNumbers {
    public static void dfs(int current, int n){
        if(current>n){
            return;
        }
        System.out.println(current);
        for(int j=0;j<10;j++){
            dfs(current*10+j, n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<10;i++){
            dfs(i, n);
        }
    }
}
