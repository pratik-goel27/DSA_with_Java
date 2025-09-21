package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Pair {
        int wt;
        int node;

        Pair(int wt, int node) {
            this.wt = wt;
            this.node = node;
        }
    }

    static class PairAdj {
        int node;
        int wt;

        PairAdj(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public int spanningTree(int V, int[][] edges) {
        // Creating Graph :-
        ArrayList<ArrayList<PairAdj>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new PairAdj(v, wt));
            adj.get(v).add(new PairAdj(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        // {wt, node}
        pq.offer(new Pair(0,0));
        int sum = 0;
        boolean[] vis = new boolean[V];

        while(!pq.isEmpty()) {
            int curr = pq.peek().node;
            int wt = pq.peek().wt;
            pq.poll();

            if(!vis[curr]) {
                sum += wt;
                vis[curr] = true;

                for(PairAdj it : adj.get(curr)) {
                    int neighbor = it.node;
                    int edgewt = it.wt;
                    if(!vis[neighbor]) {
                        pq.offer(new Pair(edgewt, neighbor));
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
