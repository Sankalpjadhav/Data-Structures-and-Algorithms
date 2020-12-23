package com.dsaprograms.practice;
import java.util.Scanner;
public class ToggleCase {
    public static String toggleCase(String str){
        //write your code here
        StringBuilder sb=new StringBuilder(str);
        for(int i=0;i<sb.length();i++){
            char currentChar=sb.charAt(i);
            if(currentChar >='a' && currentChar <='z'){
                // Lower to upper
                char ch= (char)('A'+currentChar-'a');
                sb.setCharAt(i, ch);
            }
            else if(currentChar >='A' && currentChar <='Z'){
                // upper to lower
                char ch= (char)('a'+currentChar-'A');
                sb.setCharAt(i,ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }
}
