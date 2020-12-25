package com.dsaprograms.basedonsorting;
import java.util.Scanner;
public class CountSort {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int result [] = countSort(arr);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    static int[] countSort(int [] arr){
        // First find maximum and minimum element to find out the range of countFrequency array.
        Pair result = findMaxMinElement(arr);
        int frequencyRange = result.max - result.min +1;
        int [] countFrequency = new int[frequencyRange];
        for(int i=0;i<arr.length;i++){
            int value = arr[i];
            int index = value - result.min;
            countFrequency[index]++;
        }
        //Prefix Sum
        for(int i=1;i< countFrequency.length;i++){
            countFrequency[i]+=countFrequency[i-1];
        }
        int [] answer =new int[arr.length];
        //Traverse through the input array from end to maintain the concept of stable sort algo.
        for(int i=arr.length-1;i>=0;i--){
            int value = arr[i];
            int pos = countFrequency[value - result.min];
            int index = pos-1;
            answer[index] = value;
            countFrequency[value- result.min]--;
        }
        return answer;
    }

    public static Pair findMaxMinElement(int [] arr){
        Pair result = new Pair();
        if(arr.length==1){
            result.min=arr[0];
            result.max=arr[0];
        }
        else{
            if(arr[0]>arr[1]){
                result.max =arr[0];
                result.min=arr[1];
            }
            else{
                result.min =arr[0];
                result.max=arr[1];
            }
            for(int i=2;i<arr.length;i++){
                if(arr[i]<result.min){
                    result.min=arr[i];
                }
                else if(arr[i]> result.max){
                    result.max=arr[i];
                }
            }

        }
        return result;
    }
}

class Pair{
    int min;
    int max;
}
