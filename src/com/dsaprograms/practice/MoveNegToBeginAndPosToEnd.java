package com.dsaprograms.practice;
import java.util.Scanner;

public class MoveNegToBeginAndPosToEnd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        moveTheElements(arr);
        for(int element:arr){
            System.out.print(element+" ");
        }
    }

    public static void moveTheElements(int [] arr){
        int i=0;
        int j=0;
        while(j<arr.length){
            if(arr[j]<0){
                swap(arr,i,j);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
    }
    static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
