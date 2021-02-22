package com.dsaprograms.advanceddp;
import java.util.Arrays;
import java.util.Scanner;
/*
Maximum Non-overlapping Bridges.
1. You are given a number n, representing the number of bridges on a river.
2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
3. You are required to print the count of maximum number of non-overlapping bridges.
Sample Input
10
10 20
2 7
8 15
17 3
21 40
50 4
41 57
60 80
80 90
1 30
Sample Output
7
 */
public class MaximumNonOverlappingBridges {
    public static class Bridge implements Comparable<Bridge>{
        int north;
        int south;
        Bridge(int north, int south){
            this.north = north;
            this.south = south;
        }

        public int compareTo(Bridge other){
            if(this.north != other.north){
                return this.north - other.north;
            }
            else{ // If north value is same then sort based on south value.
                return this.south - other.south;
            }
        }
    }

    public static int getMaximumLength(Bridge [] bridges){
        Arrays.sort(bridges); // This will sort based on north values(If north values are same then it will sort based on south values.)
        /*
            1. Sort based on north values.
            2. Use longest increasing subsequence on south values.
        */
        int maximumLength = 0;
        int [] dp = new int[bridges.length];
        for(int i=0;i<bridges.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(bridges[j].south<bridges[i].south){
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i]>maximumLength){
                maximumLength = dp[i];
            }
        }
        return maximumLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfBridges = Integer.parseInt(sc.nextLine());
        Bridge [] bridges = new Bridge[numberOfBridges];
        for(int i=0;i<numberOfBridges;i++){
            String value = sc.nextLine();
            String [] northsouth = value.split(" ");
            int north = Integer.parseInt(northsouth[0]);
            int south = Integer.parseInt(northsouth[1]);
            bridges[i] = new Bridge(north, south);
        }
        System.out.println("Length of maximum non overlapping bridges: "+getMaximumLength(bridges));
    }
}
