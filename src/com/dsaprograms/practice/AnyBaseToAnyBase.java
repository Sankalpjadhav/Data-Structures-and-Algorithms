package com.dsaprograms.practice;
import java.util.Scanner;
public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sourceBase = sc.nextInt();
        int destinationBase = sc.nextInt();
        int convertedResult = anyBaseToAnyBase(n, sourceBase, destinationBase);
        System.out.println(convertedResult);
    }

    public static int anyBaseToAnyBase(int n, int sourceBase, int destinationBase){
        int result = 0;
        int i=1;
        while(n>0){
            int remainder = n % destinationBase;
            result = result + remainder * i;
            i = i * sourceBase;
            n = n / destinationBase;
        }
        return result;
    }
}
