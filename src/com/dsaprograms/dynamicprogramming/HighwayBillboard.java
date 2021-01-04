package com.dsaprograms.dynamicprogramming;
import java.util.HashMap;
import java.util.Scanner;
/*
1. You are given a number M representing length of highway(range).
2. You are given a number N representing number of bill boards.
3. You are given N space separated numbers representing (P)position of bill-boards.
4. You are given N space separated numbers representing (R)revenue corresponding to each (P)position.
5. You are given a number T such that bill-boards can only be placed after specific distance(T).
6. Find the maximum revenue that can be generated.
Input Format
A number M(length of highway)
A number N(number of bill boards)
P1 ,P2 ,P3 ,P4 ,P5 .... Pn (placement of N bill-boards)
R1 ,R2 ,R3 ,R4 ,R5 .... Rn (revenue from each bill-board)
A number T (neccessary distance b/w two bill-board)
Output Format
Find the maximum revenue that can be generated.
Check the sample output and question video.
Constraints
1 <= M <= 100000
1 <= N <= 50000
1 <= Pi <= M
1 <= Ri <= 100
1 <= T
Sample Input
20
5
6 7 12 14 15
5 8 5 3 1
5
Sample Output
11
 */
public class HighwayBillboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  M = sc.nextInt(); // Represents length of the highway.
        int N = sc.nextInt(); //  Represents number of billboards.
        int [] positionOfBillboards = new int [N];
        for(int i=0;i<N;i++){
            positionOfBillboards[i] = sc.nextInt();
        }
        int [] revenueAtEachPosition = new int[N];
        for(int i=0;i<N;i++){
            revenueAtEachPosition[i] = sc.nextInt();
        }
        int T = sc.nextInt(); // bill-boards can only be placed after distance(T).

        // Approach 1: O(N^2)time and O(N) space. Based on number of billboards.
        int [] maxRevenue = new int [N];
        maxRevenue[0] = revenueAtEachPosition[0];
        int answer = revenueAtEachPosition[0];
        for(int i=1;i<N;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                int distance = positionOfBillboards[i] - positionOfBillboards[j];
                if(distance > T){
                    max = Math.max(max,maxRevenue[j]);
                }
            }
            maxRevenue[i] = max + revenueAtEachPosition[i];
            answer = Math.max(answer, maxRevenue[i]);
        }
        System.out.println(answer);

        // Approach 2: O(m) time and space. Based on length of highway.
        int [] maxRevenue2 = new int[M+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            map.put(positionOfBillboards[i],revenueAtEachPosition[i]);
        }
        for(int i=0;i<=M;i++){
            if(map.containsKey(i)==false){
                if(i == 0){
                    maxRevenue2[i] = 0;
                }
                else{
                    maxRevenue2[i] = maxRevenue2[i-1];
                }
            }
            else{
                int ifBillboardNotInstalled = maxRevenue2[i-1];
                int ifInstalled = maxRevenue2[i-T-1] + map.get(i);
                maxRevenue2[i] = Math.max(ifBillboardNotInstalled,ifInstalled);
            }
        }
        System.out.println(maxRevenue2[M]);
    }
}
