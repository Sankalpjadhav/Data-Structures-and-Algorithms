package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
1. You are given a list of lists, where each list is sorted.
2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.
Space complextiy = O(k)
Time complexity = nlogk
where k is the number of lists and n is number of elements across all lists.
Sample Input
4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39
Sample Output
1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57
 */
public class MergeKSortedLists {

    static class Pair implements Comparable<Pair>{
        int listIndex;
        int dataIndex;
        int value;

        Pair(int listIndex, int dataIndex, int value){
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }

    static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> mergedLists = new ArrayList<Integer>();
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<lists.size();i++){
            Pair pair = new Pair(i,0,lists.get(i).get(0));
            priorityQueue.add(pair);
        }

        while(priorityQueue.size()>0){
            Pair priorityPair = priorityQueue.remove();
            mergedLists.add(priorityPair.value);
            priorityPair.dataIndex++;

            if(priorityPair.dataIndex < lists.get(priorityPair.listIndex).size()){
                priorityPair.value = lists.get(priorityPair.listIndex).get(priorityPair.dataIndex);
                priorityQueue.add(priorityPair);
            }
        }
        return mergedLists;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList <ArrayList< Integer >> lists = new ArrayList < > ();
        for (int i = 0; i < k; i++) {
            ArrayList < Integer > list = new ArrayList < > ();

            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }

            lists.add(list);
        }

        ArrayList < Integer > mergedList = mergeKSortedLists(lists);
        for (int val: mergedList) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
