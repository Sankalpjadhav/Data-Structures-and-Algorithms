package com.dsaprograms.recursion;
import java.util.Scanner;
/*
131. Palindrome Partitioning
1. You are given a string of length n.
2. You have to partition the given string in such a way that every partition is a palindrome.
INPUT:
aabba
OUTPUT:
(a) (a) (b) (b) (a)
(a) (a) (bb) (a)
(a) (abba)
(aa) (b) (b) (a)
(aa) (bb) (a)
 */
public class PalindromePartitioningOfString {

    public static void printPalindromePartitioning(String str, String answer){
        if(str.length()==0){
            System.out.println(answer);
            return;
        }

        for(int i=0;i<str.length();i++){
            String prefixString = str.substring(0, i+1);
            String remainingString = str.substring(i+1);
            if(isPalindrome(prefixString)){
                printPalindromePartitioning(remainingString, answer+"("+prefixString+") ");
            }
        }
    }

    public static boolean isPalindrome(String str){
        String reverseString="";
        for(int i=str.length()-1;i>=0;i--){
            reverseString+=str.charAt(i);
        }
        if(reverseString.equals(str)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printPalindromePartitioning(str, "");
    }
}
