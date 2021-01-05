package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;
/*
LeetCode: 496. Next Greater Element I
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to "next greater element on the right" for all elements of array
4. Input and output is handled for you.

"Next greater element on the right" of an element x is defined as the first element to right of x having value greater than x.
Note -> If an element does not have any element on it's right side greater than it, consider -1 as it's "next greater element on right"
e.g.
for the array [2 5 9 3 1 12 6 8 7]
Next greater for 2 is 5
Next greater for 5 is 9
Next greater for 9 is 12
Next greater for 3 is 12
Next greater for 1 is 12
Next greater for 12 is -1
Next greater for 6 is 8
Next greater for 8 is -1
Next greater for 7 is -1
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
0 <= n < 10^5
-10^9 <= a[i] <= 10^9
Sample Input
5
5
3
8
-2
7
Sample Output
8
8
-1
7
-1
 */
public class NextGreaterEleToRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int [] nextGreaterElements = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[n-1]);
        nextGreaterElements[n-1] = -1;
        for(int i=arr.length-2;i>=0;i--){
            while(stack.size()>0 && arr[i]>stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreaterElements[i] = -1;
            }
            else{
                nextGreaterElements[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        for(int i=0;i<nextGreaterElements.length;i++){
            System.out.println("Next greater element of "+arr[i]+" to the right side is: "+nextGreaterElements[i]);
        }
    }
}
