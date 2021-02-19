package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
public class PowerOf2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int value = (n & (n-1));
        if(value == 0){
            System.out.println("Power of 2: "+true);
            return;
        }
        System.out.println("Power of 2: "+false);
    }
}
