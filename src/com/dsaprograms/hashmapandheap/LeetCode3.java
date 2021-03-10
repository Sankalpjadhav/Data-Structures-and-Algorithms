package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode: 3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/

On similar lines that of LeetCode:  76. Minimum Window Substring and MinWindowSubstring2.java
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 */
public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        String answer = "";
        int i=-1,j=-1;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            //Acquire and collect answer
            while(i<s.length()-1){
                flag1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);

                if(map.get(ch)>1){
                    break;
                }

                String possibleAnswer = s.substring(j+1,i+1);
                if(possibleAnswer.length() > answer.length()){
                    answer = possibleAnswer;
                }

            }
            // Release
            while(j<i){
                flag2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==1){
                    break;
                }

            }
            if(flag1==false && flag2==false){
                break;
            }
        }

        return answer.length();

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Longest Substring Without Repeating Characters: "+lengthOfLongestSubstring(s));
    }
}
