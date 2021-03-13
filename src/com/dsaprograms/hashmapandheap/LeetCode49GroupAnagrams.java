package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/*
LeetCode: 49. Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]
 */
public class LeetCode49GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length==1 && strs[0].length()==0){
            List<String> base = new ArrayList<>();
            base.add("");
            result.add(base);
            return result;
        }
        HashMap<HashMap<Character,Integer>, ArrayList<String>> map = new HashMap<>();
        for(String str:strs){
            HashMap<Character,Integer> strMap = new HashMap<>();
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                strMap.put(ch,strMap.getOrDefault(ch,0)+1);
            }

            if(map.containsKey(strMap)){
                ArrayList<String> list = map.get(strMap);
                list.add(str);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(strMap,list);
            }
        }

        for(ArrayList<String> value:map.values()){
            result.add(value);
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] strs = new String[n];
        for(int i=0;i<strs.length;i++){
            strs[i] = sc.next();
        }
        System.out.println("Group of Anagrams: "+groupAnagrams(strs));
    }
}
