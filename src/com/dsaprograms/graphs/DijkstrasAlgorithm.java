package com.dsaprograms.graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

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
