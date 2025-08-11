package Arrays.Medium;

import java.util.Arrays;

public class Next_Permutation {

    public static void reverse(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3,0,0};
        int n = arr.length;
        //finding the break point
        int index = -1;
        for(int i = n-2; i >= 0; i--) {
            if(arr[i] < arr[i+1]) {
                index = i;
                break;
            }
        }

        for(int i = n-1; i >= index; i--) {
            if(arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }
        //index+1 walle position se sort karna hai.
        reverse(arr,index+1,n-1);
        System.out.println(Arrays.toString(arr));
    }
}
