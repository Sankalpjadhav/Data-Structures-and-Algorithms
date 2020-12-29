package com.dsaprograms.dynamicprogramming;

import java.util.Scanner;
/*
1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
 */
public class ArrangeBuildings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] buildingCount = new int[n+1];
        int [] spaceCount = new int[n+1];
        // buildingCount[0] = 0, spaceCount[0] = 0
        buildingCount[1] = 1; // building
        spaceCount[1] = 1; // space
        for(int i=2;i<=n;i++){
            buildingCount[i] = spaceCount[i-1];
            spaceCount[i] = buildingCount[i-1] + spaceCount[i-1];
        }
        int total = buildingCount[n]+spaceCount[n];
        System.out.println(total * total); // both sides of the road so square of the total.
    }
}
