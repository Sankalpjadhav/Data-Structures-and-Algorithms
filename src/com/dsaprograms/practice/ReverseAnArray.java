package com.dsaprograms.practice;

public class ReverseAnArray {

    public static void main(String[] args) {
	// write your code here
        int [] array={2,5,3,1,7,9};
        reverseAnArray(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void reverseAnArray(int [] array){
        int left=0;
        int right=array.length-1;
        while(left<right){
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
    }
}
