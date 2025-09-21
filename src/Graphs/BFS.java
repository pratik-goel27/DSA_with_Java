package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static ArrayList<Integer> bfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for(int neighbor : adjList.get(curr)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Suppose we have 5 nodes (0 to 4)
        for (int i = 0; i <= 4; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected)
        // 0 - 1
        adj.get(0).add(1);
        adj.get(1).add(0);

        // 0 - 2
        adj.get(0).add(2);
        adj.get(2).add(0);

        // 1 - 3
        adj.get(1).add(3);
        adj.get(3).add(1);

        // 1 - 4
        adj.get(1).add(4);
        adj.get(4).add(1);
        boolean[] vis = new boolean[4];
        System.out.println(bfs(1, adj, vis));
    }
}
