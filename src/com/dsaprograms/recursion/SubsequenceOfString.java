package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.Scanner;
public class SubsequenceOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> result =  getSubsequences(str);
        System.out.println(result);
    }

    public static ArrayList<String> getSubsequences(String str){
        if(str.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char first = str.charAt(0);
        String remaining = str.substring(1);
        ArrayList<String> remainingResult = getSubsequences(remaining);
        ArrayList<String> result = new ArrayList<String>();
        // Not including first.
        for(String s: remainingResult){
            s=""+s;
            result.add(s);
        }
        // Including first.
        for(String s: remainingResult){
            s=first+s;
            result.add(s);
        }
        return result;
    }
}
