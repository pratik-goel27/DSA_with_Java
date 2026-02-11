package BinarySearch.Easy;

import java.util.ArrayList;

public class kth_missing_positive_num {
    public static int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 1; i <= 1000; i++) {
            boolean present = false;
            for(int j = 0; j < arr.length; j++) {
                if(i == arr[j]) {
                    present = true;
                    break;
                }
            }
            if(!present && k > al.size()) {
                al.add(i);
            }
            if(al.size() >= k) break;
        }

        return al.get(k-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(findKthPositive(arr, 2));
    }


}
