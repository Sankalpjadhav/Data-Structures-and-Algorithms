package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
1. You are given a number n.
2. You have to swap all odd position bits with even position bits.
3. Every odd position bit is swapped with adjacent bit on left side.
4. Every even position bit is swapped with adjacent bit on right side.
5. Print the number formed after swapping.
Sample Input
10
Sample Output
5
 */
public class SwapAllOddsAndEvenBits {
    public static void inBinary(int num){
        int result=0;
        int i=1;
        while(num>0){
            int rem=num%2;
            result=result + rem * i;
            i=i*10;
            num/=2;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("Before swapping: "+number);
        inBinary(number);
        /*
        Approach: 0 1 2 3 4 5 6 7 8 9 10 11
                  1 0 0 1 1 1 0 1 0 1  1  0
                  -----------------------
          Result: 0 1 1 0 1 1 1 0 1 0  0  1 (Swapping odd and even bits)
         1.
             1 0 0 1 1 1 0 1 0 1 1 0
             1 0 1 0 1 0 1 0 1 0 1 0 (Mask 1)
           & --------------------------
             1 0 0 0 1 0 0 0 0 0 1 0 (It will preserve all even bits)

         2.
             1 0 0 1 1 1 0 1 0 1 1 0
             0 1 0 1 0 1 0 1 0 1 0 1 (Mask 2)
           & --------------------------
             0 0 0 1 0 1 0 1 0 1 0 0 (It will preserve all odd bits)

         3. Left shift all odd bits by 1 which are preserved.  (0 0 1 0 1 0 1 0 1 0 0 0)
         4. Right shift all even bits by 1 which are preserved.(0 1 0 0 0 1 0 0 0 0 0 1)
         5. Take | between them.                               (0 1 1 0 1 1 1 0 1 0 0 1)

         Here the point is to find the mask1 and mask2
         1010 - A(number 10). So we can write 0xAAAAAAAA (which represents 32 bits-> 4(1010 bits)*8(A's)=32 bits)
         0101 - 5(number 5). So we can write 0x55555555 (which represents 32 bits-> 4(0101 bits)*8(5's)=32 bits)
        */
        int mask1 = 0xAAAAAAAA;
        int mask2 = 0x55555555;
        int answer = (((number & mask1)>>1) | ((number & mask2)<<1));
        System.out.println("After swapping even and odd bits: "+answer);
        inBinary(number);
    }
}
