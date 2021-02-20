package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
LeetCode: 1310. XOR Queries of a Subarray
Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri],
for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ).
Return an array containing the result for the given queries.
Example 1:
Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8]
Explanation:
The binary representation of the elements in the array are:
1 = 0001
3 = 0011
4 = 0100
8 = 1000
The XOR values for queries are:
[0,1] = 1 xor 3 = 2
[1,2] = 3 xor 4 = 7
[0,3] = 1 xor 3 xor 4 xor 8 = 14
[3,3] = 8
Example 2:
Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
Output: [8,0,4,4]
 */
public class LeetCode1310XORQueries {
    public static int [] xorQueriesOfASubarray(int [] array, int [][] queries){
        for(int i=1;i<array.length;i++){
            array[i] = array[i] ^ array[i-1];
        }
        int [] result = new int[queries.length];
        for(int j=0;j<queries.length;j++){
            int [] subArray = queries[j];
            result[j] = subArray[0] > 0 ? array[subArray[0]-1] ^ array[subArray[1]] : array[subArray[1]];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfElements = sc.nextInt();
        int [] array = new int[numberOfElements];
        int  numberOfQueries = sc.nextInt();
        int [][] queries = new int[numberOfQueries][2];
        for(int i=0;i<numberOfElements;i++){
            array[i] = sc.nextInt();
        }
        for(int i=0;i<numberOfQueries;i++){
            for(int j=0;j<queries[i].length;j++) {
                queries[i][j] = sc.nextInt();
            }
        }
        int [] result = xorQueriesOfASubarray(array, queries);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
