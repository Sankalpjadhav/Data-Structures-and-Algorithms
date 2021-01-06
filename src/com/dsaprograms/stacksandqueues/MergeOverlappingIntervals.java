package com.dsaprograms.stacksandqueues;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a number n, representing the number of time-intervals.
2. In the next n lines, you are given a pair of space separated numbers.
3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30
Note -> The given input maynot be sorted by start-time.
Constraints
1 <= n <= 10^4
0 <= ith start time < 100
ith start time < ith end time <= 100
Sample Input
6
22 28
1 8
25 27
14 19
27 30
5 12
Sample Output
1 12
14 19
22 30
*/
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i=0;i<n;i++){
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
        }
        mergeIntervals(intervals);
    }

    public static void mergeIntervals(int [][] intervals){
        Pair [] pairIntervals = new Pair[intervals.length];
        for(int i=0;i<pairIntervals.length;i++){
            pairIntervals[i] = new Pair(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(pairIntervals);
        /*
        for(int i=0;i<pairIntervals.length;i++){
            System.out.println(pairIntervals[i].startTime +" "+pairIntervals[i].endTime);
        }
        */
        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<pairIntervals.length;i++){
            if(i==0) { // for the first pair in the stack directly push since there is no pair to compare.
                stack.push(pairIntervals[i]);
            }
            else{
                Pair top = stack.peek();
                if(pairIntervals[i].startTime <=  top.endTime){
                    top.endTime = Math.max(top.endTime,pairIntervals[i].endTime);
                }
                else {
                    stack.push(pairIntervals[i]);
                }
            }
        }
        // Note: Stack has end interval at the top
        Stack<Pair> result = new Stack<>(); // To reverse the result accordingly.
        while (stack.size()>0){
            result.push(stack.pop());
        }
        while(result.size()>0){
            Pair res = result.pop();
            System.out.println(res.startTime+"-"+ res.endTime);
        }
    }

    static class Pair implements Comparable<Pair> {
        int startTime;
        int endTime;

        public Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int compareTo(Pair other){
            if(this.startTime!=other.startTime){  // If the start time is not equal sort based on start time.
                return this.startTime - other.startTime;
            }
            else{ // If the start time is equal sort based on end time.
                return this.endTime - other.endTime;
            }
        }

    }
}
