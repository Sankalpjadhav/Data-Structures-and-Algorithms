package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.Scanner;
/*
1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
2. The following list is the key to characters map :
    0 -> .;
    1 -> abc
    2 -> def
    3 -> ghi
    4 -> jkl
    5 -> mno
    6 -> pqrs
    7 -> tu
    8 -> vwx
    9 -> yz
3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
Use sample input and output to take idea about output.
Input: 78
Output: [tv, tw, tx, uv, uw, ux]
*/
public class KeypadCombination {
    public static void main(String [] args){
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> result = getKeypadCombination(str);
        System.out.println(result);
    }
    static String [] keypadCodes ={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKeypadCombination(String str){
        if(str.length()==0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        char first = str.charAt(0);
        String remaining = str.substring(1);
        ArrayList<String> remainingResult = getKeypadCombination(remaining);
        String firstString = keypadCodes[first - '0'];
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0;i< firstString.length();i++){
            char c = firstString.charAt(i);
            for(String s : remainingResult){
                result.add(c+s);
            }
        }
        return result;
    }
}
