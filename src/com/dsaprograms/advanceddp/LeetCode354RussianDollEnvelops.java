package com.dsaprograms.advanceddp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
LeetCode: 354 Russian Doll Envelopes.
You have a number of envelopes with widths and heights given as a pair of integers (w, h).
One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
What is the maximum number of envelopes can you Russian doll? (put one inside other)
Note:
Rotation is not allowed.
Example:
Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class LeetCode354RussianDollEnvelops {
    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null
                || envelopes.length    == 0
                || envelopes[0]        == null
                || envelopes[0].length == 0){
            return envelopes.length;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int [] envelope1, int [] envelope2){
                return Integer.compare(envelope1[0],envelope2[0]);// Compare based on width
            }
        });
        // Apply LIS(Longest increasing subsequence) to height
        int [] dp = new int[envelopes.length];
        int maximumEnvelopes=0;
        for(int i=0;i<envelopes.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(envelopes[j][1]<envelopes[i][1] && envelopes[j][0]<envelopes[i][0]){
                    // Width is also checked because we have sorted based on width but what if width is also same. So strictly checking.
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i]>maximumEnvelopes){
                maximumEnvelopes = dp[i];
            }
        }
        return maximumEnvelopes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfEnvelopes = sc.nextInt();
        int [][] envelopes = new int[numberOfEnvelopes][2];
        for(int i=0;i<numberOfEnvelopes;i++){
            for(int j=0;j<envelopes[i].length;j++){
                envelopes[i][j] = sc.nextInt();
            }
        }
        System.out.println("Maximum number of envelopes that can be russian doll: "+maxEnvelopes(envelopes));
    }
}
