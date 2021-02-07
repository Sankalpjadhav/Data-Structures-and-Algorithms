package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.Scanner;
/*
1. You are given two integers n and k, where n represents number of elements and k represents
     number of subsets.
2. You have to partition n elements in k subsets and print all such configurations.
Constraints
1 <= n <= 10
1 <= k <= 10
Sample Input
3
2
Sample Output
[1, 2] [3]
[1, 3] [2]
[1] [2, 3]
 */
public class PartitionInKSubsets {

    public static void partitionIntoKSubsets(int number, int numbers, int k, int numberOfSets, ArrayList<ArrayList<Integer>> subsets){
        if(number>numbers){
            if(numberOfSets==k){
                for(ArrayList<Integer> set: subsets){
                    System.out.print(set+" ");
                }
                System.out.println();
            }
            return;
        }

        for(int i=0;i<subsets.size();i++){
            if(subsets.get(i).size()>0){ // Existing set
                subsets.get(i).add(number);
                partitionIntoKSubsets(number+1, numbers, k, numberOfSets, subsets);// numberOfSets does not increase since we are adding in existing set.
                subsets.get(i).remove(subsets.get(i).size()-1); // for backtracking
            }else{// empty set
                subsets.get(i).add(number);
                partitionIntoKSubsets(number+1, numbers, k, numberOfSets+1, subsets);// numberOfSets does not increase since we are adding in existing set.
                subsets.get(i).remove(subsets.get(i).size()-1); // for backtracking
                break;
                /*
                break because: Eg: 12|_|_
                we will be adding in empty set. Break ensures that we will not be able to add in third empty set.(12|_|3)
                It will add only in first existing empty set.(12|3|_)
                 */
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for(int i=0;i<k;i++){
            subsets.add(new ArrayList<>());
        }
        partitionIntoKSubsets(1, numbers, k, 0, subsets);
    }
}
