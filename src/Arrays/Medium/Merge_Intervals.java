package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        //BRUTE FORCE SOLUTION :-

//        List<List<Integer>> list = new ArrayList<>();
//        //Sorting the 2D array using comparator and lambda function :-
//        Arrays.sort(intervals, (a,b) -> {
//            if(a[0] != b[0]) {
//                return Integer.compare(a[0], b[0]);
//            }else {
//                return Integer.compare(a[1], b[1]);
//            }
//        });
//
//        //Main Logic :-
//        for(int i = 0; i < intervals.length; i++) {
//            int start = intervals[i][0];
//            int end = intervals[i][1];
//
//            if(!list.isEmpty() && end <= list.get(list.size()-1).get(1)) continue;
//
//            for(int j = i+1; j < intervals.length; j++) {
//                if(intervals[j][0] <= end) {
//                    end = Math.max(end, intervals[j][1]);
//                }else {
//                    break;
//                }
//            }
//
//            list.add(Arrays.asList(start, end));
//        }
//
//        //Since the return type is 2D arr so converting the list into arr :-
//        int row = list.size();
//        int col = list.get(0).size();
//        int[][] ans = new int[row][col];
//
//        for(int i = 0; i < row; i++) {
//            List<Integer> temp = list.get(i);
//            for(int j = 0; j < col; j++) {
//                ans[i][j] = temp.get(j);
//            }
//        }
//
//        return ans;

        //OPTIMAL SOLUTION :-(Mine Solution)
//        List<List<Integer>> list = new ArrayList<>();
//        //Sorting the 2D array using comparator and lambda function :-
//        Arrays.sort(intervals, (a,b) -> {
//            if(a[0] != b[0]) {
//                return Integer.compare(a[0], b[0]);
//            }else {
//                return Integer.compare(a[1], b[1]);
//            }
//        });
//
//        for(int i = 0; i < intervals.length; i++) {
//            int start = intervals[i][0];
//            int end = intervals[i][1];
//
//            if(!list.isEmpty() && start <= list.get(list.size()-1).get(1)) {
//                list.get(list.size()-1).set(1, Math.max(end, list.get(list.size()-1).get(1)));
//                continue;
//            }
//
//            list.add(Arrays.asList(start, end));
//        }
//
//        //Since the return type is 2D arr so converting the list into arr :-
//        int row = list.size();
//        int col = list.get(0).size();
//        int[][] ans = new int[row][col];
//
//        for(int i = 0; i < row; i++) {
//            List<Integer> temp = list.get(i);
//            for(int j = 0; j < col; j++) {
//                ans[i][j] = temp.get(j);
//            }
//        }
//
//        return ans;


        //This code is better for interview :-
        //sorting :-
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            //if the curr interval does not lie in the last interval :-
            if(list.isEmpty() || intervals[i][0] > list.get(list.size()-1).get(1)) {
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            //if the curr interval lies in the last interval :-
            else {
                list.get(list.size() - 1).set(1,
                        Math.max(intervals[i][1], list.get(list.size()-1).get(1)));
            }
        }

        int row = list.size();
        int col = list.get(0).size();
        int[][] ans = new int[row][col];

        for(int i = 0; i < row; i++) {
            List<Integer> temp = list.get(i);
            for(int j = 0; j < col; j++) {
                ans[i][j] = temp.get(j);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3}, {2,6}, {8,9}, {9,11}, {8,10}, {2,4}, {15,18}, {16,17}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }
}
