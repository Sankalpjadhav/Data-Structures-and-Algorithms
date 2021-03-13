package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode: 49 Group shifted strings
1. You are given an array of strings.
2. You have to group the given strings in such a way that all strings in a group are shifted versions of each other.
3. Two strings s1 and s2 are shifted if -
   -> Length of both the strings is the same.
   -> The difference between ASCII values of every character of s1 and s2 is constant.

Note -> Every string consists of lower-case English letters only.
Sample Input
9
acd dfg wyz yab mop bdfh a x moqs

Sample Output
acd dfg mop wyz yab
a x
bdfh moqs
 */
public class LeetCode49GroupShiftedStrings {

    public static String getKey(String str) {
        String key = "";
        for(int i=1;i<str.length();i++){
            char currentChar = str.charAt(i);
            char prevChar = str.charAt(i-1);
            int difference = currentChar - prevChar;
            if(difference < 0 ){
                difference = difference + 26;
            }
            key += difference+"#";
        }
        return key;
    }
    public static ArrayList<ArrayList<String>> groupShiftedStrings(String [] strs){
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for(String str: strs){
            String key = getKey(str);
            if(map.containsKey(key)){
                ArrayList<String> shiftedStrings = map.get(key);
                shiftedStrings.add(str);
            }
            else{
                ArrayList<String> newStrings = new ArrayList<>();
                newStrings.add(str);
                map.put(key,newStrings);
            }
        }

        for(ArrayList<String> strings : map.values()){
            result.add(strings);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] strs = new String[n];
        for(int i=0;i<n;i++){
            strs[i] = sc.next();
        }
        System.out.println("Groups of shifted strings: "+groupShiftedStrings(strs));
    }
}
