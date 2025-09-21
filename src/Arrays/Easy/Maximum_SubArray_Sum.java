package Arrays.Easy;

public class Maximum_SubArray_Sum {
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        //BRUTE FORCE:-( O(N^3) --> This can handle n <= 300 after that the code will get stuck into TLE loop) :-
//        int sum = 0;
//        int maxSum = 0;
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = i; j < arr.length; j++) {
//                sum = 0;
//                for(int k = i; k <= j; k++) {
//                    sum += arr[k];
//                }
//                if(sum > maxSum) {
//                    maxSum = sum;
//                }
//            }
//        }
//        System.out.println(maxSum);

        //BETTER SOLUTION:- ( O(N^2) --> This can handle n <= 10^4 after that the code will give TLE error) :-
//        int sum = 0;
//        int maxSum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum = 0;
//            for (int j = i; j < arr.length; j++) {
//                sum += arr[j];
//                if (sum > maxSum) {
//                    maxSum = sum;
//                }
//            }
//        }
//        System.out.println(maxSum);

        //OPTIMAL SOLUTION:-(KADANE'S ALGORITHM)
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int ansStart = -1, ansEnd = -1;  // to print the subarray.
        int start = 0;
        for(int i = 0; i < arr.length; i++) {
            if(currSum == 0) {   //each we start a subarray from 0.
                start = i;
            }
            currSum += arr[i];
            if(currSum < 0) {
                currSum = 0;
            }
            if(currSum > maxSum) {
                maxSum = currSum;
                ansStart = start;
                ansEnd = i;
            }
        }
        System.out.println(maxSum);
        for(int i = ansStart; i <= ansEnd; i++) {    //printing the subarray.
            System.out.print(arr[i]+" ");
        }
    }
}
