package com.dsaprograms.practice;
import java.util.Scanner;
public class AnyBaseMultiplication {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int base = sc.nextInt();
        // numberOne is always greater than or equal to numberTwo.
        int numberOne = sc.nextInt();
        int numberTwo = sc.nextInt();
        int result = anyBaseMultiplication(base, numberOne, numberTwo);
        System.out.println(result);
    }
    public static int anyBaseMultiplication(int base, int numberOne, int numberTwo){
        int result=0;
        int p=1;
        while(numberTwo>0){
            int digit=numberTwo%10;
            int res=getProductBySingleDigit(base,numberOne,digit);
            result=addTwoNumbers(base,result,res*p);
            p*=10;
            numberTwo/=10;
        }
        return result;
    }
    public static int getProductBySingleDigit(int base, int numberOne, int digit){
        int result=0;
        int carry=0;
        int p=1;
        while(numberOne > 0 || carry > 0){
            int digitOne = numberOne % 10;
            int d  = digitOne*digit+carry;
            carry = d/base;
            d = d%base;
            result += d*p;
            p*=10;
            numberOne/=10;
        }
        return result;
    }

    public static int addTwoNumbers(int b, int numberOne, int numberTwo){
        int result=0;
        int carry=0;
        int p=1;
        while(numberOne>0 || numberTwo>0 ||carry>0){
            int d1=numberOne%10;
            int d2=numberTwo%10;
            int d=d1+d2+carry;
            carry=d/b;
            d=d%b;
            result+=d*p;
            p=p*10;
            numberOne/=10;
            numberTwo/=10;
        }
        return result;
    }
}
