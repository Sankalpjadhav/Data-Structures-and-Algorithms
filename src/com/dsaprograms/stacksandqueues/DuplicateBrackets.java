package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;
/*
1. You are given a string exp representing an expression.
2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
3. But, some of the pair of brackets maybe extra/needless.
4. You are required to print true if you detect extra brackets and false otherwise.
e.g.
((a + b) + (c + d)) -> false
(a + b) + ((c + d)) -> true
Input Format
A string str
Output Format
true or false
Constraints
0 <= str.length <= 100
Sample Input
(a + b) + ((c + d))
Sample Output
true
 */
public class DuplicateBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack < Character > stack = new Stack < > ();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if (ch == ')') { // When encountered closing bracket, there are two cases to handle.
                if (stack.peek() == '(') { // If at the top we encounter opening bracket, then we dont have any content in it. -> Duplicacy of bracket.
                    System.out.println("Duplicacy of bracket : true");
                    return;
                }
                else { // There is presence of content. Pop until opening bracket.
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop(); // Pop opening bracket too.
                }
            }else{ // Other than closing bracket push it onto stack.
                if(ch!=' '){ // Make sure to check this ... Do not push onto stack if character at i is ' '.
                    stack.push(ch);
                }
            }
        }
        System.out.println("Duplicacy of bracket : false");

    }
}
