package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.Scanner;
/*
1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.
3
[111, 12, 21, 3]
 */
public class GetStairPaths {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> result = getStairPaths(n);
        System.out.println(result);
    }

    public static ArrayList<String> getStairPaths(int n){
        if(n==0){
            ArrayList<String> base = new ArrayList<String>();
            base.add(""); // Dont move is one path.
            return base;
        }
        else if(n<0){
            ArrayList<String> base2 = new ArrayList<String>();
            return base2; // No going back.
        }
        ArrayList<String> path1 = getStairPaths(n-1);
        ArrayList<String> path2 = getStairPaths(n-2);
        ArrayList<String> path3 = getStairPaths(n-3);
        ArrayList<String> result = new ArrayList<String>();
        // Just append one to path 1.
        for(String str: path1){
            result.add("1"+str);
        }
        // Just append two to path 2.
        for(String str: path2){
            result.add("2"+str);
        }
        // Just append three to path 3.
        for(String str: path3){
            result.add("3"+str);
        }
        return result;
    }
}
