package com.dsaprograms.practice;
import java.util.Scanner;
public class AnyBaseSubtraction {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int base = sc.nextInt();
    // numberOne is always greater than or equal to numberTwo.
    int numberOne = sc.nextInt();
    int numberTwo = sc.nextInt();
    int result = anyBaseSubtraction(base, numberOne, numberTwo);
    System.out.println(result);
    }

    public static int anyBaseSubtraction(int base, int numberOne, int numberTwo){
        int result = 0;
        int carry =0; // borrow.
        int i = 1;
        while(numberOne > 0){
            int digitOne = numberOne % 10;
            int digitTwo = numberTwo % 10;
            int digit =0;
            digitOne = digitOne + carry;
            if(digitOne>=digitTwo){
                carry = 0;
                digit = digitOne - digitTwo;
            }
            else {
                carry = -1;
                digit = digitOne + base - digitTwo;
            }
            result = result + digit * i;
            i = i * 10;
            numberOne = numberOne / 10;
            numberTwo = numberTwo / 10;
        }
        return result;
    }
}