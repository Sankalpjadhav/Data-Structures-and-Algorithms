package com.dsaprograms.practice;

public class FindMaxAndMinInArray {
    public static void main(String[] args) {
        int [] arr = {4,78,0,1,90,12,6};
        Pair result = getMinMax(arr);
        System.out.println(result.max);
        System.out.println(result.min);
    }
    public static Pair getMinMax(int [] arr){
     Pair result=new Pair();
     if(arr[0]>arr[1]){
         result.max=arr[0];
         result.min=arr[1];
     }
     else{
         result.min=arr[0];
         result.max=arr[1];
     }
     for(int i=2;i<arr.length;i++){
         if(arr[i]> result.max){
             result.max=arr[i];
         }
         else if(arr[i]<result.min){
             result.min=arr[i];
         }
     }
     return result;
    }
}

class Pair{
    int max;
    int min;
}
