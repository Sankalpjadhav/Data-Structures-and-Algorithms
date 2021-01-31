package com.dsaprograms.graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
/*
 Single Source Shortest Path in Weights
 1. You are given a graph and a source vertex. The vertices represent cities and the edges represent
    distance in kms.
2. You are required to find the shortest path to each city (in terms of kms) from the source city along
    with the total distance on path from source to destinations.
Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
Sample Output
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
5 via 0125 @ 25
4 via 01254 @ 28
6 via 01256 @ 28
3 via 012543 @ 30

 */
public class DijkstrasAlgorithm {
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

    static class Pair implements Comparable<Pair>{
        int vertex;
        String pathSoFar;
        int weight;
        Pair(int vertex, String pathSoFar, int weight){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
            this.weight = weight;
        }

        public int compareTo(Pair other){
            return this.weight-other.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(in.readLine());
        ArrayList<Edges>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(in.readLine());
        for (int edge = 0; edge < edges; edge++) {
            String read = in.readLine();
            int vertex1 = Integer.parseInt(read.split(" ")[0]);
            int vertex2 = Integer.parseInt(read.split(" ")[1]);
            int weight = Integer.parseInt(read.split(" ")[2]);
            graph[vertex1].add(new Edges(vertex1, vertex2, weight));
            graph[vertex2].add(new Edges(vertex2, vertex1, weight));
        }
        int source = Integer.parseInt(in.readLine());
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        boolean [] visited = new boolean[vertices];
        priorityQueue.add(new Pair(source, source+"", 0));
        while(priorityQueue.size()>0){
            Pair removedPair = priorityQueue.remove();
            if(visited[removedPair.vertex]==true){
                continue;
            }
            visited[removedPair.vertex] = true;
            System.out.println(removedPair.vertex+" via "+ removedPair.pathSoFar +" @ "+ removedPair.weight);
            for(Edges edge : graph[removedPair.vertex]){
                if(visited[edge.neighbour]==false){
                    priorityQueue.add(new Pair(edge.neighbour, removedPair.pathSoFar+edge.neighbour, removedPair.weight+edge.weight));
                }
            }
        }

    }
}
