package com.dsaprograms.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
/*
1. You are given a graph, and a source vertex.
2. You are required to do a iterative depth first traversal and print which vertex is reached via which
     path, starting from the source.

Note -> Iterative depth first traversal
               should mimic "Reverse preorder" i.e. nbr with highest value should be visited first and
               should be printed on the way down in recursion.
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
2
Sample Output
2@2
3@23
4@234
6@2346
5@23465
0@230
1@2301
 */
public class IterativeDFS {
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

    static class Pair{
        int vertex;
        String pathSoFar;
        Pair(int vertex, String pathSoFar){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
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
        Stack<Pair> stack = new Stack<>();
        boolean [] visited = new boolean[vertices];
        stack.push(new Pair(source,source+""));
        while(stack.size()>0){
            Pair removedPair = stack.pop();
            if(visited[removedPair.vertex]==true){
                continue;
            }
            visited[removedPair.vertex]=true;
            System.out.println(removedPair.vertex+"@"+removedPair.pathSoFar);
            for(Edges edge:graph[removedPair.vertex]){
                if (visited[edge.neighbour]==false){
                    stack.add(new Pair(edge.neighbour,removedPair.pathSoFar+edge.neighbour));
                }
            }

        }
    }
}
