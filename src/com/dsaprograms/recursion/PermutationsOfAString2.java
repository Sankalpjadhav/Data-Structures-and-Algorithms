package com.dsaprograms.recursion;
import java.util.HashMap;
import java.util.Scanner;
/*
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
public class PermutationsOfAString2 {

    public static void permutationsOfDuplicates(int currentState, int totalState, HashMap<Character, Integer> frequencyMap, String answerSoFar){
        if(currentState > totalState){
            System.out.println(answerSoFar);
            return;
        }
        for(char ch:frequencyMap.keySet()){
            if(frequencyMap.get(ch)>0){
                frequencyMap.put(ch, frequencyMap.get(ch)-1);
                permutationsOfDuplicates(currentState+1, totalState, frequencyMap, answerSoFar+ch);
                frequencyMap.put(ch, frequencyMap.get(ch)+1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(frequencyMap.containsKey(ch)){
                frequencyMap.put(ch, frequencyMap.get(ch)+1);
            }
            else{
                frequencyMap.put(ch, 1);
            }
        }
        permutationsOfDuplicates(1, str.length(), frequencyMap, "");
    }
}
