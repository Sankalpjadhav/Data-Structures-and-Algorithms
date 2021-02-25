package com.dsaprograms.advanceddp;
import java.util.ArrayDeque;
import java.util.Scanner;
/*
Print All Paths With Target Sum Subset
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tarGET".
4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "target" or not.
5. Also, you have to print the indices of elements that should be selected to achieve the given target.
6. You have to print all such configurations.
Sample Input
5
4
2
7
1
3
10
Sample Output
true
2 4
1 2 3
0 1 3 4
*/
public class PrintSubsetsWithTargetSum {
    public static class Pairs{
        int row;
        int column;
        String pathSoFar;
        Pairs(int row, int column, String pathSoFar){
            this.row=row;
            this.column=column;
            this.pathSoFar=pathSoFar;
        }
    }

    public static void printTargetSumSubsets(int [] nums, int target){
        boolean [][] dp = new boolean[nums.length+1][target+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0){
                    dp[i][j] = true;
                }
                else if(i==0){
                    dp[i][j] = false; // By default it will be false so not at all required to write.
                }
                else{
                    if(dp[i-1][j]==true) {
                        dp[i][j] = true;
                    }
                    else if(j>=nums[i-1]){
                        if(dp[i-1][j-nums[i-1]]==true){ // Played and check if remaining team can score remaining target
                            dp[i][j] = true;
                        }
                        else{
                            dp[i][j] = false; // Not required since by default its false.
                        }
                    }
                }
            }
        }
        System.out.println("Subsets for target sum exist: "+dp[nums.length][target]);
        ArrayDeque<Pairs> queue = new ArrayDeque<>();
        queue.add(new Pairs(dp.length-1, target, ""));

        while(queue.size()!=0){
            Pairs removedPair = queue.removeFirst();
            if(removedPair.row==0 || removedPair.column==0){
                System.out.println(removedPair.pathSoFar);
            }
            else{
                boolean exclude = dp[removedPair.row-1][removedPair.column];
                if(exclude){
                    queue.add(new Pairs(removedPair.row-1, removedPair.column, removedPair.pathSoFar));
                }
                if(removedPair.column>=nums[removedPair.row-1]) {
                    boolean include = dp[removedPair.row - 1][removedPair.column - nums[removedPair.row - 1]];
                    if (include) {
                        queue.add(new Pairs(removedPair.row - 1, removedPair.column - nums[removedPair.row - 1], removedPair.pathSoFar + nums[removedPair.row - 1]+" "));
                    }
                }

            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfElements = sc.nextInt();
        int [] nums = new int[numberOfElements];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        printTargetSumSubsets(nums, target);
    }
}
