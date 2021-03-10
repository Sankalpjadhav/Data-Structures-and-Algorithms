package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Count Of Substrings Having All Unique Characters or no repeating characters.
1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.
Sample Input
aabcbcdbca
Sample Output
24
 */
public class CountSubstringsWithNoRepeatingChars {
    public static int countSubstrings(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int i=-1,j=-1;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            // Acquire and collect answer
            while(i<str.length()-1){
                flag1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)==2){
                    break;
                }
                count += i-j;
                /*
                If there is a requirement to get all substrings with no repeating characters
                Then instead of count line. We can add all the substrings from j to i into arraylist. simillarly on line 50.
                 bcd
                j  i
                Then,
                bcd
                 cd
                  d
                */
            }
            // Release
            while(j<i){
                flag2 = true;
                j++;
                char ch = str.charAt(j);
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==1){
                    count += i-j;
                    break;
                }
            }
            if(flag1==false && flag2==false){
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Count Of Substrings Having All Unique Characters or no repeating characters: "+countSubstrings(str));
    }
}
