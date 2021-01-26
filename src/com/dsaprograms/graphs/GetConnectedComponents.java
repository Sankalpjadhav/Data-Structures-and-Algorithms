package com.dsaprograms.graphs;
import java.util.ArrayList;
import java.util.Scanner;
/*
Similar concept for Leetcode: 323 Number of connected components of graph.
1. You are given a graph.
2. You are required to find and print all connected components of the graph.
Sample Input
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
Sample Output
[[0, 1], [2, 3], [4, 5, 6]]
 */
public class GetConnectedComponents {
    static class Edges{
        int source;
        int neighbor;
        int weight;

        public Edges(int source, int neighbor, int weight) {
            this.source = source;
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    static void getConnectedComponents(ArrayList<Edges>[] graph, int vertex, ArrayList<Integer> component, boolean[] visited){
        visited[vertex]= true;
        component.add(vertex);
        for(Edges edge: graph[vertex]){
            if(visited[edge.neighbor]==false){
                getConnectedComponents(graph, edge.neighbor, component,visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        ArrayList<Edges>[] graph = new ArrayList[vertices];
        for(int i=0;i<vertices;i++){
            graph[i] = new ArrayList<>();
        }
        int edges = sc.nextInt();
        for(int i=0;i<edges;i++){
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            int weight = sc.nextInt();
            graph[vertex1].add(new Edges(vertex1,vertex2, weight));
            graph[vertex2].add(new Edges(vertex2,vertex1, weight));
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean [] visited = new boolean[vertices];
        for(int vertex=0;vertex<vertices;vertex++){
            if(visited[vertex]==false){
                ArrayList<Integer> component = new ArrayList<>();
                getConnectedComponents(graph, vertex, component,visited);
                result.add(component);
            }
        }

        System.out.println("Connected components are: "+result);
    }
}
