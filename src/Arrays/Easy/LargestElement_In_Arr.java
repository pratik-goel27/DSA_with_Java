package Arrays.Easy;

public class LargestElement_In_Arr {
    public static void main(String[] args) {
        int[] arr = {1,4,2,4,5,8,7};
        //BRUTE FORCE SOLUTION:-
//        Arrays.sort(arr);
//        System.out.println("Largest element is: "+arr[arr.length-1]);

        //OPTIMAL SOLUTION:-
        int largest = arr[0];
        for(int num : arr) {
            if(largest < num) {
                largest = num;
            }
        }
        System.out.println("Largest element is: "+largest);
    }
}
