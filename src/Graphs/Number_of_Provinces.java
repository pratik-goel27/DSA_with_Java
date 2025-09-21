package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Provinces {

    public static void main(String[] args) {
        int[][] adjMtx = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(numProvinces(adjMtx));
    }

    public static int numProvinces(int[][] adjMtx) {
        //converting the matrix into list:-
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < adjMtx.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < adjMtx.length; i++) {
            for(int j = 0; j < adjMtx[0].length; j++) {
                if(adjMtx[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[adjMtx.length];
        int count = 0;
        //visit every node and if not visited perform bfs and increase the counter.
        for(int i = 0; i < adjMtx.length; i++) {
            if(!visited[i]) {
                count++;
                bfs(i, visited, adjList);
            }
        }
        return count;
    }

    public static void bfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.offer(node);

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int i : adjList.get(curr)) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}



