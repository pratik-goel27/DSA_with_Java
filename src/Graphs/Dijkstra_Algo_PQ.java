package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Dijkstra_Algo_PQ {
    //this pair class is for priority queue for storing (dist, node) :-
    static class Pair {
        int dist;
        int node;

        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    //this pair class is for creating adj list :-
    static class PairForAdj {
        int neighbor;
        int wt;

        PairForAdj(int neighbor, int wt) {
            this.neighbor = neighbor;
            this.wt = wt;
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<PairForAdj>> adj, int src) {
        //Creating adj list from edges array :-
//        ArrayList<ArrayList<PairForAdj>> adj = new ArrayList<>();
//        for(int i = 0; i < V; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for(int[] edge : edges) {
//            int u = edge[0];
//            int v = edge[1];
//            int wt = edge[2];
//            adj.get(u).add(new PairForAdj(v, wt));
//            adj.get(v).add(new PairForAdj(u, wt));
//        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.dist - y.dist);
        pq.add(new Pair(0, src));
        int[] distArr = new int[V];
        for(int i = 0; i < V; i++) distArr[i] = (int)(1e9);
        distArr[src] = 0;

        while(!pq.isEmpty()) {
            int dist = pq.peek().dist;
            int curr = pq.peek().node;
            pq.poll();

            for(int i = 0; i < adj.get(curr).size(); i++) {
                PairForAdj p = adj.get(curr).get(i);
                int edgeWt = p.wt;
                int adjNode = p.neighbor;

                if(dist + edgeWt < distArr[adjNode]) {
                    distArr[adjNode] = dist + edgeWt;
                    pq.add(new Pair(distArr[adjNode], adjNode));
                }
            }
        }

        return distArr;
    }

    public static void main(String[] args) {
        int V = 6; // number of vertices (0 to 5)
        ArrayList<ArrayList<PairForAdj>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new PairForAdj(1, 4));
        adj.get(1).add(new PairForAdj(0, 4));

        adj.get(0).add(new PairForAdj(2, 4));
        adj.get(2).add(new PairForAdj(0, 4));

        adj.get(1).add(new PairForAdj(2, 2));
        adj.get(2).add(new PairForAdj(1, 2));

        adj.get(2).add(new PairForAdj(3, 3));
        adj.get(3).add(new PairForAdj(2, 3));

        adj.get(3).add(new PairForAdj(5, 2));
        adj.get(5).add(new PairForAdj(3, 2));

        adj.get(2).add(new PairForAdj(5, 6));
        adj.get(5).add(new PairForAdj(2, 6));

        adj.get(2).add(new PairForAdj(4, 1));
        adj.get(4).add(new PairForAdj(2, 1));

        adj.get(4).add(new PairForAdj(5, 3));
        adj.get(5).add(new PairForAdj(4, 3));

        System.out.println(Arrays.toString(dijkstra(V, adj, 0)));
    }
}