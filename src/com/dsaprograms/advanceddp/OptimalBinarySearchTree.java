package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Optimal Binary Search Tree
1. You are given two arrays -
   The first array(keys), which is sorted and has distinct integers, represents search keys.
   Second one(freq) represents frequency counts, where freq[i] is the number of searches to keys[i].
2. A binary search tree is constructed containing all keys and the total cost of searches is minimum.
3. The cost of a BST node is the level of that node multiplied by its frequency.
4. You have to find the minimum cost of all searches.
Sample Input
9
1
3
4
5
6
7
8
9
11
3
6
4
8
7
3
7
4
7
Sample Output
125
 */
public class OptimalBinarySearchTree {
    public static void minimumCostOfAllSearches(int [] keys, int [] frequency){
        int [] prefixSum = new int[frequency.length];
        prefixSum[0] = frequency[0];
        for(int i=1;i<prefixSum.length;i++){
            prefixSum[i] = prefixSum[i-1] + frequency[i];
        }

        int [][] dp = new int[keys.length][keys.length];
        for(int gap=0;gap<dp.length;gap++){
            for(int i=0,j=gap;j<dp.length;j++,i++){
                if(gap==0){
                    dp[i][j] = frequency[i];
                }
                else if(gap==1){
                    int frequency1 = frequency[i];
                    int frequency2 = frequency[j];
                    dp[i][j] = Math.min(frequency1 + 2*frequency2, frequency2 + 2*frequency1);
                }
                else{
                    int minimum = Integer.MAX_VALUE;
                    int frequencySum = prefixSum[j] - (i>0?prefixSum[i-1]:0);
                    for(int k=i;k<=j;k++){
                        int left = k==i?0:dp[i][k-1];
                        int right = k==j?0:dp[k+1][j];

                        if(left+right+frequencySum < minimum){
                            minimum = left+right+frequencySum;
                        }
                    }
                    dp[i][j] = minimum;
                }
            }
        }
        System.out.println("Minimum cost of all searches: "+dp[0][keys.length-1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] keys = new int[n];
        int [] frequency = new int[n];
        for(int i=0;i<keys.length;i++){
            keys[i] = sc.nextInt();
        }
        for(int i=0;i<frequency.length;i++){
            frequency[i] = sc.nextInt();
        }
        minimumCostOfAllSearches(keys, frequency);
    }
}
