package com.dsaprograms.graphs;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
Multisolver - Smallest, Longest, Ceil, Floor, Kth largest Path
1. You are given a graph, a src vertex and a destination vertex.
2. You are give a number named "criteria" and a number "k".
3. You are required to find and print the values of
3.1 Smallest path and it's weight separated by an "@"
3.2 Largest path and it's weight separated by an "@"
3.3 Just Larger path (than criteria in terms of weight) and it's weight separated by an "@"
3.4 Just smaller path (than criteria in terms of weight) and it's weight separated by an "@"
3.5 Kth largest path and it's weight separated by an "@"
Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
6
30
4
Sample Output
Smallest Path = 01256@28
Largest Path = 032546@66
Just Larger Path than 30 = 012546@36
Just Smaller Path than 30 = 01256@28
4th largest path = 03456@48
 */
public class MultiSolverConcepts {
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

    static class Pair implements Comparable<Pair>{
        int weightSoFar;
        String pathSoFar;
        Pair(int weightSoFar, String pathSoFar){
            this.weightSoFar = weightSoFar;
            this.pathSoFar = pathSoFar;
        }

        public int compareTo(Pair other){
            return this.weightSoFar - other.weightSoFar;
        }
    }

    static String smallestPath;
    static int smallestPathWeight = Integer.MAX_VALUE;
    static String longestPath;
    static int longestPathWeight = Integer.MIN_VALUE;
    static String ceilPath;
    static int ceilPathWeight = Integer.MAX_VALUE;
    static String floorPath;
    static int floorPathWeight = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    static void printPathsFromSrcToDest(ArrayList<Edges>[] graph, int source, int destination, int criteria, int k, boolean [] visited, String pathSoFar, int weightSoFar){
        if(source == destination){
            if(weightSoFar < smallestPathWeight){
                smallestPathWeight = weightSoFar;
                smallestPath = pathSoFar;
            }

            if(weightSoFar > longestPathWeight){
                longestPathWeight = weightSoFar;
                longestPath = pathSoFar;
            }

            if(weightSoFar > criteria && weightSoFar < ceilPathWeight){
                ceilPathWeight = weightSoFar;
                ceilPath = pathSoFar;
            }

            if(weightSoFar < criteria && weightSoFar > floorPathWeight){
                floorPathWeight = weightSoFar;
                floorPath = pathSoFar;
            }

            if(pq.size()<k){
                pq.add(new Pair(weightSoFar, pathSoFar));
            }
            else{
                if(weightSoFar > pq.peek().weightSoFar){
                    pq.remove();
                    pq.add(new Pair(weightSoFar, pathSoFar));
                }
            }

            return;
        }

        visited[source] = true;
        for(Edges edge: graph[source]){
            if(visited[edge.neighbor] == false){
                printPathsFromSrcToDest(graph, edge.neighbor, destination, criteria, k, visited, pathSoFar+edge.neighbor, weightSoFar+ edge.weight);
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
        int criteria = sc.nextInt(); // Floor and Ceil
        int k = sc.nextInt();
        boolean [] visited = new boolean[vertices];
        printPathsFromSrcToDest(graph, source, destination, criteria, k, visited, source+"", 0);
        System.out.println("Smallest Path = " + smallestPath + "@" + smallestPathWeight);
        System.out.println("Largest Path = " + longestPath + "@" + longestPathWeight);
        System.out.println("Just Larger Path than " + criteria + " = " + ceilPath + "@" + ceilPathWeight);
        System.out.println("Just Smaller Path than " + criteria + " = " + floorPath + "@" + floorPathWeight);
        System.out.println(k + "th largest path = " + pq.peek().pathSoFar + "@" + pq.peek().weightSoFar);
    }
}
