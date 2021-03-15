package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode: 166. Fraction to Recurring Decimal.
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.
If multiple answers are possible, return any of them.
It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:
Input: numerator = 2, denominator = 1
Output: "2"
Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"
Example 4:
Input: numerator = 4, denominator = 333
Output: "0.(012)"
Example 5:
Input: numerator = 1, denominator = 5
Output: "0.2"
 */
public class LeetCode166FractionToRecurrDec {
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        if((numerator < 0 && denominator > 0)|| (numerator > 0 && denominator < 0)){
            ans.append("-");
        }
        long q = numerator / denominator;
        long r = numerator % denominator;
        q = Math.abs(q);
        ans.append(q);
        r = Math.abs(r);
        if (r == 0)
            return ans.toString();
        else {
            ans.append(".");
            HashMap< Long, Integer > map = new HashMap < > ();
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
            while (r != 0) {
                if (map.containsKey(r)) {
                    int pos = map.get(r);
                    ans.insert(pos, "(");
                    ans.append(")");
                    break;
                } else {
                    map.put(r,ans.length());
                    r *= 10;
                    q = r / denominator;
                    r = r % denominator;
                    ans.append(Math.abs(q));
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numerator = sc.nextInt();
        int denominator = sc.nextInt();
        System.out.println("Fraction to Recurring Decimal: "+fractionToDecimal(numerator,denominator));
    }
}
