package Graphs;

import java.util.ArrayList;

public class Cycle_Detection_UndirectedGraph_DFS {
    public static boolean dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;

        for(int neighbor : adj.get(src)) {
            if(!vis[neighbor]) {
                if(dfs(neighbor, src, adj, vis)) return true;
            }else if(parent != neighbor){
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(0).add(2);
        adj.get(2).get(0);

        System.out.println(isCycle(V, adj));
    }
}