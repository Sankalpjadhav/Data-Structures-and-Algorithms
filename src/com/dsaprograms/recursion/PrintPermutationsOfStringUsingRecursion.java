package com.dsaprograms.recursion;
import java.util.Scanner;
public class PrintPermutationsOfStringUsingRecursion {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        String str = sc.nextLine();
        permutaionOfString(str,"");
    }
    public static void permutaionOfString(String str , String answer){
        if(str.length()==0){
            System.out.println(answer);
            return;
        }
        for(int i=0;i<str.length();i++){
            char first = str.charAt(i);
            String remainingLeftPart = str.substring(0,i);
            String remainingRightPart = str.substring(i+1);
            String remainingPart = remainingLeftPart + remainingRightPart;
            permutaionOfString(remainingPart, answer+first);
        }
    }
}
