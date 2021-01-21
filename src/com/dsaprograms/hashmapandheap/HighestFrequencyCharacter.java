package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(hashMap.containsKey(ch)){
                int oldValue = hashMap.get(ch);
                int newValue = oldValue + 1;
                hashMap.put(ch,newValue);
            }
            else{
                hashMap.put(ch,1);
            }
        }

        char maxFrequencyCharacter = str.charAt(0);
        for(Character key:hashMap.keySet()){
            if(hashMap.get(key) > hashMap.get(maxFrequencyCharacter)){
                maxFrequencyCharacter = key;
            }
        }

        System.out.println(maxFrequencyCharacter);
    }
}
