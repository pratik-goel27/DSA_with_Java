package BinarySearch;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int ans = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if(ans > arr[i]) {
                ans = arr[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}
