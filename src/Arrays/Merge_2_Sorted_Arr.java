package Arrays;
import java.util.Arrays;

public class Merge_2_Sorted_Arr {
    public static void swapIfG(int[] a, int[] b, int idx1, int idx2) {
        if(a[idx1] > b[idx2]) {
            int temp = b[idx2];
            b[idx2] = a[idx1];
            a[idx1] = temp;
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //BRUTE FORCE :- (USING EXTRA SPACE)
//        int i = 0, j = 0, k = 0;
//        int[] narr = new int[m+n];
//
//        while(i != m && j != n) {
//            if(nums1[i] <= nums2[j]) {
//                narr[k] = nums1[i];
//                i++;
//            }else {
//                narr[k] = nums2[j];
//                j++;
//            }
//            k++;
//        }
//
//        while(i != m) {
//            narr[k++] = nums1[i++];
//        }
//
//        while(j != n) {
//            narr[k++] = nums2[j++];
//        }
//
//        for (i = 0; i < m + n; i++) {
//            nums1[i] = narr[i];
//        }
//        System.out.println(Arrays.toString(nums1));


        //OPTIMAL SOLUTION-1 :-
//        int i = m-1;
//        int j = 0;
//
//        while(i >= 0 && j < n) {
//            if(nums1[i] > nums2[j]) {
//                int temp = nums1[i];
//                nums1[i] = nums2[j];
//                nums2[j] = temp;
//                i--;
//                j++;
//            }else {
//                break;
//            }
//        }
//
//        Arrays.sort(nums1, 0, m);
//        Arrays.sort(nums2);
//
//        for(i = 0; i < n; i++) {
//            nums1[m+i] = nums2[i];
//        }
//        System.out.println(Arrays.toString(nums1));


        //OPTIMAL SOLUTION-2 :- (gap method using shell sort)
        int len = (n + m);
        int gap = (len / 2) + (len % 2);

        while(gap > 0) {
            int left = 0;
            int right = left + gap;
            while(right < len) {
                //arr1 and arr2
                if(left < m && right >= m) {
                    swapIfG(nums1, nums2, left, right - m);
                }
                //arr2 and arr2
                else if(left >= m) {
                    swapIfG(nums2, nums2, left - m, right - m);
                }
                //arr1 and arr1
                else{
                    swapIfG(nums1, nums1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }

        for(int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = new int[9];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;
        nums1[3] = 7;
        int[] nums2 = {0,2,6,8,9};

        int m = 4;  //actual no. of valid elements.
        int n = nums2.length;

        merge(nums1, m, nums2, n);
    }
}
