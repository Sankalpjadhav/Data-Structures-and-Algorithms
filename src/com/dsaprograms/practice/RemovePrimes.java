package com.dsaprograms.practice;
import java.util.ArrayList;
import java.util.Scanner;
/*
1. You are given an ArrayList of positive integers.
2. You have to remove prime numbers from the given ArrayList and return the updated ArrayList.

Note -> The order of elements should remain same.
 */

public class RemovePrimes {
    public static void solution(ArrayList<Integer> al){
        // write your code here
        for(int i=0;i<al.size();i++){
            if(isPrime(al.get(i))){
                al.remove(i);
                i=i-1;   // because after removing element from the arraylist the next
                //elements index will become current index and if not written it will skip the new element(current index).
            }
        }

    }

    public static boolean isPrime(int a){
        for(int i=2;i<=a/2;i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }
}
