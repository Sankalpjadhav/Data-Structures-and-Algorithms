package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Check if two strings are K Anagrams.
1. You are given two strings s1, s2, and a number K.
2. You have to find if two strings are K-anagrams of each other or not.
3. Two strings are called K-anagrams if
   -> Both s1 and s2 have the same number of characters.
   -> After changing K characters in any string, s1 and s2 become anagram of each other.

Note -> Both s1 ad s2 consist of lowercase English letters only.
Sample Input
fodr
gork
2
Sample Output
true
 */
public class CheckTwoStringKAnagrams {
    public static boolean areKAnagrams(String str1, String str2, int k){
        if(str1.length() != str2.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<str2.length();i++){
            char ch = str2.charAt(i);
            if(map.getOrDefault(ch,0)>0){
                map.put(ch, map.get(ch)-1);
            }
        }

        int count = 0;
        for(char ch : map.keySet()){
            count+=map.get(ch);
        }

        if(count>k){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int k = sc.nextInt();
        System.out.println("If two strings are K-anagrams: "+areKAnagrams(str1, str2, k));
    }
}
