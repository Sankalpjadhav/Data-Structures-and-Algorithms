package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Maximum Difference Of Zeros And Ones In Binary String
1. You are given a string containing only 0's and 1's.
2. You have to find the length of substring which is having maximum difference of number of 0s and number of 1s i.e (Number of 0's - Number of 1's).
3. If there are all 1's present in the given string, then print '-1'.
Sample Input
11000010001
Sample Output
6
 */
public class MaximumDifferenceOf0sAnd1s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int answer = 0;
        int currentSum = 0;
        for(int i=0;i<str.length();i++){
            int value = 0;
            if(str.charAt(i)=='1'){
                value = -1;
            }
            else if(str.charAt(i)=='0'){
                value = +1;
            }

            if(currentSum >= 0){
                currentSum += value;
            }
            else{
                currentSum = value;
            }

            if(currentSum > answer){
                answer = currentSum;
            }
        }

        if(answer==0){ // This indicates that there are no 0's : only 1's are present.
            answer = -1;
        }

        System.out.println("The length of substring which is having maximum difference of number of 0s and number of 1s: "+answer);
    }
}
