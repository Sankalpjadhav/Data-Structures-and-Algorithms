package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode 205. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.
Example 1:
Input: s = "egg", t = "add"
Output: true
Example 2:
Input: s = "foo", t = "bar"
Output: false
Example 3:
Input: s = "paper", t = "title"
Output: true
 */
public class LeetCode205IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()==1){
            return s.charAt(0)==t.charAt(0);
        }
        HashMap<Character, Boolean> used = new HashMap<>();
        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if(!map.containsKey(sCh)){
                if(used.containsKey(tCh)){
                    return false;
                }
                else{
                    map.put(sCh,tCh);
                    used.put(tCh,true);
                }
            }
            else{
                if(map.get(sCh)!=tCh){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println("Isomorphic strings: "+isIsomorphic(s,t));
    }
}
