package com.dsaprograms.recursion;
import java.util.HashMap;
import java.util.Scanner;
/*
Same question as that of PermutationOfAString2.java nut different approach.
1. You are given a word (may have one character repeat more than once).
2. You are required to generate and print all arrangements of these characters.
Sample Input
aabb
Sample Output
aabb
abab
abba
baab
baba
bbaa
 */
public class PermutationOfAString3 {

    public static void generateWords(String str, int spot, HashMap<Character, Integer> occurenceMap, Character [] spots){
        if(spot==str.length()){
            for(char ch:spots){
                System.out.print(ch);
            }
            System.out.println();
            return;
        }
        char ch = str.charAt(spot);
        int lastOccurence = occurenceMap.get(ch);
        for(int i=lastOccurence+1;i<str.length();i++){
            if(spots[i]==null){
                spots[i]=ch;
                occurenceMap.put(ch, i);
                generateWords(str, spot+1, occurenceMap, spots);
                occurenceMap.put(ch, lastOccurence);
                spots[i]=null;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Character [] spots = new Character[str.length()];
        HashMap<Character, Integer> occurenceMap = new HashMap<>();
        for(char ch: str.toCharArray()){
            occurenceMap.put(ch, -1);
        }
        generateWords(str, 0, occurenceMap, spots);
    }
}
