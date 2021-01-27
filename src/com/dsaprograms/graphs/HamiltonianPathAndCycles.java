package com.dsaprograms.graphs;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/*
1. You are given a graph and a src vertex.
2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."
Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
Note -> Print in lexicographically increasing order.
Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0
Sample Output
0123456.
0123465.
0125643*
0346521*
 */
public class HamiltonianPathAndCycles {
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

    static void getHamiltonianPathsAndCycles(ArrayList<Edges>[] graph, HashSet<Integer> visited, int vertex, String pathSoFar, int originalSource){
        /*
        graph.length-1 because have a look at visited hashset it is one step behind the pathSoFar.
        (Initially visited had no elements but pathSoFar had source in it. )
        */
        if(visited.size()== graph.length-1){
            System.out.print(pathSoFar);
            boolean isClosingEdgeFound = false;
            for(Edges edge: graph[vertex]){
                if(edge.neighbor == originalSource){
                    isClosingEdgeFound = true;
                    break;
                }
            }
            if(isClosingEdgeFound){
                System.out.println("*");
            }
            else{
                System.out.println(".");
            }
            return;
        }

        visited.add(vertex);
        for(Edges edge:graph[vertex]){
            if(visited.contains(edge.neighbor)==false) {
                getHamiltonianPathsAndCycles(graph, visited, edge.neighbor, pathSoFar + edge.neighbor, originalSource);
            }
        }
        visited.remove(vertex);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edges>[] graph = new ArrayList[vertices];
        for(int i=0;i<vertices;i++){
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for(int i=0;i<edges;i++){
            String value = br.readLine();
            int vertex1 = Integer.parseInt(value.split(" ")[0]);
            int vertex2 = Integer.parseInt(value.split(" ")[1]);
            int weight = Integer.parseInt(value.split(" ")[2]);
            graph[vertex1].add(new Edges(vertex1,vertex2, weight));
            graph[vertex2].add(new Edges(vertex2,vertex1, weight));
        }

        int source = Integer.parseInt(br.readLine());
        HashSet<Integer> visited = new HashSet<>();
        getHamiltonianPathsAndCycles(graph, visited, source, source+"", source);
    }
}
