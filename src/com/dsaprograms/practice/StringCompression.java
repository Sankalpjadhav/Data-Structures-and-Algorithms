package com.dsaprograms.practice;
import java.util.Scanner;
/*
(443.) String Compression
Given an array of characters chars, compress it using the following algorithm:
Begin with an empty string s. For each group of consecutive repeating characters in chars:
If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
After you are done modifying the input array, return the new length of the array.
Follow up:
Could you solve it using only O(1) extra space?

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

["a","b","b","b","b","b","b","b","b","b","b","b","b"]
["a","b","1","2"]
 */
public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        char [] ch =new char[n];
        for(int i=0; i<ch.length ;i++){
            ch[i]= sc.next().charAt(0);
        }
        int newLength = compress(ch);
        System.out.println(newLength);
    }
    public static int compress(char[] chars) {
        int prevIndex=0, currentIndex=0;
        while(currentIndex < chars.length){
            char currentChar = chars[currentIndex];
            int count=0;
            // 0 instead of 1 because in below while loop it will increment by 1 for different char.
            while(currentIndex < chars.length && currentChar == chars[currentIndex]){
                currentIndex++;
                count++;
            }
            chars[prevIndex++] = currentChar;
            if(count>1){
                for(char c: Integer.toString(count).toCharArray()){ // this is used instead of (char)(count+'0')(count =12 -> result of this is 12) because if b is occuring 12 times then chars array should have '1','2'.
                    chars[prevIndex++]= c;
                }
            }
        }
        return prevIndex;

    }

}
