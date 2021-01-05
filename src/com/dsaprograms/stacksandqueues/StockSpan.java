package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;
public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int [] span = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        span[0] = 1;
        stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && arr[i]>= arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                span[i]=i+1;
            }
            else{
                span[i] = i - stack.peek();
            }

            stack.push(i);
        }
        for(int i=0;i<span.length;i++){
            System.out.println("Span for "+arr[i]+" is: "+span[i]);
        }

    }
}
