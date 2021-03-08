package com.dsaprograms.hashmapandheap;
import java.util.*;

/*
LeetCode: 332. Reconstruct Itinerary
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
 */
public class LeetCode332ReconstructItinerary {
    public static List<String> reverse(List<String> answer){
        int left = 0;
        int right = answer.size()-1;
        while(left<right){
            String temp = answer.get(left);
            answer.set(left,answer.get(right));
            answer.set(right,temp);
            left++;
            right--;
        }
        return answer;
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String , PriorityQueue<String>> map = new HashMap<>();
        for(List<String> routes: tickets){
            String from = routes.get(0);
            String to = routes.get(1);
            if(!map.containsKey(from)){
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(to);
                map.put(from,pq);
            }
            else{
                PriorityQueue<String> pq = map.get(from);
                pq.add(to);
            }
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        List<String> answer = new ArrayList<>();
        while(stack.size()!=0){
            String from = stack.peek();
            PriorityQueue<String> pq = map.get(from);
            if(pq!=null && pq.size()!=0){
                stack.push(map.get(from).poll());
            }
            else{
                answer.add(stack.pop());
            }
        }
        reverse(answer);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPairs = sc.nextInt();
        List<List<String>> tickets = new ArrayList<>();
        for(int i=0;i<numberOfPairs;i++){
            List<String> ticket = new ArrayList<>();
            ticket.add(sc.next());
            ticket.add(sc.next());
            tickets.add(ticket);
        }
        List<String> result = findItinerary(tickets);
        System.out.println(result);
    }
}
