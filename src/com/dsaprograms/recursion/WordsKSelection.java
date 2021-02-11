package com.dsaprograms.recursion;
import java.util.HashSet;
import java.util.Scanner;
/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the
     word.
Sample Input
aabbbccdde
3
Sample Output
abc
abd
abe
acd
ace
ade
bcd
bce
bde
cde
 */
public class WordsKSelection {

    public static void selectDistinctChars(int currentChar, String uniqueCharacters, String answer, int spots){
        if(currentChar==uniqueCharacters.length()){
            if(answer.length()==spots){
                System.out.println(answer);
            }
            return;
        }
        char ch = uniqueCharacters.charAt(currentChar);
        selectDistinctChars(currentChar+1, uniqueCharacters, answer+ch, spots);
        selectDistinctChars(currentChar+1, uniqueCharacters, answer, spots);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        HashSet<Character> set = new HashSet<>();
        String uniqueCharacters = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                uniqueCharacters+=ch;
            }
        }
        selectDistinctChars(0, uniqueCharacters, "", k);
    }
}
