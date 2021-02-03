package com.dsaprograms.recursion;
import java.util.Scanner;
/*
LeetCode:1255. Maximum Score Words Formed by Letters
Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
Example 1:
Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
Output: 23
Explanation:
Score  a=1, c=9, d=5, g=3, o=2
Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
Words "dad" and "dog" only get a score of 21.
Example 2:
Input: words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]
Output: 27
Explanation:
Score  a=4, b=4, c=4, x=5, z=10
Given letters, we can form the words "ax" (4+5), "bx" (4+5) and "cx" (4+5) with a score of 27.
Word "xxxz" only get a score of 25.
Example 3:
Input: words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
Output: 0
Explanation:
Letter "e" can only be used once.
 */
public class MaxScoreOfWords {

    static int solution(String [] words, int [] frequency, int [] score, int index){
        if(index == words.length){
            return 0;
        }
        // Do not include word
        int wordNotIncluded = 0 + solution(words, frequency, score, index+1);

        // Include the word
        int scoreWord = 0;
        boolean flag = true; // To include word - true
        String word = words[index];
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(frequency[ch -'a']==0){
                flag = false; // To include word? - false (Because the frequency of the character is zero)
            }
            frequency[ch-'a']--;
            scoreWord += score[ch-'a'];
        }
        int wordIncluded=0;
        if(flag == true){ // Then only call solution
            wordIncluded = scoreWord + solution(words, frequency, score, index+1);
        }
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            frequency[ch-'a']++;
        }
        return Math.max(wordNotIncluded, wordIncluded);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null ||
                score.length == 0) {
            System.out.println(0);
            return;
        }
        int[] frequency = new int[score.length];
        for (char ch: letters) {
            frequency[ch - 'a']++;
        }
        System.out.println(solution(words, frequency, score, 0));
    }
}
