package SlidingWindow_TwoPointer;

public class Max_Points_from_Card {
    public static int maxScore(int[] cardPoints, int k) {
        int lsum = 0, rsum = 0, maxSum = 0;
        for(int i = 0; i <= k-1; i++) lsum += cardPoints[i];
        maxSum = lsum;

        int rindex = cardPoints.length-1;
        for(int i = k-1; i >= 0; i--) {
            lsum -= cardPoints[i];
            rsum += cardPoints[rindex];
            rindex--;

            maxSum = Math.max(maxSum, lsum+rsum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {6,2,3,4,7,2,1,7,1};
        System.out.println(maxScore(arr, 4));
    }
}
