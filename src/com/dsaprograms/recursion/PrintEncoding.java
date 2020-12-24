package com.dsaprograms.recursion;
import java.util.Scanner;
/*
1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
Use the input-output below to get more understanding on what is required
123 -> abc, aw, lc
993 -> iic
013 -> Invalid input. A string starting with 0 will not be passed.
103 -> jc
303 -> No output possible. But such a string maybe passed. In this case print nothing.

Input:655196
Output:
feeaif
feesf
 */
public class PrintEncoding {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printEncoding(str,"");
    }

    public static void printEncoding(String str, String answer){
        if(str.length()==0){
            System.out.println(answer);
            return;
        }
        else if(str.length()==1){
            char ch = str.charAt(0);

            if(ch == '0'){
                return;
            }
            else{
                int chValue = ch - '0';
                char convertedChar = (char)('a'+ chValue-1);
                System.out.println(answer+convertedChar);
            }
        }
        else{
            char c = str.charAt(0);
            String cRemaining = str.substring(1);
            if(c == '0'){
                return;
            }
            else{
                int chValue = c - '0';
                char convertedChar = (char)('a'+ chValue-1);
                printEncoding(cRemaining,answer+convertedChar);
            }

            String char12 = str.substring(0,2);
            String char12Remaining = str.substring(2);
            int char12Value = Integer.parseInt(char12);
            if(char12Value<=26){
                char convertedChar12 = (char)('a'+ char12Value-1);
                printEncoding(char12Remaining,answer+convertedChar12);
            }
        }
    }
}
