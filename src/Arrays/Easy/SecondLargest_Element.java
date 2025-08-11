package Arrays.Easy;

public class SecondLargest_Element {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,7,5};
        //BRUTE FORCE:-
//        Arrays.sort(arr);
//        int largest = arr[arr.length-1];
//        int secLarg = 0;
//        for(int i = arr.length-2; i >=0; i--) {
//            if(arr[i] != largest) {
//                secLarg = arr[i];
//                break;
//            }
//        }
//        System.out.println("First largest: "+largest);
//        System.out.println("Second largest: "+secLarg);

        //BETTER SOLUTION:-
//        int largest = arr[0];
//        int secLarg = -1;
//        for(int num : arr) {
//            if(num > largest) {
//                largest = num;
//            }
//        }
//        for(int num : arr) {
//            if(num > secLarg && num < largest) {
//                secLarg = num;
//            }
//        }
//
//        System.out.println(secLarg);

        //OPTIMAL SOLUTION:-
        int largest = arr[0];
        int secLarg = -1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largest) {
                secLarg = largest;
                largest = arr[i];
            }
            if(arr[i] > secLarg && arr[i] < largest) {
                secLarg = arr[i];
            }
        }

        System.out.println(secLarg);
    }
}
