package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
Count Of Substrings Having At Most K Unique Characters
1. You are given a string(str) and a number K.
2. You have to find the count of substrings of the given string that contains at most K unique characters.
Sample Input
aabcbcdbca
2
Sample Output
23
 */
public class CountSubstrWithAtmostKDistinceChars {
    public static int coutnSubstrings(String str, int k){
        int count = 0;
        int i = -1,j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            while(i<str.length()-1){
                flag1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size()<=k){
                  count += i-j;
                }
                else{
                    break;
                }
            }

            while(j<i){
                flag2 = true;
                j++;
                char ch = str.charAt(j);
                if(map.get(ch)==1){
                    map.remove(ch);
                }
                else{
                    map.put(ch,map.get(ch)-1);
                }
                if(map.size()<=k){
                    break;
                }else{
                    count += i-j;
                }
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        System.out.println("Count of substrings with atmost k unique characters: "+coutnSubstrings(str, k));
    }
}
