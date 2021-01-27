package com.dsaprograms.graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
1. You are given a number n (representing the number of students). Each student will have an id
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are
     from different clubs.
Input Format
Input has been managed for you
Output Format
Check the sample output
Constraints
None
Sample Input
7
5
0 1
2 3
4 5
5 6
4 6
Sample Output
16
 */
public class PerfectFriends {
    
    static class Edges{
        int vertex;
        int neighbor;
        Edges(int vertex, int neighbor){
            this.vertex = vertex;
            this.neighbor = neighbor;
        }
    }

    static void getComponents(ArrayList<Edges> [] graph, int vertex, boolean [] visited, ArrayList<Integer> individualClub){
        visited[vertex] = true;
        individualClub.add(vertex);
        for(Edges edge: graph[vertex]){
            if(visited[edge.neighbor]==false){
                getComponents(graph, edge.neighbor, visited, individualClub);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        
        ArrayList<Edges> [] graph = new ArrayList[vertices];
        for(int i=0;i<vertices;i++){
            graph[i] = new ArrayList<>(); 
        }
        
        for(int edge=0;edge<edges;edge++){
            String line = br.readLine();
            int vertex1 = Integer.parseInt(line.split(" ")[0]);
            int vertex2 = Integer.parseInt(line.split(" ")[1]);
            graph[vertex1].add(new Edges(vertex1, vertex2));
            graph[vertex2].add(new Edges(vertex2, vertex1));
        }
        ArrayList<ArrayList<Integer>> clubs = new ArrayList<>();
        boolean [] visited = new boolean[vertices];
        for(int vertex=0;vertex<vertices;vertex++){
            if(visited[vertex]==false) {
                ArrayList<Integer> individualClub = new ArrayList<>();
                getComponents(graph, vertex, visited, individualClub);
                clubs.add(individualClub);
            }
        }
        //select a pair of students such that both students are from different clubs.
        int pairs=0;
        for(int i=0;i<clubs.size();i++){
            for(int j=i+1;j<clubs.size();j++){
                int count = clubs.get(i).size() * clubs.get(j).size();
                pairs += count;
            }
        }
        System.out.println("Count of pair of students such that both students are from different clubs: "+pairs);

    }
}
