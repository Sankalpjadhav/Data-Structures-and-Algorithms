package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
131. Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]
 */
public class LeetCodePalindromePartitioning {
    public static void palindromePartitioning(String str, List<String> currentList, List<List<String>> result){
        if(str.length()==0){
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int i=0;i<str.length();i++){
            String prefixString = str.substring(0,i+1);
            String remainingString = str.substring(i+1);
            if(isPalindrome(prefixString)){
                currentList.add(prefixString);
                palindromePartitioning(remainingString, currentList, result);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String str){
        String reverseString = "";
        for(int i=str.length()-1;i>=0;i--){
            reverseString+=str.charAt(i);
        }
        if(str.equals(reverseString)){
            return true;
        }
        return false;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        palindromePartitioning(s, currentList, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<List<String>> result = partition(str);
        System.out.println(result);
    }
}
