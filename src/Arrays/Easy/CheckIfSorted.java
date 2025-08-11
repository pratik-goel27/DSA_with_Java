package Arrays.Easy;

public class CheckIfSorted {
    public static boolean isSorted(int[] arr) {
        for(int i =  1; i < arr.length; i++) {
            if(arr[i] >= arr[i-1]) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4};
        boolean ans = isSorted(arr);
        if(ans) {
            System.out.println("Array is sorted");
        }else {
            System.out.println("Array is not sorted");
        }
    }
}
