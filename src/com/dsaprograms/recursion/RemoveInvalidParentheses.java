package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
/*
LeetCode: 301. Remove Invalid Parentheses
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
Note: The input string may contain letters other than the parentheses ( and ).
Example 1:
Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:
Input: ")("
Output: [""]
 */
public class RemoveInvalidParentheses {

    public static void removeInvalidParentheses(String str, int minimumRemovals, HashSet<String> checking, HashSet<String> set, ArrayList<String> result){

        if(minimumRemovals==0){
            if(getMin(str)==0) {
                if (!checking.contains(str)) {
                    result.add(str);
                    checking.add(str);
                }
            }
        }

        for(int i=0;i<str.length();i++){
            String left = str.substring(0,i); // Remove each i character
            String right = str.substring(i+1);
            if(!set.contains(left+right)){
                set.add(left+right);
                removeInvalidParentheses(left+right, minimumRemovals-1, checking, set, result);
            }
        }
    }

    public static int getMin(String str){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                if(stack.size()==0){
                    stack.push(ch);
                }
                else if(stack.peek()==')'){
                    stack.push(ch);
                }
                else if(stack.peek()=='('){
                    stack.pop();
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int minimumRemovals = getMin(str);
        ArrayList<String> result = new ArrayList<>();
        removeInvalidParentheses(str, minimumRemovals, new HashSet<>(), new HashSet<>(), result);
        System.out.println(result);
    }
}
