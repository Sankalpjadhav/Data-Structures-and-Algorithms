package com.dsaprograms.basedonsorting;
import java.util.Scanner;
public class BubbleSort {
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int [] array = {4,2,6,7,3,9};
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j+1]<array[j]){
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
