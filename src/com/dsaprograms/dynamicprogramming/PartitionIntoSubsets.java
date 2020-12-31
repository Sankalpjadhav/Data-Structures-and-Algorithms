package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
Partition Into Subsets.
1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34
Input Format
A number n
A number k
Output Format
A number representing the number of ways in which these elements can be partitioned in k non-empty subsets.
Constraints
0 <= n <= 20
0 <= k <= n
Sample Input
4
3
Sample Output
6
 */
public class PartitionIntoSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int teams = sc.nextInt();
        long [][] dp =new long[teams+1][people+1];
        if(people==0 || teams==0 || people<teams){
            System.out.println(0);
            return;
        }

        for(int team=1;team<=teams;team++){
            for(int p =1;p<=people;p++){
                if(p<team){
                    dp[team][p]=0;
                }
                else if(p==team){
                    dp[team][p]=1;
                }
                else{
                    dp[team][p] = dp[team-1][p-1] + dp[team][p-1]*team;
                }
            }
        }
        System.out.println(dp[teams][people]);
    }
}
