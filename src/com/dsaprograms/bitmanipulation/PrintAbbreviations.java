package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
Print Abbreviations using Bit Manipulation
1. You are given a word.
2. You have to generate all abbreviations of that word.
Sample Input
pep
Sample Output
pep
pe1
p1p
p2
1ep
1e1
2p
3
 */
public class PrintAbbreviations {
    public static void printAbbreviations(String str){
        for(int i=0;i<(1<<str.length());i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j=0;j<str.length();j++){
                char ch = str.charAt(j);
                int b = str.length()-1-j; // Since bits are addressed from right to left and in case of string it is addressed from left to right.
                if((i&(1<<b))==0){
                    if(count==0){
                        sb.append(ch);
                    }
                    else{
                        sb.append(count);
                        sb.append(ch);
                        count=0;
                    }
                }
                else{ // 1
                    count++;
                }
            }
            if(count>0){
                sb.append(count);
            }
            System.out.println(sb);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printAbbreviations(str);
    }
}
