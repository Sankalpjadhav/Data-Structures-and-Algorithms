package com.dsaprograms.advanceddp;
import java.util.ArrayDeque;
import java.util.Scanner;
/*
LeetCode: 55. Jump Game
https://leetcode.com/problems/jump-game/
Is also based on this. If dp[0] is not null that means path exist and we can return true otherwise false.

Print all paths with minimum jumps.
1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print
    3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
    3.2) all configurations of "MINIMUM JUMPS".
Sample Input
10
3
3
0
2
1
2
4
2
0
0
Sample Output
4
0 -> 3 -> 5 -> 6 -> 9
0 -> 3 -> 5 -> 7 -> 9
 */
public class PrintAllPathsWithMinimumJumps {
    public static class Pairs{
        int index;
        int allowedJumps;
        int jumps;
        String pathSoFar;

        Pairs(int index, int allowedJumps, int jumps, String pathSoFar){
            this.index = index;
            this.allowedJumps = allowedJumps;
            this.jumps = jumps;
            this.pathSoFar = pathSoFar;
        }
    }
    public static void printAllPathsWithMinimumJumps(int [] nums){
        Integer [] dp = new Integer[nums.length];
        dp[nums.length-1] = 0;
        
        for(int index = dp.length-2; index>=0; index--){
            int steps = nums[index];
            int minimum = Integer.MAX_VALUE;
            for(int jump=1;jump <= steps && index+jump < dp.length;jump++){
                if(dp[index+jump]!=null && dp[index+jump]<minimum){
                    minimum = dp[index+jump];
                }
            }
            if(minimum!=Integer.MAX_VALUE){ // If all are nulls then store null.(Nothing to do since default is null)
                dp[index] = minimum + 1;
            }
        }
        System.out.println("Minimum jumps required: "+dp[0]);
        ArrayDeque<Pairs> queue = new ArrayDeque<>();
        queue.add(new Pairs(0, nums[0], dp[0], 0+""));
        while(queue.size()!=0){
            Pairs removedPair = queue.removeFirst();
            if(removedPair.jumps==0){
                System.out.println(removedPair.pathSoFar);
            }
            for(int jump=1;jump<=removedPair.allowedJumps && removedPair.index+jump<dp.length;jump++){
                int currentIndex = removedPair.index+jump;
                if(dp[currentIndex]!=null && dp[currentIndex]== removedPair.jumps-1){
                    queue.add(new Pairs(currentIndex, nums[currentIndex], dp[currentIndex], removedPair.pathSoFar+" -> "+currentIndex));
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        printAllPathsWithMinimumJumps(nums);
    }
}
