package com.dsaprograms.graphs;
import java.util.ArrayList;
import java.util.Scanner;
/*
1. You are given a graph, a source vertex and a destination vertex.
2. You are required to find and print all paths between source and destination. Print
     them in lexicographical order.
E.g. Check the following paths
012546
01256
032546
03256
The lexicographically smaller path is printed first.
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
0123456
012346
03456
0346
 */
public class PrintAllPathsFromSrcToDest {
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

    static void printPathsFromSrcToDest(ArrayList<Edges> [] graph, int source, int destination, boolean [] visited, String pathSoFar){
        if(source == destination){
            System.out.println(pathSoFar);
            return;
        }

        visited[source] = true;
        for(Edges edge: graph[source]){
            if(visited[edge.neighbor] == false){
                printPathsFromSrcToDest(graph, edge.neighbor, destination, visited, pathSoFar+edge.neighbor);
            }
        }
        visited[source] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        ArrayList<Edges> [] graph = new ArrayList[vertices];
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
        int source = sc.nextInt();
        int destination = sc.nextInt();
        boolean [] visited = new boolean[vertices];
        printPathsFromSrcToDest(graph, source, destination, visited, source+"");
    }
}
