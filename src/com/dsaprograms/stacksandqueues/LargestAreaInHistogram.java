package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;
/*
LeetCode: 84. Largest Rectangle in Histogram
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.
e.g.
for the array [6 2 5 4 5 1 6] -> 12
Input Format
Input is managed for you
Output Format
A number representing area of largest rectangle in histogram
Constraints
0 <= n < 20
0 <= a[i] <= 10
Sample Input
7
6
2
5
4
5
1
6
Sample Output
12
 */
public class LargestAreaInHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] heights = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = sc.nextInt();
        }
        int maxArea = 0;
        int [] leftBoundary = new int[heights.length]; // This will store index of smallest element to the left of particular element.
        int [] rightBoundary = new int[heights.length]; // This will store index of smallest element to the right of particular element.
        Stack<Integer> stack = new Stack<>();

        //Fill right boundaries
        stack.push(heights.length-1);
        rightBoundary[rightBoundary.length-1] = heights.length;
        for(int i = heights.length-2;i>=0;i--){
            while(stack.size()>0 && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.size()==0){
                rightBoundary[i] = heights.length; // marks the index of the element not present in histogram i.e to the right.
            }
            else {
                rightBoundary[i] = stack.peek(); // Smallest element to the right ->  index is stored.
            }
            stack.push(i);
        }

        //Fill left boundaries
        stack = new Stack<>();
        stack.push(0);
        leftBoundary[leftBoundary.length-1] = -1;
        for(int i = 1;i< leftBoundary.length;i++){
            while(stack.size()>0 && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.size()==0){
                leftBoundary[i] = -1; // marks the index of the element not present in histogram i.e to the left.
            }
            else {
                leftBoundary[i] = stack.peek(); // Smallest element to the left ->  index is stored.
            }
            stack.push(i);
        }

        //Find area
        for(int i=0;i<heights.length;i++){
            int width = rightBoundary[i] - leftBoundary[i] -1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea,area);
        }
        System.out.println(maxArea);
    }
}
