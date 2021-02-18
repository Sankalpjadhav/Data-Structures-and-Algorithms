package com.dsaprograms.bitmanipulation;
import java.util.Scanner;
/*
1. You are given an array of numbers.
2. All numbers occur thrice in the array except one.
3. You have to find the element that occurs once.
Sample Input
n=10
51
57
51
57
63
38
57
63
63
51
Sample Output
38
 */
public class OneUniqueRestThrice {
    public static void findUniqueElement(int [] array){
        int threeN = Integer.MAX_VALUE; // 111111
        int threeNPlus1 = 0; // 000000
        int threeNPlus2 = 0; // 000000

        for(int i=0;i<array.length;i++){
            int commonWithThreeN = array[i] & threeN;
            int commonWithThreeNPlus1 = array[i] & threeNPlus1;
            int commonWithThreeNPlus2 = array[i] & threeNPlus2;

            threeN = threeN & (~commonWithThreeN);
            threeNPlus1 = threeNPlus1 | commonWithThreeN;

            threeNPlus1 = threeNPlus1 & (~commonWithThreeNPlus1);
            threeNPlus2 = threeNPlus2 | commonWithThreeNPlus1;

            threeNPlus2 = threeNPlus2 & (~commonWithThreeNPlus2);
            threeN = threeN | commonWithThreeNPlus2;
        }
        System.out.println(threeNPlus1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        findUniqueElement(array);
    }
}
