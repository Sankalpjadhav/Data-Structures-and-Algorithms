package com.dsaprograms.graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
/*
1. You are given a graph.
2. You are required to find and print if the graph is bipartite

Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually
               exclusive and exhaustive vertices such that all edges are across sets.
Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
Sample Output
The given graph is not bipartite.
 */
public class IsGraphBipartite {
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
        String pathSoFar; // Not required
        int level;
        Pair(int vertex, String pathSoFar, int level){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
            this.level = level;
        }
    }

    static boolean isBipartite(ArrayList<Edges>[] graph, int vertex, ArrayDeque<Pair> queue, int [] visited){
        queue.add(new Pair(vertex, vertex+"",0)); // level is 0 at the start.
        while(queue.size()>0){
            Pair removedPair = queue.removeFirst();
            if(visited[removedPair.vertex]!=-1){ // old level is present in visited[removedPair.vertex]
                // We need to do something here
                if(removedPair.level != visited[removedPair.vertex]){
                    // Same vertex but different levels-> Not a bipartite component.
                    return false;
                }
            }
            else{
                visited[removedPair.vertex] = removedPair.level;
            }
            for(Edges edge:graph[removedPair.vertex]){
                if(visited[edge.neighbour]==-1){
                    queue.add(new Pair(edge.neighbour, removedPair.pathSoFar+edge.vertex, removedPair.level+1));
                }
            }
        }
        return true;
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
        // Boolean in the form int array
        int [] visited = new int[vertices];
        Arrays.fill(visited,-1);// Initially all the vertices are not visited.
        // -1 represents not visited, otherwise represents level at which it is visited.
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for(int vertex=0;vertex<vertices;vertex++){
            if(visited[vertex]==-1) {
                boolean isComponentBipartite = isBipartite(graph, vertex, queue, visited);
                // If one of the component is not bipartite then the whole graph is not bipartite
                if(!isComponentBipartite){
                    System.out.println("The given graph is not bipartite.");
                    return;
                }
            }
        }
        System.out.println("The given graph is bipartite.");
    }
}
