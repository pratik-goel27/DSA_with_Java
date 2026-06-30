package Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] arr) {
        //BRUTE FORCE SOLUTION:-
//        int n = arr.length;
//        for(int i = 0; i < n; i++) {
//            int count = 0;
//            for(int j = 0; j < n; j++) {
//                if(arr[j] == arr[i]) {
//                    count++;
//                }
//            }
//            if(count > n/2) return arr[i];
//        }
//        return -1;

        //MY SOLUTION:-
//        int max = arr[0];
//        for(int i = 0; i < n; i++) {
//            if(max < arr[i]) {
//                max = arr[i];
//            }
//        }
//        int[] hashArr = new int[max+1];
//        for(int i = 0; i < n; i++) {
//            hashArr[arr[i]]++;
//        }
//        int ans = 0;
//        int idx = 0;
//        for(int i = 1; i < hashArr.length; i++) {
//            if(hashArr[i] > ans) {
//                ans = hashArr[i];
//                idx = i;
//            }
//        }
//        System.out.println(idx);

        //BETTER SOLUTION:-
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int n = arr.length;
//        //Putting Elements into the map:-
//        for(int i = 0; i < n; i++) {
//            int value = map.getOrDefault(arr[i],0);
//            map.put(arr[i],value+1);
//        }
//        //Searching elements from the map:-
//        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
//            if(entry.getValue() > n/2) {
//                return entry.getKey();
//            }
//        }
//        return -1;

        //OPTIMAL SOLUTION (MOORE'S VOTING ALGORITHM) :-
        int n = arr.length;
        int ele = 0;
        int count = 0;
        //Applying the algo :-
        for(int i = 0; i < n; i++) {
            if(count == 0) {
                count = 1;
                ele = arr[i];
            }else if (arr[i] == ele) {
                count++;
            }else {
                count--;
            }
        }

        //Checking whether the ele is the majority element.
        count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == ele) count++;
        }
        if(count > n/2) return ele;
        else return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}
