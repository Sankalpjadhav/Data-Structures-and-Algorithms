package com.dsaprograms.practice;
import java.util.Scanner;
public class DecimalToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int convertedResult = decimalToAnyBase(n,b);
        System.out.println(convertedResult);
    }

    public static int decimalToAnyBase(int n, int b){
        int result = 0;
        int i=1;
        while(n>0){
            int remainder  = n % b;
            result  = result + remainder * i;
            i = i * 10;
            n = n/b;
        }
        return result;
    }
}
