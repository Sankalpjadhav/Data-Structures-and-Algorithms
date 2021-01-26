package com.dsaprograms.graphs;
import java.util.ArrayList;
import java.util.Scanner;
/*
Same concept as that of GetConnectedComponents.java :
If the graph is connected then only one component will be present.
If the graph has two or more components then it is not a connected graph.
 */
public class IsGraphConnected {
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
        System.out.print("Is graph connected ?");
        System.out.println(result.size()==1);
    }
}

