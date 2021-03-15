package com.dsaprograms.hashmapandheap;
import java.util.HashMap;
import java.util.Scanner;
/*
LeetCode: 781. Rabbits in Forest
In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.
Return the minimum number of rabbits that could be in the forest.
Examples:
Input: answers = [1, 1, 2]
Output: 5
Explanation:
The two rabbits that answered "1" could both be the same color, say red.
The rabbit than answered "2" can't be red or the answers would be inconsistent.
Say the rabbit that answered "2" was blue.
Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
Input: answers = [10, 10, 10]
Output: 11
Input: answers = []
Output: 0
 */
public class LeetCode781RabbitsInForest {
    public static int numRabbits(int[] answers) {
        if(answers.length==0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val:answers){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int minRabbits = 0;
        for(int val:map.keySet()){
            int groupSize = val+1;
            int reportees = map.get(val);
            int numberOfGroups = (int) Math.ceil((reportees*1.0 / groupSize*1.0));
            minRabbits += groupSize * numberOfGroups;
        }

        return minRabbits;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] answers = new int[n];
        for(int i=0;i<n;i++){
            answers[i] = sc.nextInt();
        }
        System.out.println("Minimum number of rabbits that could be in the forest: "+numRabbits(answers));
    }
}
