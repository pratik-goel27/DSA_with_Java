package BinarySearch.Easy;

public class Single_Element_in_Sorted_Arr {
    public static int singleNonDuplicate(int[] nums) {
//  BRUTE FORCE SOLUTIONS :-
        //USING XOR :-
//        int ans = 0;
//        for(int i = 0; i < nums.length; i++) {
//            ans = ans ^ nums[i];
//        }
//        return ans;

        //USING HASHMAP :-
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length; i++) {
//            int val = map.getOrDefault(nums[i], 0);
//            map.put(nums[i], val+1);
//        }
//
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if(entry.getValue() == 1) {
//                return entry.getKey();
//            }
//        }
//        return -1;

//        int n = nums.length;
//        if(n == 1) return nums[0];
//
//        for(int i = 0; i < n-1; i++) {
//            if(i == 0) {
//                if(nums[i] != nums[i+1]) {
//                    return nums[i];
//                }
//            }else {
//                if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
//                    return nums[i];
//                }
//            }
//        }
//        return nums[n-1];

        //OPTIMAL SOLUTION :-
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int low = 1, high = n-2;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }else {
                if(mid % 2 == 0 && nums[mid] == nums[mid+1] || mid % 2 == 1 && nums[mid] == nums[mid-1]) {
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4};
        System.out.println(singleNonDuplicate(arr));
    }
}