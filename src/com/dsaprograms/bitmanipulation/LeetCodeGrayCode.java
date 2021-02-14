package com.dsaprograms.bitmanipulation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
LeetCode: 89. Gray Code
The gray code is a binary numeral system where two successive values differ in only one bit.
Given an integer n representing the total number of bits in the code, return any sequence of gray code.
A gray code sequence must begin with 0.
Example 1:
Input: n = 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2
[0,2,3,1] is also a valid gray code sequence.
00 - 0
10 - 2
11 - 3
01 - 1
Example 2:
Input: n = 1
Output: [0,1]
 */
public class LeetCodeGrayCode {
    public static List<String> calculateGrayCode(int n){
        if(n==1){
            List<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }
        List<String> initialCode = calculateGrayCode(n-1);
        List<String> resultantGrayCode = new ArrayList<String>();

        for(int i=0;i<initialCode.size();i++){
            String grayCode = initialCode.get(i);
            resultantGrayCode.add("0"+grayCode);
        }

        for(int i=initialCode.size()-1;i>=0;i--){
            String grayCode = initialCode.get(i);
            resultantGrayCode.add("1"+grayCode);
        }

        return resultantGrayCode;
    }

    public static List<Integer> grayCode(int n) {
        List<String> stringFormat =  calculateGrayCode(n);
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<stringFormat.size();i++){
            String element = stringFormat.get(i);
            result.add(Integer.parseInt(element,2));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(grayCode(n));
    }
}
