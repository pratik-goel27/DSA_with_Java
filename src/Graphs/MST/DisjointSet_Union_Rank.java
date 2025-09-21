package Graphs.MST;

import java.util.ArrayList;
import java.util.List;

//class DisjointSet {
//    List<Integer> rank = new ArrayList<>();
//    List<Integer> parent = new ArrayList<>();
//    public DisjointSet(int n) {
//        for(int i = 0; i <= n; i++) {
//            rank.add(0);
//            parent.add(i);
//        }
//    }
//
//    public  int findUlPar(int node) {
//        if(node == parent.get(node)) {
//            return node;
//        }
//        int ulp = findUlPar(parent.get(node));
//        parent.set(node, ulp);
//        return parent.get(node);
//    }
//
//    public void unionByRank(int u, int v) {
//        int ulp_u = findUlPar(u);
//        int ulp_v = findUlPar(v);
//        if(ulp_u == ulp_v) return;
//
//        if(rank.get(ulp_u) < rank.get(ulp_v)) {
//            parent.set(ulp_u, ulp_v);
//        }else if(rank.get(ulp_v) < rank.get(ulp_u)) {
//            parent.set(ulp_v, ulp_u);
//        }else {
//            parent.set(ulp_v, ulp_u);
//            int rankU = rank.get(ulp_u);
//            rank.set(ulp_u, rankU+1);
//        }
//    }
//}

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }
    int findUlPar(int node) {
        if(node == parent.get(node)) {
            return node;
        }
        int ulp = findUlPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    void unionByRank(int u, int v) {
        int ulp_u = findUlPar(u);
        int ulp_v = findUlPar(v);

        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        }else if(rank.get(ulp_v)  < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        }else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }
}
public class DisjointSet_Union_Rank {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);

        //if 3 or 7 belongs to same component :-
        if(ds.findUlPar(3) == ds.findUlPar(7)) {
            System.out.println("Same");
        }else {
            System.out.println("Not Same");
        }

        ds.unionByRank(3,7);

        if(ds.findUlPar(3) == ds.findUlPar(7)) {
            System.out.println("Same");
        }else {
            System.out.println("Not Same");
        }
    }
}
