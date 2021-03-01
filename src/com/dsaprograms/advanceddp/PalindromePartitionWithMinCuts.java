package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Palindrome Partitioning with Minimum Cuts
LeetCode: 132. Palindrome Partitioning II
https://leetcode.com/problems/palindrome-partitioning-ii/
1. You are given a string.
2. You have to find the minimum number of cuts required to convert the given string into palindromic partitions.
3. Partitioning of the string is a palindromic partitioning if every substring of the partition is a palindrome.
Sample Input
abccbc
Sample Output
2
 */
public class PalindromePartitionWithMinCuts {
    public static void palindromePartitioning(String str){
        boolean [][] isPalindrome = new boolean[str.length()][str.length()];
        for(int gap=0;gap< isPalindrome.length;gap++){
            for(int i=0,j=gap;j< isPalindrome.length;i++,j++){
                if(gap==0){
                    isPalindrome[i][j] = true;
                }
                else if(gap==1){
                    if(str.charAt(i)==str.charAt(j)){
                        isPalindrome[i][j] = true;
                    }
                }
                else{
                    if(str.charAt(i)==str.charAt(j) && isPalindrome[i+1][j-1]==true){
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }
        /*
         by O(N^3) complexity
        int [][] minimumCuts = new int[str.length()][str.length()];
        for(int gap=0;gap<isPalindrome.length;gap++){
            for(int i=0,j=gap;j<isPalindrome.length;i++,j++){
                if(gap==0){
                    minimumCuts[i][j] = 0; // Since it is already a palindrome then no cuts are required.
                }
                else if(gap==1){
                    if(isPalindrome[i][j]){
                        minimumCuts[i][j] = 0;
                    }
                    else{ // When two characters are not equal, then we need just one cut to make them palindrome. Eg: ab => a/b
                        minimumCuts[i][j] = 1;
                    }
                }
                else{
                    if(isPalindrome[i][j]){
                        minimumCuts[i][j] = 0;
                    }
                    else {
                        int minimum = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            int left = minimumCuts[i][k];
                            int right = minimumCuts[k + 1][j];
                            if (left + right + 1 < minimum) {
                                minimum = left + right + 1;
                            }
                        }
                        minimumCuts[i][j] = minimum;
                    }
                }
            }
        }
        System.out.println("Minimum cuts required: "+minimumCuts[0][str.length()-1]);
        */
        //by O(N^2) complexity
        int [] dp = new int[str.length()];
        dp[0] = 0;
        for(int j=1;j<dp.length;j++){
            if(isPalindrome[0][j]){ // If it is already palindrome then we need cut
                   dp[j] = 0;
            }
            else {
                int minimum = Integer.MAX_VALUE;
                for (int i = j; i >= 1; i--) {
                    if(isPalindrome[i][j]){
                        if(dp[i-1]<minimum){
                            minimum = dp[i-1];
                        }
                    }
                }
                dp[j] = minimum+1;
            }
        }
        System.out.println("Minimum cuts required: "+dp[str.length()-1]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        palindromePartitioning(str);
    }
}
