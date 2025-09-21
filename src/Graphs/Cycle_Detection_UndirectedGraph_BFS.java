package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cycle_Detection_UndirectedGraph_BFS {
    static class Pair {
        int node;
        int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

        // Add edges (undirected)
        adj[0].add(1); adj[1].add(0);
        adj[1].add(2); adj[2].add(1);
        adj[2].add(3); adj[3].add(2);
        adj[3].add(0); adj[0].add(3);

        System.out.println(isCycle(V, adj));
    }

    public static boolean checkForCycle(int src, int V, List<Integer>[] adj, boolean[] vis)
    {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, -1));

        while(!q.isEmpty()) {
            int curr = q.peek().node;
            int parent = q.peek().parent;
            q.poll();

            for(int neighbor : adj[curr]) {
                if(!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.offer(new Pair(neighbor, curr));
                }else if(parent != neighbor) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(checkForCycle(i, V, adj, visited)) return true;
            }
        }

        return false;
    }
}
