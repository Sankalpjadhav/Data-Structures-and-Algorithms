package com.dsaprograms.practice;
import java.util.Scanner;
public class AnyBaseAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        int base = sc.nextInt();
        int result = anyBaseAddition(base, firstNumber, secondNumber);
        System.out.println(result);
    }
    public static int anyBaseAddition(int base, int firstNumber, int secondNumber){
        int result = 0;
        int i = 1;
        int carry = 0;
        while(firstNumber!=0 || secondNumber!=0 || carry!=0){
            int firstDigit = firstNumber % 10;
            int secondDigit = secondNumber % 10;
            int digit = firstDigit + secondDigit + carry;
            carry = digit / base;
            digit = digit % base;
            result = result + digit * i;
            i = i * 10;
            firstNumber = firstNumber / 10;
            secondNumber = secondNumber / 10;
        }
        return result;
    }
}
