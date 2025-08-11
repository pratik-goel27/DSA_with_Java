package Arrays.Medium;

import java.util.Arrays;

public class Two_Sum {
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target = 14;

        //BRUTE FORCE:-
        int[] narr = new int[2];
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i]+arr[j] == target) {
                    narr[0] = i;
                    narr[1] = j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(narr));

        //OPTIMAL SOLUTION:-
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int[] narr = new int[2];
//        for(int i = 0; i < arr.length; i++) {
//            int key = target-arr[i];
//            if(map.containsKey(key)) {
//                narr[0] = map.get(key);
//                narr[1] = i;
//                break;
//            }else {
//                map.put(arr[i],i);
//            }
//        }
//        System.out.println(Arrays.toString(narr));
    }
}
