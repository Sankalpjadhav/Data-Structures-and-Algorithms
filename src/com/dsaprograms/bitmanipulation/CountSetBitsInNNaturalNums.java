package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
    Count Set Bits in First N natural numbers | Total Set Bits from 1 to N
    1. You are given a number n.
    2. You have to print the count of set bits of first n natural numbers.
    Sample Input
    17
    Sample Output
    35
    Sample Input
    20
    Sample Output
    42

    Approach 1:
    We could have solved this problem by traversing from 0 to N and for each number we apply Kernighan's algorithm to count number of set bits and then take sum of
    all the counts of each number.
    Approach 2:
    Eg: N = 11
    0  -    0000
    1  -    0001
    2  -    0010
    3  -    0011
    4  -    0100
    5  -    0101
    6  -    0110
    7  -    0111
    8  -    1000
    9  -    1001
    10 -    1010
    11 -    1011
    1. First find the maximum 2^x value such that 2^x<=N. In this case it is 8 i.e 2^3
       If we have a closer look from 0 till 8 (0000 to 0111)
       1. 0th bit - 01010101 (4 set bits)
       2. 1st bit - 00110011 (4 set bits)
       3. 2nd bit - 00001111 (4 set bits)
       4. 3rd bit - 00000000 (0 set bits)
       So consider only 1.,2.,3. - (2^(3-1)*3) -> Can be represented as (2^(x-1))*x -> These number of set bits.
    2. Now we have counted number of set bits from 0 to 7(0 till 8)
    3. Now we have counted number of set bits from 8 to 11 (2^x to N in general)
    4. We can see 3rd bit - 1111 (4 set bits)
       11 - 8 + 1 (N - 2^x + 1) set bits
    5. After counting these bits we are left with
       8  -    1000  changed to 000
       9  -    1001  changed to 001
       10 -    1010  changed to 010
       11 -    1011  changed to 011
    6. We have to follow same steps for N = 3 (N - 2^x) -> (Recursion)
*/
public class CountSetBitsInNNaturalNums {
    public static int countSetBits(int N){
        // 2nd step
        if(N==0){
            return 0;
        }

        // 1st step
        int x = get2PowerXValue(N);
        int setBitsTill2PowerX = x * (1 << (x-1)); // Refer step 1
        int setBitAtMSB = N - (1 << x) + 1; // Refer step 2,3,4
        int remaining = N - (1<<x); // Refer step 5,6
        int result = setBitsTill2PowerX + setBitAtMSB + countSetBits(remaining);
        return result;
    }

    public static int get2PowerXValue(int N){
        int x = 0;
        while((1<<x)<=N){
            x++;
        }
        return x-1; // x-1 because if N=11 then x=3 is the valid answer but in while loop it will increment 1 more to get the condition false.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = countSetBits(N);
        System.out.println("Number of set bits in N natural numbers: "+count);
    }
}
