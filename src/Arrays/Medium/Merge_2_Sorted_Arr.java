package Arrays.Medium;
import java.util.Arrays;

public class Merge_2_Sorted_Arr {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] narr = new int[m+n];
        while(i != m && j != n) {
            if(nums1[i] <= nums2[j]) {
                narr[k] = nums1[i];
                i++;
            }else {
                narr[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i != m) {
            narr[k] = nums1[i];
            i++; k++;
        }

        while(j != n) {
            narr[k] = nums2[j];
            j++; k++;
        }


        for (i = 0; i < m + n; i++) {
            nums1[i] = narr[i];
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7};
        int[] nums2 = {0,2,6,8,9};
        int m = nums1.length;
        int n = nums2.length;

        merge(nums1, m, nums2, n);
    }
}
