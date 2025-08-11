package Arrays.Medium;

import java.util.ArrayList;

public class Intersection_Of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3,3,4,5,6};
        int[] arr2 = {2,3,3,5,6,6,7};
//        int[] visited = new int[arr2.length];
//        ArrayList<Integer> al = new ArrayList<>();
//
//        for(int i = 0; i < arr1.length; i++) {
//            for(int j = 0; j < arr2.length; j++) {
//                if(arr2[j] == arr1[i] && visited[j] == 0) {
//                    al.add(arr1[i]);
//                    visited[j] = 1;
//                    break;
//                }
//                if(arr2[j] > arr1[i]) {
//                    break;
//                }
//            }
//        }
//
//        System.out.println(al);

        int i = 0;
        int j = 0;
        ArrayList<Integer> al = new ArrayList<>();
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                i++;
            }else if(arr2[j] < arr1[i]) {
                j++;
            }else {
                al.add(arr1[i]);
                i++;
                j++;
            }
        }
        System.out.println(al);
    }
}
