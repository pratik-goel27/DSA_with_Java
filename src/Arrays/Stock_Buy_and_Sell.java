package Arrays;

public class Stock_Buy_and_Sell {
    public static int maxProfit(int[] prices) {
        //BRUTE FORCE SOLUTION :-
//        int maxProfit = 0;
//
//        for (int i = 0; i < prices.length-1; i++) {    // Loop through each day as a potential buy day
//            for (int j = i + 1; j < prices.length; j++) {  // Loop through each future day as a potential sell day
//                int profit = prices[j] - prices[i];
//                maxProfit = Math.max(maxProfit, profit);
//            }
//        }
//
//        return maxProfit;

        //OPTIMAL SOLUTION :-
        int mini = prices[0], profit = 0;

        for(int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices[i]);
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
