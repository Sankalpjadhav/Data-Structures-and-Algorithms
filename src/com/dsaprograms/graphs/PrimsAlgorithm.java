package com.dsaprograms.graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    static class Edges{
        int source;
        int neighbour;
        int weight;

        Edges(int source, int neighbour, int weight){
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair>{
        int vertex;
        int reachedFromVertex;
        int weightOfEdge; // connecting vertex and reachedFromVertex
        Pair(int vertex, int reachedFromVertex , int weightOfEdge){
            this.vertex = vertex;
            this.reachedFromVertex = reachedFromVertex;
            this.weightOfEdge = weightOfEdge;
        }
        public int compareTo(Pair other){
            return this.weightOfEdge - other.weightOfEdge;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(reader.readLine());
        ArrayList<Edges> [] graph = new ArrayList[vertices];
        for(int vertex=0;vertex<vertices;vertex++){
            graph[vertex]= new ArrayList<>();
        }
        int edges = Integer.parseInt(reader.readLine());
        for(int edge=0;edge<edges;edge++){
            String read = reader.readLine();
            int vertex1 = Integer.parseInt(read.split(" ")[0]);
            int vertex2 = Integer.parseInt(read.split(" ")[1]);
            int weight = Integer.parseInt(read.split(" ")[2]);
            graph[vertex1].add(new Edges(vertex1, vertex2, weight));
            graph[vertex2].add(new Edges(vertex2, vertex1, weight));
        }
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        /*
        To add first pair in priorityQueue:
        1. vertex can be anything.
        2. reachedFromVertex will be -1 since it is the start vertex and it represents that it is not reached from any other vertex.
        3. weightOfEdge will be 0.
         */
        priorityQueue.add(new Pair(0, -1, 0));
        boolean [] visited = new boolean[vertices];
        while(priorityQueue.size()>0){
            Pair removedPair = priorityQueue.remove();
            if(visited[removedPair.vertex]==true){
                continue;
            }
            visited[removedPair.vertex] = true;
            if(removedPair.reachedFromVertex!=-1){
                System.out.println("["+removedPair.vertex + "-"+ removedPair.reachedFromVertex+"@"+removedPair.weightOfEdge+"]");
            }
            for(Edges edge: graph[removedPair.vertex]){
                if(visited[edge.neighbour]==false){
                    priorityQueue.add(new Pair(edge.neighbour,removedPair.vertex, edge.weight));
                }
            }
        }
    }
}
