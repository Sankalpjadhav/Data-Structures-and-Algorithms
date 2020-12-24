package com.dsaprograms.basedonsorting;
import java.util.Scanner;
public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int [] arr = {4,2,6,7,3,9};
        int min=0;
        for(int i=0;i<arr.length-1;i++){
            min =i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            swap(arr,i,min);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void swap(int [] array, int i,int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
