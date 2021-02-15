package com.dsaprograms.bitmanipulation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
LeetCode: 1178. Number of Valid Words for Each Puzzle | Number Of Valid Words
1. You are given N number of words.
2. You are given M puzzles in the form of M strings.
3. For a given puzzle, a word is valid if both the following conditions are confirmed -
    Condition 1 -> Word contains the first letter of puzzle.
    Condition 2 -> For each letter in word, that letter should be present in puzzle.
4. You have to print the number of valid words corresponding to a puzzle.
Sample Input
7
aaaa asas able ability actt actor access
6
aboveyz abrodyz abslute absoryz actresz gaswxyz
Sample Output
aboveyz -> 1
abrodyz -> 1
abslute -> 3
absoryz -> 2
actresz -> 4
gaswxyz -> 0
 */
public class ValidWordsForEachPuzzle {
    public static ArrayList<Integer> numberOfValidWords(String [] words, String [] puzzles){
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put( (char)('a'+i), new ArrayList<Integer>());
        }

        for(String word:words){
            int wordMask = 0;
            for(char ch:word.toCharArray()){
                int bit = ch - 'a';
                wordMask = wordMask | (1<<bit);
            }
            HashSet<Character> set = new HashSet<>();
            for(char ch:word.toCharArray()){
                if(set.contains(ch)){
                    continue;
                }
                set.add(ch);
                map.get(ch).add(wordMask);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(String puzzle:puzzles) {
            int puzzleMask = 0;
            for (char ch : puzzle.toCharArray()) {
                int bit = ch - 'a';
                puzzleMask = puzzleMask |   (1 << bit);
            }

            char firstCharacter = puzzle.charAt(0);
            ArrayList<Integer> wordsToCheck = map.get(firstCharacter);
            int count = 0;
            for (int wordMask: wordsToCheck) {
                if((wordMask & puzzleMask)==wordMask) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfWords = sc.nextInt();
        String [] words = new String[numberOfWords];
        for (int i=0;i<numberOfWords;i++){
            words[i] = sc.next();
        }
        int numberOfPuzzles = sc.nextInt();
        String [] puzzles = new String[numberOfPuzzles];
        for (int i=0;i<numberOfPuzzles;i++){
            puzzles[i] = sc.next();
        }

        ArrayList<Integer> result = numberOfValidWords(words, puzzles);
        for(int i=0;i<result.size();i++){
            System.out.println(puzzles[i]+"->"+result.get(i));
        }
    }
}
