package com.dsaprograms.recursion;
import java.util.HashMap;
import java.util.Scanner;
/*
1. You are given three strings s1, s2 and s3.
2. First two are supposed to add and form third. s1 + s2 = s3
3. You have to map each individual character to a digit, so that the above equation holds true.
Sample Input
team
pep
toppr
Sample Output
a-3 e-9 m-4 o-1 p-2 r-6 t-0
a-3 e-9 m-5 o-1 p-2 r-7 t-0
a-3 e-9 m-6 o-1 p-2 r-8 t-0
a-4 e-9 m-2 o-1 p-3 r-5 t-0
a-4 e-9 m-5 o-1 p-3 r-8 t-0
a-5 e-9 m-2 o-1 p-4 r-6 t-0
a-5 e-9 m-3 o-1 p-4 r-7 t-0
a-6 e-9 m-2 o-1 p-5 r-7 t-0
a-6 e-9 m-3 o-1 p-5 r-8 t-0
a-7 e-9 m-2 o-1 p-6 r-8 t-0
 */
public class CryptArithmeticPuzzle {

    static int getNum(String str, HashMap< Character, Integer > charIntMap){
        String number="";
        for(int i=0;i<str.length();i++){
            number += charIntMap.get(str.charAt(i));
        }
        return Integer.parseInt(number);
    }

    static void solveCryptArithmetic(String unique, int index, HashMap< Character, Integer > charIntMap, boolean [] usedNumbers, String s1, String s2, String s3){
        if(index==unique.length()){
            // Task
            int number1 = getNum(s1, charIntMap);
            int number2 = getNum(s2, charIntMap);
            int number3 = getNum(s3, charIntMap);
            if(number1+number2==number3){
                for(int i=0;i<26;i++){// In alphabetical order
                    char ch = (char)('a'+i);
                    if(charIntMap.containsKey(ch)){
                        System.out.print(ch+"-"+charIntMap.get(ch)+" ");
                    }
                }
                System.out.println();
            }
            return;
        }
        char ch = unique.charAt(index);
        for(int option=0;option<10;option++){
            if(usedNumbers[option]==false){
                charIntMap.put(ch,option);
                usedNumbers[option]=true;
                solveCryptArithmetic(unique, index+1, charIntMap, usedNumbers, s1, s2, s3);
                usedNumbers[option]=false;
                charIntMap.put(ch,-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();

        HashMap< Character, Integer > charIntMap = new HashMap < > ();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charIntMap.containsKey(s1.charAt(i))) {
                charIntMap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!charIntMap.containsKey(s2.charAt(i))) {
                charIntMap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            if (!charIntMap.containsKey(s3.charAt(i))) {
                charIntMap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }

        boolean[] usedNumbers = new boolean[10];
        solveCryptArithmetic(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
    }
}
