package BinarySearch.Medium;

public class Find_Nth_Root_Of_a_Num {
    public static int NthRoot(int N, int M) {
//        int ans = -1;
//        for(int i = 1; i <= M/2; i++) {
//            int val = (int)Math.pow(N, i);
//            if(val == M) {
//                ans = i;
//                break;
//            }else if(val > M) {
//                return ans;
//            }
//        }
//        return ans;

        int low = 1, high = M/2;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high) / 2;
            int val = (int)Math.pow(N, mid);
            if(val == M) {
                ans = mid;
                break;
            }else if(val > M) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(NthRoot(3,27));
    }
}
