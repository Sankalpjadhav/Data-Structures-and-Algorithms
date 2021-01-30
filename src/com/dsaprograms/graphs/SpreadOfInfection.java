package com.dsaprograms.graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
/*
1. You are given a graph, representing people and their connectivity.
2. You are also given a src person (who got infected) and time t.
3. You are required to find how many people will get infected in time t, if the infection spreads to neighbors of infected person in 1 unit of time.

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
6
3
Sample Output
4
 */
public class SpreadOfInfection {
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
        int time;
        Pair(int vertex, int time){
            this.vertex = vertex;
            this.time = time;
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
        int time = Integer.parseInt(in.readLine());
        int countOfPeopleInfected=0;
        int [] visited = new int[vertices];
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(source,1));
        while(queue.size()>0){
            Pair removedPair = queue.removeFirst();
            if(visited[removedPair.vertex]!=0){
                continue;
            }
            visited[removedPair.vertex]= removedPair.time;
            if(removedPair.time > time){
                break;
            }
            countOfPeopleInfected++;
            for(Edges edge: graph[removedPair.vertex]){
                if(visited[edge.neighbour]==0){
                    queue.add(new Pair(edge.neighbour, removedPair.time+1));
                }
            }
        }
        System.out.println("Number of people infected with virus: "+countOfPeopleInfected);
    }
}
