package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int result=fibonacci(n,new int[n+1]);
        System.out.println(result);
    }

    public static int fibonacci(int n,int [] questionBank){
        if(n==1 || n==0){
            return n;
        }
        if(questionBank[n]!=0){
            return questionBank[n];
        }
        int fib1=fibonacci(n-1,questionBank);
        int fib2=fibonacci(n-2,questionBank);
        int result = fib1+fib2;
        questionBank[n]=result;
        return result;
    }
}
