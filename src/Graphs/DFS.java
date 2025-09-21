package Graphs;

import java.util.ArrayList;

public class DFS {
    public static void dfs(int start, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        vis[start] = true;
        ans.add(start);

        for(int neighbor : adj.get(start)) {
            if(!vis[neighbor]) {
                dfs(neighbor, vis, adj, ans);
            }
        }
    }

    public static void main(String[] args) {
        //Creating a Graph :-
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        //0-1
        adj.get(0).add(1);
        adj.get(1).add(0);
        //0-2
        adj.get(0).add(2);
        adj.get(2).add(0);
        //1-3:-
        adj.get(1).add(3);
        adj.get(3).add(1);
        //1-4
        adj.get(1).add(4);
        adj.get(4).add(1);


        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(i, vis, adj, ans);
            }
        }

        System.out.println(ans);
    }
}