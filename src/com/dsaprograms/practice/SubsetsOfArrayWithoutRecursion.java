package com.dsaprograms.practice;
import java.util.Scanner;
public class SubsetsOfArrayWithoutRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        int limit = (int) Math.pow(2,n);
        for(int i=0;i<limit;i++){
            int temp = i;
            String result="";
            for(int j= arr.length-1;j>=0;j--){
                int remainder = temp % 2;
                temp = temp / 2;
                if(remainder ==0){
                    result  = "-\t"+result;
                }
                else{// when 1
                    result  = arr[j]+"\t"+result;
                }
            }
            System.out.println(result);
        }
    }
}
/*
Result:
Input: [10,20,30]
-	-	-
-	-	30
-	20	-
-	20	30
10	-	-
10	-	30
10	20	-
10	20	30
*/