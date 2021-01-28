package com.dsaprograms.graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
/*
1. You are given a graph.
2. You are required to find and print if the graph is cyclic.
true if the graph is cyclic, false otherwise
Sample Input
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10
Sample Output
false
 */
public class IsGraphCyclic {
    static class Edges {
        int vertex;
        int neighbour;
        int weight;
        Edges(int vertex, int neighbour, int weight){
            this.vertex = vertex;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    static class Pair{
        int vertex;
        String pathSoFar;
        Pair(int vertex, String pathSoFar){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }
    }

    static boolean isCyclic(ArrayList<Edges>[] graph, int source, boolean [] visited){
        //Same concept as that of BreadthFirstTraversal.java program
        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        queue.add(new Pair(source,source+""));
        while(queue.size()>0){
            Pair removedPair = queue.removeFirst();
            if(visited[removedPair.vertex]==true){
                return true; // There is a cycle -> This vertex is visited before.
            }
            visited[removedPair.vertex]=true;
            for(Edges edge: graph[removedPair.vertex]){
                if(visited[edge.neighbour]==false){
                    queue.add(new Pair(edge.neighbour, removedPair.pathSoFar+edge.neighbour));
                }
            }

        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(in.readLine());
        ArrayList<Edges>[] graph = new ArrayList[vertices];
        for(int i=0;i<vertices;i++){
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(in.readLine());
        for(int edge=0;edge<edges;edge++){
            String read = in.readLine();
            int vertex1 = Integer.parseInt(read.split(" ")[0]);
            int vertex2 = Integer.parseInt(read.split(" ")[1]);
            int weight = Integer.parseInt(read.split(" ")[2]);
            graph[vertex1].add(new Edges(vertex1, vertex2, weight));
            graph[vertex2].add(new Edges(vertex2, vertex1, weight));
        }
        boolean [] visited = new boolean[vertices];
        for(int vertex=0;vertex<vertices;vertex++){ // We will traverse through each vertex because if the input graph is not connected then it will cause a problem(It will not traverse through entire graph).
            if(visited[vertex]==false) {
                boolean isGraphCyclic = isCyclic(graph, vertex, visited);
                if (isGraphCyclic) { // If there is one cycle then we will print true and return.
                    System.out.println("The given graph has cycle.");
                    return;
                }
            }
        }
        System.out.println("The given graph has no cycles.");
    }
}
