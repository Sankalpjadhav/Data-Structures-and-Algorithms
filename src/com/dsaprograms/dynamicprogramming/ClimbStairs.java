package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
public class ClimbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = climbStairs(n,new int[n+1]);
        System.out.println(count);
    }
    public static int climbStairs(int n, int [] questionBank){
        if(n==0){
            return 1;
        }

        else if(n<0){
            return 0;
        }

        if(questionBank[n]!=0){
            return questionBank[n];
        }

        int forPathOne=climbStairs(n-1,questionBank);
        int forPathTwo=climbStairs(n-2,questionBank);
        int forPathThree=climbStairs(n-3,questionBank);
        int count = forPathOne + forPathTwo + forPathThree;
        questionBank[n] = count;
        return count;
    }
}
