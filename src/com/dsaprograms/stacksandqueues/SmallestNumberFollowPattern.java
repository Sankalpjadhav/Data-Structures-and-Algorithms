package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;
/*
1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
2. 'd' stands for decreasing and 'i' stands for increasing
3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that
the digit decreases following a d and increases follwing an i.
e.g.
d -> 21
i -> 12
ddd -> 4321
iii -> 1234
dddiddd -> 43218765
iiddd -> 126543
Constraints
0 < str.length <= 8
str contains only 'd' and 'i'
Sample Input
ddddiiii
Sample Output
543216789
 */
public class SmallestNumberFollowPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num=1;
        Stack<Integer> stack = new Stack<>();
         for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='d'){
                stack.push(num);
                num++;
            }
            else{ // ch=='i'
                stack.push(num);
                num++;
                while(stack.size()>0){
                    System.out.print(stack.pop());
                }
            }
        }
         // for eg if str containing only d's or ending with d then stack is not empty.
        stack.push(num); // Because for single character there are 2 numbers.
        while(stack.size()>0){
            System.out.print(stack.pop());
        }
    }
}
