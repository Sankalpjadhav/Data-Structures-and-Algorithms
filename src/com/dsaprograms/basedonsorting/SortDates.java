package com.dsaprograms.basedonsorting;
import java.util.Scanner;
/*
Input:
5
02071991
01061991
24121960
12011998
20121960

Output:
20121960
24121960
01061991
02071991
12011998
 */
public class SortDates {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
    }
    public static void sortDates(String [] arr){
        countSort(arr,1000000,100,32);// day-> days 1000000 because 05191997 divide by 1000000  result will be only 05.
        countSort(arr,10000,100,13);// month-> months 100 because 05191997 mod of 100 result will be 19.
        countSort(arr,1,10000,2501);// year-> years 2501 range because range of maximum can be 2500(given in question).
    }
    public static void countSort(String [] arr,int exp, int mod, int range){
        String [] ans = new String[arr.length];
        int [] frequencyCount = new int[range];
        for(int i=0;i<arr.length;i++){
            int value = Integer.parseInt(arr[i],10) /exp % mod; // Integer.parseInt(arr[i],10)
            frequencyCount[value]++;
        }
        for(int j=1;j<frequencyCount.length;j++){
            frequencyCount[j] = frequencyCount[j] + frequencyCount[j-1];
        }

        for(int i=arr.length-1;i>=0;i--){
            int value = frequencyCount[Integer.parseInt(arr[i],10) /exp % mod];
            int index = value -1;
            ans[index] = arr[i];
            frequencyCount[Integer.parseInt(arr[i],10) /exp % mod]--;
        }
        // Copy back to original array.
        for(int i=0;i<arr.length;i++){
            arr[i]=ans[i];
        }
    }
    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
