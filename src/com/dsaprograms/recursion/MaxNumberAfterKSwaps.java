package com.dsaprograms.recursion;
import java.util.Scanner;
/*
1. You are given a string which represents digits of a number.
2. You have to create the maximum number by performing at-most k swap operations on its digits.
Sample Input
1234567
4
Sample Output
7654321
 */
public class MaxNumberAfterKSwaps {
    public static String max="0";
    public static void findMaximumNumber(String str, int k){
        if(k==0){
            return;
        }
        if(Integer.parseInt(str) > Integer.parseInt(max)){
            max = str;
        }
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(j) > str.charAt(i)){
                    str = swap(str, i, j); // To get the feel of backtracking( Else We can able to use String swapped=swap(str, i, j))
                    findMaximumNumber(str, k-1);
                    str = swap(str, i, j);
                }
            }
        }
    }

    public static String swap(String str, int i, int j){
        // We can also use StringBuilder
        char ith = str.charAt(i);
        char jth = str.charAt(j);
        String left = str.substring(0,i);
        String middle = str.substring(i+1, j);
        String right = str.substring(j+1);
        return left + jth + middle + ith + right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        findMaximumNumber(str, k);
        System.out.println(max);
    }
}
