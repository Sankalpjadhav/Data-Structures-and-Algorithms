package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
Smallest Substring Of A String Containing All Unique Characters Of Itself
1. You are given a string str.
2. You have to find the smallest window length that contains all the unique characters of the given string.
Sample Input
aabcbcdbca
Sample Output
4
 */
public class MinWindowSubstring2 {
    public static String minWindow(String str){
        HashSet<Character> uniqueChars = new HashSet<Character>();
        for(int i=0;i<str.length();i++){
            uniqueChars.add(str.charAt(i));
        }
        int matchCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i=-1,j=-1;
        String answer = str; // Obviously entire string can contain its unique chars
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            //Acquire
            while(i<str.length()-1 && matchCount< uniqueChars.size()){
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                flag1=true;
            }
            // Collect answer and release
            while(j<i && map.size()== uniqueChars.size()){
                String possibleAnswer = str.substring(j+1,i+1);
                if(answer.length() ==0 || possibleAnswer.length() < answer.length()){
                    answer = possibleAnswer;
                }
                j++;
                char ch = str.charAt(j);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
                flag2=true;
            }

            if(flag1==false && flag2==false){
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("The smallest window length that contains all the unique characters of the given string: "+minWindow(str));
    }
}
