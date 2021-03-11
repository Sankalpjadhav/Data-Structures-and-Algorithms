package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Longest substring with exactly k non repeating characters.
1. You are given a string(str) and a number K.
2. You have to find length of the longest substring that has exactly k unique characters.
3. If no such substring exists, print "-1".
Sample Input
aabcbcdbca
2
Sample Output
4
 */
public class LongestSubstringWithExactlyKNonRC {
    public static String longestSubstring(String str, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        String answer = "";
        int i=-1,j=-1;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            //Acquire and collect answer
            while(i<str.length()-1){
                flag1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size() > k){
                    break;
                }
                else if(map.size() < k){
                    continue;
                }
                else { // equal to k
                    String potentialAnswer = str.substring(j + 1, i + 1);
                    if (potentialAnswer.length() > answer.length()) {
                        answer = potentialAnswer;
                    }
                }
            }
            // Release and collect answer
            while (j<i){
                flag2 = true;
                j++;
                char ch = str.charAt(j);
                if(map.get(ch)==1){
                    map.remove(ch);
                }
                else {
                    map.put(ch, map.get(ch) - 1);
                }

                if(map.size() > k){
                    continue;
                }
                else if(map.size()==k){ // equal to k
                    String potentialAnswer = str.substring(j + 1, i + 1);
                    if (potentialAnswer.length() > answer.length()) {
                        answer = potentialAnswer;
                    }
                    break;
                }
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
        int k = sc.nextInt();
        System.out.println("Length of the longest substring that has exactly k unique characters: "+longestSubstring(str, k));
    }
}
