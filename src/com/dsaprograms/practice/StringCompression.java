package com.dsaprograms.practice;
import java.util.Scanner;
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
