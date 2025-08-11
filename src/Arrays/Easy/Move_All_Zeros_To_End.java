package Arrays.Easy;

import java.util.Arrays;

public class Move_All_Zeros_To_End {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
//        ArrayList<Integer> al = new ArrayList<>();
//        for(int num : arr) {
//            if(num != 0) {
//                al.add(num);
//            }
//        }
//        for(int i = 0; i < al.size(); i++) {
//            arr[i] = al.get(i);
//        }
//        for(int i = al.size(); i < arr.length; i++) {
//            arr[i] = 0;
//        }
//
//        System.out.println(Arrays.toString(arr));
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }
        while(j != arr.length) {
            arr[j] = 0;
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
