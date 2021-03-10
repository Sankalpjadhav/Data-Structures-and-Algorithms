package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode:  76. Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/
Given two strings s and t, return the minimum window in s which will contain all the characters in t.
If there is no such window in s that covers all characters in t, return the empty string "".
Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:
Input: s = "a", t = "a"
Output: "a"
 */
public class LeetCode76MinWindowSubstring {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> mapOfT = new HashMap<>();
        String answer = "";
        // Find frequency of each characters for string t
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            mapOfT.put(ch,mapOfT.getOrDefault(ch,0)+1);
        }
        HashMap<Character, Integer> mapOfS = new HashMap<>();
        int i=-1,j=-1;
        int matchCount = 0;
        int desiredCount = t.length();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;

            //Acquire
            while(i<s.length()-1 && matchCount < desiredCount){
                i++;
                char ch = s.charAt(i);
                mapOfS.put(ch, mapOfS.getOrDefault(ch,0)+1);

                if(mapOfS.getOrDefault(ch,0) <= mapOfT.getOrDefault(ch,0)){
                    matchCount++;
                }
                flag1 = true;
            }
            // After coming out from the above loop matchCount is equal to desiredCount
            // Collect answer and release

            while(j<i && matchCount == desiredCount){
                String presentAnswer = s.substring(j+1,i+1);
                if(answer.length()==0 || presentAnswer.length() < answer.length()){
                    answer = presentAnswer;
                }
                j++;
                char ch = s.charAt(j);
                if(mapOfS.get(ch)==1){
                    mapOfS.remove(ch);
                }
                else{
                    mapOfS.put(ch, mapOfS.get(ch)-1);
                }

                if(mapOfS.getOrDefault(ch,0) < mapOfT.getOrDefault(ch,0)){
                    matchCount--;
                }
                flag2 = true;
            }

            if(flag1==false && flag2==false){
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println("Minimum window substring: "+minWindow(s,t));
    }
}
