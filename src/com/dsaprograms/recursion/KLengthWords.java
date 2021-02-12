package com.dsaprograms.recursion;
import java.util.HashSet;
import java.util.Scanner;
/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the
     word.
Input:
abcabc
2
Output:
ab
ac
ba
ca
bc
cb
*/
public class KLengthWords {
    public static void getKLengthWords(int currentCharacter, int totalSpots, int spot, String uniqueString, Character [] spots){
        if(currentCharacter == uniqueString.length()){
            if(spot==totalSpots){
                for(char ch: spots){
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }

        char ch =uniqueString.charAt(currentCharacter);
        // To include k Spots
        for(int i=0;i<spots.length;i++){
            if(spots[i]==null){
                spots[i] = ch;
                getKLengthWords(currentCharacter+1, totalSpots, spot+1, uniqueString, spots);
                spots[i]=null;
            }
        }
        // Not to include any spots
        getKLengthWords(currentCharacter+1, totalSpots, spot+0, uniqueString, spots);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        HashSet<Character> set = new HashSet<Character>();
        String uniqueString = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                uniqueString+=ch;
            }
        }
        Character[] spots = new Character[k];
        getKLengthWords(0, k, 0, uniqueString, spots);
    }
}
