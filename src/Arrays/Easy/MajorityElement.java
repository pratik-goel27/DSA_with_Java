package Arrays.Easy;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int n = arr.length;

        //BRUTE FORCE SOLUTION:-
//        for(int i = 0; i < n; i++) {
//            int count = 0;
//            for(int j = 0; j < n; j++) {
//                if(arr[j] == arr[i]) {
//                    count++;
//                }
//            }
//            if(count > n/2) {
//                System.out.println(arr[i]);
//                break;
//            }
//        }

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
//        int result = 0;
//        //Putting Elements into the map:-
//        for(int i = 0; i < n; i++) {
//            int value = map.getOrDefault(arr[i],0);
//            map.put(arr[i],value+1);
//        }
//        //Searching elements from a map:-
//        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
//            if(entry.getValue() > n/2) {
//                result = entry.getKey();
//                break;
//            }
//        }
//        System.out.println(result);

        //OPTIMAL SOLUTION:(MOORE'S VOTING ALGORITHM)
        int ele = 0;
        int count = 0;
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

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == ele) {
                cnt++;
            }
        }
        if(cnt > n/2) {
            System.out.println(ele+" is majority element in the array.");
        }else {
            System.out.println("No majority element exist in the array.");
        }
    }
}
