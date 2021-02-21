package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
1. You are given an integer N.
2. You have to find the N-th number whose binary representation is a palindrome.
Note -> First binary number whose representation is a palindrome is 1.
Sample Input
17
Sample Output
85
number:Length: Palindromic Binary  : Number of elements in each length
1         1  :  1                  :   1
2         2  :  11                 :   1
3         3  :  101                :   2
4               111
5         4  :  1001               :   2
6               1111
7         5  :  10001              :   4
8               10101
9               11011
10              11111
11        6  :  100001             :   4
12              101101
13              110011
14              111111
15        7  :  1000001            :   8
16              1001001
17              1010101
18              1011101
19              1100011
20              1101011
21              1110111
22              1111111
23        8  :  10000001           :   8
24              10011001
25              10100101
26              10111101
27              11000011
28              11011011
29              11100111
30              11111111

Let us say we want to find 29th binary palindromic representation (11100111)
We can see a pattern
1,2 (length)- 1 binary palindromic representation.
3,4 (length)- 2 binary palindromic representation.
5,6 (length)- 4 binary palindromic representation.
7,8 (length)- 8 binary palindromic representation.
Therefore (2^((length-1)/2)) binary palindromic representations possible
Main step is to find length and offset (For N=29 length is 8 and offset is 6 - 1[110]0111 )
 */
public class NthPalindromicBinary {
    public static int getReverse(int valueForReverse){
        int reverse = 0;
        while(valueForReverse!=0){
            int bit = (valueForReverse & 1);
            reverse |= bit;
            valueForReverse>>=1; // Or valueForReverse = (valueForReverse >> 1)
            reverse<<=1;
        }
        reverse>>=1; // One extra bit is added at the end
        return reverse;
    }
    public static void nthPaindromicRepresentation(int n){
        int count = 1;
        int length = 1;
        // To calculate length
        while(count < n){
            length++;
            int elementsCanBeFormed = (1<<((length - 1)/2));
            count += elementsCanBeFormed;
        }
        // This will give us correct length i.e 8 in case of n=29
        // We will move to 1 less length so that after adding offset we will get n=29
        count -= (1<<((length - 1)/2)); // Now count = 22
        int offset = n - count -1; //(29-22-1 =6) and offset is 6 (110)
        /*
        Now we have length = 8
        offset = 6
        10000000
             110
       ------------
       ->[1110]0000
       -> 0000[0111] - Reverse
       --------------
         [1110][0111] -> 11100111 Answer
         */
        int answer = (1<<(length - 1));
        answer |= (offset<<(length/2)); // [1110]0000
        int valueForReverse = (answer >> (length/2));
        int reverse = getReverse(valueForReverse);
        answer |= reverse;
        System.out.println("Nth Palindromic representation: "+answer);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nthPaindromicRepresentation(n);
    }
}
