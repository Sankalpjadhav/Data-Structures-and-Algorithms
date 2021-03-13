package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.Scanner;
/*
LeetCode: 438. Find All Anagrams in a String
https://leetcode.com/problems/find-all-anagrams-in-a-string/
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */
public class LeetCode438FindAllAnagrams {
    public static boolean isAnagram(int [] patternFreqMap, int [] sourceFreqMap){
        for(int i=0;i<26;i++){
            if(patternFreqMap[i]!=sourceFreqMap[i]){
                return false;
            }
        }
        return true;
    }
    public static ArrayList<String> findAnagrams(String source, String pattern){
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();

        if(pattern.length() > source.length()){
            return result;
        }

        int [] sourceFreqMap = new int[26];
        int [] patternFreqMap = new int[26];
        int i;
        for(i=0;i<pattern.length();i++){
            char patternChar = pattern.charAt(i);
            patternFreqMap[patternChar-'a']++;
            char sourceChar = source.charAt(i);
            sourceFreqMap[source.charAt(i)-'a']++;
        }

        if(isAnagram(patternFreqMap,sourceFreqMap)==true){
            indexes.add(0);
            String anagram = source.substring(0,i);
            result.add(anagram);
        }
        sourceFreqMap[source.charAt(0)-'a']--; // Since we checked for first pattern.length() characters then we can able to release 1st character(j)
        int start = 1; // Nothing but j starting from 1
        for(;i<source.length();i++){
            char ch = source.charAt(i);
            //Acquire
            sourceFreqMap[ch-'a']++;
            if(isAnagram(patternFreqMap,sourceFreqMap)==true){
                indexes.add(start);
                String anagram = source.substring(start,i+1);
                result.add(anagram);
            }
            // Release
            sourceFreqMap[source.charAt(start)-'a']--;
            start++;
        }
        System.out.println("Count of Anagrams: "+indexes);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        String pattern = sc.nextLine();
        System.out.println("All Anagrams: "+findAnagrams(source, pattern));
    }
}
