package com.dsaprograms.graphs;
import java.util.ArrayList;
import java.util.Scanner;
/*
1. You are given a graph, a src vertex and a destination vertex.
2. You are required to find if a path exists between src and dest. If it does, print true
     otherwise print false.
true if path exists, false otherwise
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
0
6
Sample Output
true
 */
public class HasPath {
    public static class Edges{
        int src;
        int neighbor;
        int weight;
        Edges(int src, int neighbor, int weight){
            this.src = src;
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    static boolean hasPath(ArrayList<Edges> [] graph, int source, int destination, boolean [] visited){
        if(source == destination){
            return true;
        }
        visited[source] = true;
        // Check if there is a path from neighbor.
        for(Edges edge: graph[source]){
            if(visited[edge.neighbor]==false) {
                boolean doesNeighborHasPath = hasPath(graph, edge.neighbor, destination, visited);
                if (doesNeighborHasPath == true) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        ArrayList<Edges> [] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = sc.nextInt();
        for(int i=0;i<edges;i++){
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            int weight = sc.nextInt();
            graph[vertex1].add(new Edges(vertex1, vertex2, weight));
            graph[vertex2].add(new Edges(vertex2, vertex1, weight));
        }
        int source = sc.nextInt();
        int destination = sc.nextInt();
        boolean[] visited= new boolean[vertices];
        System.out.println("Is there any path from "+source+" to "+destination+"? "+hasPath(graph,source, destination, visited));
    }
}
