package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;

/*
LeetCode: 227. Find the celebrity.
1. You are given a number n, representing the number of people in a party.
2. You are given n strings of n length containing 0's and 1's
3. If there is a '1' in ith row, jth spot, then person i knows about person j.
4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
5. If there is a celebrity print it's index otherwise print "none".

Note -> There can be only one celebrity. Think why?
Constraints
1 <= n <= 10^4
e1, e2, .. n * n elements belongs to the set (0, 1)

 */
public class FindTheCelebrity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] array = new int[n][n];
        for(int i=0;i<array.length;i++){
            for(int j=0;j< array.length;j++){
                array[i][j] = sc.nextInt();
            }
        }

        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<n;i++){
            stack.push(i);
        }

        while(stack.size()>=2){
            int person2 = stack.pop();
            int person1 = stack.pop();
            if(array[person1][person2]==1){
                // if person1 knows person2 -> person1 is not celebrity.
                stack.push(person2);
            }
            else{
                // if person1 doesn't know person2 -> person1 might be celebrity.
                stack.push(person1);
            }
        }
        int indexOfCelebrity = stack.peek();
        for(int i=0;i<n;i++){
            if(i!=indexOfCelebrity){
                /*
                    check
                    if the possible celebrity knows anyone(array[indexOfCelebrity][i]==1)
                    if anyone doesn't know the possible celebrity(array[i][indexOfCelebrity]==0)
                    in that case there is no celebrity.
                 */
                if(array[i][indexOfCelebrity]==0 || array[indexOfCelebrity][i]==1){
                    System.out.println("None celebrity");
                    return;
                }
            }
        }
        System.out.println("Celebrity is: "+indexOfCelebrity);
    }
}
