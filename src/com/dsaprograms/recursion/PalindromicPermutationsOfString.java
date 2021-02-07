package com.dsaprograms.recursion;
import java.util.HashMap;
import java.util.Scanner;
/*
267. Palindrome Permutation II
1. You are given a string of length n.
2. You have to print all the palindromic permutations of the given string.
3. If no palindromic permutation exists for the given string, print "No Palindromic permutations possible".
 */
public class PalindromicPermutationsOfString {

    public static void generatePalindromicPermutations(int currentSpot, int totalSpot, HashMap<Character, Integer> frequencyMap, Character oddCharacter, String answerSoFar){
        if(currentSpot>totalSpot){
            String reverseString = "";
            for(int i=answerSoFar.length()-1;i>=0;i--){
                reverseString += answerSoFar.charAt(i);
            }
            String result = answerSoFar;
            if(oddCharacter!=null){
                result+=oddCharacter;
            }
            result+=reverseString;
            System.out.println(result);
            return;
        }
        for(Character ch: frequencyMap.keySet()){
            int frequency = frequencyMap.get(ch);
            if(frequency > 0) {
                frequencyMap.put(ch, frequency - 1);
                generatePalindromicPermutations(currentSpot + 1, totalSpot, frequencyMap, oddCharacter, answerSoFar + ch);
                frequencyMap.put(ch, frequency); // Backtracking -> added frequency instead of frequency+1 because:
            /*
            eg: Let us say a's frequency is 3
            we will decrease 1 and call  generatePalindromicPermutations -> (a's frequency is 2)
            After coming back we need to backtrack. so we need to have a's frequency to be 3
            if we use frequencyMap.put(ch, frequency+1) -> Then a's frequency will become 3+1 = 4 which is wrong
            Since we have 3 already in frequency variable so we use frequencyMap.put(ch, frequency);
             */
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        // Count of characters
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(frequencyMap.containsKey(ch)){
                int oldFrequency = frequencyMap.get(ch);
                frequencyMap.put(ch, oldFrequency+1);
            }
            else{
                frequencyMap.put(ch,1);
            }
        }
        Character oddCharacter=null;
        int numOfOddCharacters = 0;
        int lengthOfNewString=0;
        for(Character ch:frequencyMap.keySet()){
            int frequency = frequencyMap.get(ch);
            if(frequency%2==1){
                oddCharacter = ch;
                numOfOddCharacters++;
            }
            frequencyMap.put(ch,frequency/2);
            lengthOfNewString += frequency/2;
        }

        if(numOfOddCharacters>1){
            System.out.println("No palindromic permutations is possibble.");
            return;
        }

        generatePalindromicPermutations(1, lengthOfNewString, frequencyMap, oddCharacter, "");
    }
}
