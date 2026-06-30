package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    public static int function(int n, int r) {
        int res = 1;
        for(int i = 0; i < r; i++) {
            res = res * (n-i);
            res = res / (i+1);
        }

        return res;
    }

    public static int generate(int n, int r) { //For getting the element at a particular position.
        return function(n-1, r-1);
    }

    public static void generate(int n) { //For printing the nth row of the triangle.
        //BRUTE FORCE :-  TC : O(n * r)
//        for(int i = 1; i <= n; i++) {
//            System.out.print(function(n-1, i-1)+" ");
//        }

        //OPTIMAL SOLUTION :-
        int ans = 1;
        System.out.print(ans+" ");
        for(int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans+" ");
        }
    }

//    public static List<List<Integer>> generate(int n) {  //Print the entire triangle.
//        List<List<Integer>> ans = new ArrayList<>();
//        for(int r = 1; r <= n; r++) {
//            List<Integer> temp = new ArrayList<>();
//            long res = 1;  //the intermediate multiplication may exceed int even though the final answer fits in int. that's why long is taken.
//            temp.add((int)res);
//            for(int c = 1; c < r; c++) {
//                res = res * (r - c);
//                res = res / c;
//                temp.add((int)res);
//            }
//            ans.add(temp);
//        }
//
//        return ans;
//    }

    public static void main(String[] args) {
//        System.out.println(generate(6,3));
        generate(6);
//        System.out.println(generate(6));
    }
}
