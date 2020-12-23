package com.dsaprograms.practice;
import java.util.Scanner;
public class AnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int convertedResult = anyBaseToDecimal(n, b);
        System.out.println(convertedResult);
    }

    public static int anyBaseToDecimal(int n, int b){
        int result = 0;
        int i=1;
        while (n>0){
            int remainder = n % 10;
            result = result + remainder * i;
            i = i * b; // Multiply i with the number base which you want to convert.
            n = n / 10; // Divide by the base you want to convert to.
        }
        return result;
    }
}
