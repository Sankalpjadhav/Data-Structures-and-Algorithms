package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
LeetCode-226.
1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive
fences have same colors.
Input Format
A number n
A number k
Output Format
A number representing the number of ways in which the fences could be painted so that not more than two fences have same colors.
Constraints
1 <= n <= 10
1 <= k <= 10
Sample Input
8
3
Sample Output
3672
 */
public class PaintFence {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 5
        int k = sc.nextInt();

        long same = k*1;
        long diff = k*(k-1);
        long total = same + diff;
        for(int i=3;i<=n;i++){  // 1,2,3,4,5.
            same = diff * 1;
            diff = total * (k-1);

            total = same + diff;
        }
        System.out.println(total);
    }
}
