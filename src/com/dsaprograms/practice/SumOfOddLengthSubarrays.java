package com.dsaprograms.practice;
import java.util.Scanner;
/*
Process:
Input array = [1,4,2,5,3]
* Subarrays and Subsequence are two different things. Eg- [1,4,2],[4,2,5] but not [1,4,5].
* Subarrays contains continuous array elements, whereas Subsequence contains 2^N elements(They can skip inbetween elements to form an array). Eg-[1,4,5]
Let us define all the subarrays:
length 1  length 2   length 3    length 4    length 5
  1         1,4        1,4,2     1,4,2,5    1,4,2,5,3
  4         4,2        4,2,5     4,2,5,3
  2         2,5        2,5,3
  5         5,3
  3
Here we need to only consider odd lengths - (length 1, length 3, length 5)
We can see a pattern:
0 1 2 3 4 (index)
1 4 2 5 3 (array elements)
3 4 5 4 3 (number of times array elements occurs in length 1, length 3, length 5). Eg- 4 occurs one time in length 1 + two times in length 3 + one time length 5.
3 16 10 20 9 (Total= array elements * num of times it occurs) = 3+16+10+20+9 = 58.

Challenge is to calculate number of times an array element occurs:
Let us consider array element 1:
Consider index 0
Find how many subarrays start with that index = 1([1])+1([1,4])+1([1,4,2])+1([1,4,2,5])+1([1,4,2,5,3]) = 5.
Find how many subarrays end with that index = 1[1] = 1.

Consider index 1
Find how many subarrays start with that index = 1([1,4])+1([1,4,2])+1([1,4,2,5])+1([1,4,2,5,3]) = 4.
Find how many subarrays end with that index = 1[1] = 1.

Pattern: start = n-i
         End = i+1
Total number of times : start * end (Remember this is for both odd and even)
Odd = Total / 2 (Consider adding extra one to the odd) (3 4 5 4 3)
Result = array element * odd
Do it for all the array elements and corresponding odd numbers and add it to result. (3+16+10+20+9=58)
 */
public class SumOfOddLengthSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int sum = sumOfOddLengthSubarrays(arr,n);
        System.out.println(sum);
    }

    public static int sumOfOddLengthSubarrays(int [] arr, int n){
        int result=0;
        for(int  i=0;i<n;i++){
            int start = n-i;
            int end = i+1;
            int total = start * end; // Both even and odd;
            int odd = total/2;
            if(total%2==1){ // If total is odd add extra 1 to it to calculate odd
                odd=odd+1;
            }
            result +=  odd * arr[i];
        }
        return result;
    }
}
