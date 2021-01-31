package com.dsaprograms.graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
/*
Using DFS
1. You are given a directed acyclic graph. The vertices represent tasks and edges represent
    dependencies between tasks.
2. You are required to find and print the order in which tasks could be done. The task that should be
    done at last should be printed first and the task which should be done first should be printed last.
    This is called topological sort.

Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort if
                                    for all directed edges uv, u appears before v in the permutation.

Sample Input
7
7
0 1
1 2
2 3
0 3
4 5
5 6
4 6
Sample Output
4
5
6
0
1
2
3
 */
public class TopologicalSort {
    static class Edges{
        int source;
        int neighbour;

        Edges(int source, int neighbour){
            this.source = source;
            this.neighbour = neighbour;
        }
    }

    static void topologicalSort(ArrayList<Edges>[] graph, int vertex, boolean [] visited, Stack<Integer> stack){
        visited[vertex]=true;
        for(Edges edge: graph[vertex]){
            if(visited[edge.neighbour]==false){
                topologicalSort(graph, edge.neighbour, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(reader.readLine());
        ArrayList<Edges>[] graph = new ArrayList[vertices];
        for(int vertex=0;vertex<vertices;vertex++){
            graph[vertex]= new ArrayList<>();
        }
        int edges = Integer.parseInt(reader.readLine());
        for(int edge=0;edge<edges;edge++){
            String read = reader.readLine();
            int vertex1 = Integer.parseInt(read.split(" ")[0]);
            int vertex2 = Integer.parseInt(read.split(" ")[1]);
            graph[vertex1].add(new Edges(vertex1, vertex2)); // There is no edge from vertex 2 to vertex 1 since it is a directed graph.
        }
        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean[vertices];
        for(int vertex=0;vertex<vertices;vertex++){
            if(visited[vertex]==false){
                topologicalSort(graph, vertex, visited, stack);
            }
        }
        System.out.println("Topological sort order:");
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
