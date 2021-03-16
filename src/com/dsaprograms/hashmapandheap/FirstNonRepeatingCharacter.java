package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
First Non-repeating Character
1. You are given a string.
2. You have to find the index of the first non-repeating character in the given string.
3. If no such character exists, print "-1".
Sample input:
abbcaddecfab
Sample output:
First Non repeating character: e at index: 7
 */
public class FirstNonRepeatingCharacter {
    public static void firstNonRepeatingCharacter(String str){
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch,0)+1);
        }
        char ch = '\0';
        int i;
        for(i=0;i<str.length();i++){
            if(frequencyMap.get(str.charAt(i))==1){
                ch = str.charAt(i);
                break;
            }
        }

        if(ch=='\0'){
            System.out.println("-1");
            return;
        }
        System.out.println("First Non repeating character: "+ch+" at index: "+i);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        firstNonRepeatingCharacter(str);
    }
}
