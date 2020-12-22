package com.dsaprograms.practice;
import java.util.Scanner;
public class SortAnArrayOfZeroesOnesTwos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        sortArrayZeroesOnesTwos(arr);
        for(int element:arr) {
            System.out.print(element+" ");
        }
    }

    public static void sortArrayZeroesOnesTwos(int [] arr){
        /*
        0 to i-1 -> 0's Area.
        i to j-1 -> 1's Area.
        k+1 to end -> 2's Area.
        */
        int i=0;
        int j=0;
        int k=arr.length-1;
        while(j<k){
            if(arr[j]==0){
                swap(arr,i,j);
                i++;
                j++;
            }
            else if(arr[j]==1){
                j++;
            }
            else{ // is arr[j]==k
                swap(arr,k,j);
                k--;
                j++;
            }
        }
    }

    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
