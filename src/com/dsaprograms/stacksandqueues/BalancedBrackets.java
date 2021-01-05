package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        /* 3 conditions to check:
        1. Non matching opening and closing brackets.
        2. More number of opening brackets -> Check at the end if the stack is empty. If Empty then Balanced brackets else more number of opening brackets.
        3. More number of closing brackets.
         */
        Stack < Character > st = new Stack < > ();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0 || st.peek() != '(') {
                    System.out.println(false);
                    return;
                } else {
                    st.pop();
                }
            } else if (ch == '}') {
                if (st.size() == 0 || st.peek() != '{') {
                    System.out.println(false);
                    return;
                } else {
                    st.pop();
                }
            } else if (ch == ']') {
                if (st.size() == 0 || st.peek() != '[') {
                    System.out.println(false);
                    return;
                } else {
                    st.pop();
                }
            }
        }

        if (st.size() == 0) {
            System.out.println(true);
        } else {
            System.out.println(false); // More number of opening brackets.
        }
    }
}