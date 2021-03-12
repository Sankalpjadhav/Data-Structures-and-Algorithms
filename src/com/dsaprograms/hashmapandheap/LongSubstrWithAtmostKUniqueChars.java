package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Longest Substring With At Most K Unique Characters
1. You are given a string(str) and a number K.
2. You have to find the length of longest substring of the given string that contains at most K unique characters.
Sample Input
aabcbcdbca
2
Sample Output
4
 */
public class LongSubstrWithAtmostKUniqueChars {
    public static String longestSubstring(String str, int k){
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        int i=-1,j=-1;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            // Acquire
            while(i<str.length()-1){
                flag1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size() <= k){
                    String possibleAnswer = str.substring(j+1,i+1);
                    if(possibleAnswer.length() > answer.length()){
                        answer = possibleAnswer;
                    }
                }
                else{
                    break;
                }
            }
            // release
            while(j<i){
                flag2 = true;
                j++;
                char ch = str.charAt(j);
                if(map.get(ch)==1){
                    map.remove(ch);
                }
                else{
                    map.put(ch, map.get(ch)-1);
                }

                if(map.size()<=k){
                    String possibleAnswer = str.substring(j+1,i+1);
                    if(possibleAnswer.length() > answer.length()){
                        answer = possibleAnswer;
                    }
                    break;
                }
            }

            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        System.out.println("Longest substring with atmost k unique characters: "+longestSubstring(str, k));
    }
}
