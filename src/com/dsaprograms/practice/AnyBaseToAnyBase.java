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
        int inDecimal = getInDecimal(n, sourceBase);
        int inDestinalBase = getInDestinationBase(inDecimal, destinationBase);
        return inDestinalBase;
    }

    public static int getInDecimal(int n, int sourceBase){
        int inDecimal = 0;
        int i = 1;
        while(n>0){
            int remainder = n % 10;
            inDecimal = inDecimal + remainder * i;
            i = i * sourceBase;
            n = n / 10;
        }
        return inDecimal;
    }

    public static int getInDestinationBase(int n, int destinationBase){
        int result = 0;
        int i = 1;
        while(n>0){
            int remainder = n % destinationBase;
            result = result + remainder * i;
            i = i * 10;
            n = n / destinationBase;
        }
        return result;
    }

}
