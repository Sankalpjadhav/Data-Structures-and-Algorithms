package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;

/*
LeetCode: 1717. Maximum Score From Removing Substrings
You are given a string s and two integers x and y. You can perform two types of operations any number of times.
Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.
Example 1:
Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:
Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
Constraints:
1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.
 */
public class MaximumScoreOnRemovingSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int points = 0;
        if(y>x){
            /*
            Since "ba" points are more than "ab" focus more on "ba". look for 'a' when found check the top of stack whether there is 'b'
            If found then pop 'b' and add sum of 'ba' which is y.
            And for the remaining stack(string) look for "ab"
            */
            points = findPoints(s,y,x,'b','a');
        }
        else{
            // Find "ab" first and then "ba" in remaining string.
            points = findPoints(s,x,y,'a','b');
        }
        System.out.println("Maximum points: "+points);
    }

    public static int findPoints(String s, int max, int min, char ch1, char ch2){
        Stack<Character> stack = new Stack<>(), stack2 = new Stack<>();
        int result = 0;
        for(char c: s.toCharArray())
            if(!stack.isEmpty() && stack.peek() == ch1 && c == ch2) {
                stack.pop();
                result +=max;
            } else stack.push(c);
        while(!stack.isEmpty()) {
            char c = stack.pop();
            if(!stack2.isEmpty() && stack2.peek() == ch1 && c == ch2) {
                stack2.pop();
                result +=min;
            } else stack2.push(c);
        }
        return result;
    }
}
