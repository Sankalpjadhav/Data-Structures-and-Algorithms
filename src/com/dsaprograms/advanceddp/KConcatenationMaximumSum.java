package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 1191. K-Concatenation Maximum Sum
Given an integer array arr and an integer k, modify the array by repeating it k times.
For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
Sample Input
3
1
2
3
3
Sample Output
18
 */
public class KConcatenationMaximumSum {
    public static int kadanesAlgo(int [] array){
        int currentSum = array[0];
        int overallSum = array[0];

        for(int i=1;i<array.length;i++){
            if(currentSum >= 0){
                currentSum += array[i];
            }
            else{
                currentSum = array[i];
            }
            if(currentSum > overallSum){
                overallSum = currentSum;
            }
        }
        return overallSum;
    }

    public static int kadanesAlgoFor2Arrays(int [] array){
        int [] newArray = new int[array.length*2];
        for(int i=0;i<array.length;i++){
            newArray[i] = array[i];
        }
        for(int i=0;i<array.length;i++){
            newArray[i+array.length] = array[i];
        }
        return kadanesAlgo(newArray);
    }

    public static int maxSubArraySum(int [] array, int k){
        if(array.length==0){
            return 0;
        }
        if(k == 1){
            return kadanesAlgo(array);
        }
        int sum = 0;
        for(int i=0;i<array.length;i++){
            sum += array[i];
        }
        if(sum<0){
            return kadanesAlgoFor2Arrays(array);
        }
        else{
            return (kadanesAlgoFor2Arrays(array) + (k-2) * sum);
        }

    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<array.length;i++){
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int sum = maxSubArraySum(array, k);
        System.out.println("Maximum sub-array sum: "+sum);
    }
}
