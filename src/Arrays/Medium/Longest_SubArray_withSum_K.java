package Arrays.Medium;

public class Longest_SubArray_withSum_K {
    public static int longestSubarray(int[] arr, int k) {
        //BRUTE FORCE:-(with O(n3))
//        int maxLen = 0;
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = i; j < arr.length; j++) {
//                int sum = 0;
//                for(int k = i; k <= j; k++) {
//                    sum += arr[k];
//                }
//                if(sum == K) {
//                    maxLen = Math.max(maxLen,(j-i+1));
//                }
//            }
//        }
//        System.out.println(maxLen);

        //BRUTE FORCE:-(with O(n2))
//        int maxLen = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int sum = 0;
//            for (int j = i; j < arr.length; j++) {
//                sum += arr[j];
//                if (sum == K) {
//                    maxLen = Math.max(maxLen, (j-i+1));
//                }
//            }
//        }
//        System.out.println(maxLen);

        //BETTER SOLUTION:- (when the array contains +ves and 0's) :-
        //It is an Optimal Solution when the array contains -ves as well.
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int sum = 0;
//        int len = 0;
//        for(int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//            if(sum == K) {
//                len = i+1;
//            }
//            int key = sum - K;
//            if(map.containsKey(key)) {
//                int val = map.get(key);
//                int newLen = i - val;
//                len = Math.max(len,newLen);
//            }
//            if(!map.containsKey(sum)) {
//                map.put(sum,i);
//            }
//        }
//
//        return len;

        //OPTIMAL SOLUTION:-
        int right = 0, left = 0;
        int maxLen = 0, sum = 0;
        while(right < arr.length) {
            sum += arr[right];
            while(sum > k) {
                sum -= arr[left];
                left++;
            }
            if(sum == k) maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,3,3};
        System.out.println(longestSubarray(arr, 6));
    }
}