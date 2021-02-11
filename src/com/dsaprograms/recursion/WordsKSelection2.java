package com.dsaprograms.recursion;
import java.util.HashSet;
import java.util.Scanner;
/*
Similar question as that of WordsKSelection.java but different approach.
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the
     word
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
public class WordsKSelection2 {

    public static void wordsKSelection(String uniqueString, int lastCharacter, int currentSelection, int totalSpots, String answer){
        if(currentSelection>totalSpots){
            System.out.println(answer);
            return;
        }

        for(int i=lastCharacter+1;i<uniqueString.length();i++){
            char ch = uniqueString.charAt(i);
            wordsKSelection(uniqueString, i, currentSelection+1, totalSpots, answer+ch);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        HashSet<Character> set = new HashSet<>();
        String uniqueString = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                uniqueString+=ch;
            }
        }
        wordsKSelection(uniqueString, -1, 1, k, "");
    }
}
