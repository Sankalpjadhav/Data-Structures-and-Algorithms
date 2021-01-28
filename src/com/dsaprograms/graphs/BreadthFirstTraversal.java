package com.dsaprograms.graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
/*
1. You are given a graph, and a src vertex.
2. You are required to do a breadth first traversal and print which vertex is reached via which path,
     starting from the src.
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
1@21
3@23
0@210
4@234
5@2345
6@2346
 */
public class BreadthFirstTraversal {

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

    static class Pair{
        int vertex;
        String pathSoFar;

        Pair(int vertex, String pathSoFar){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }
    }

    public static void main(String[] args) throws IOException {
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
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(source,source+""));
        boolean [] visited = new boolean[vertices];
        /*
        Approach:
        1. remove
        2. markvisited
        3. work(print pathSOFar)
        4. addItsNotVisitedChildren
         */
        while(queue.size()>0){
            Pair removedPair = queue.removeFirst();//1
            if(visited[removedPair.vertex]==true){
                continue;
            }
            visited[removedPair.vertex]=true;//2
            System.out.println(removedPair.vertex+"@"+removedPair.pathSoFar);//3
            for(Edges edge: graph[removedPair.vertex]){ //4
                if(visited[edge.neighbor]==false){
                    queue.add(new Pair(edge.neighbor, removedPair.pathSoFar+edge.neighbor));
                }
            }
        }

    }
}
