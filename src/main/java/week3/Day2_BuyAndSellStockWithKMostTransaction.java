package week3;

import week1.Day2_DesignHashSet;

public class Day2_BuyAndSellStockWithKMostTransaction {
    public int maxProfit(int[] prices) {
        // using generic solution to max profit if given max kth transaction possible
        // here k = 2
        int dp[][] = new int[3][prices.length];
        // for any kth transaction on 0th day, profit is 0
        for (int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }
        // for 0th transaction on any day, profit is 0
        for (int i=0; i<dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i=1; i<3; i++) {
            for (int j=1; j<dp[0].length; j++) {
                int maxVal = 0;
                // if txn is done on jth day then considering stock must be bought on day less than j
                for (int m=0; m<j; m++) {
                    // max of none txn done and txn done on jth day but stock bought on mth day
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + dp[i-1][m]);
                }
                dp[i][j] = Math.max(dp[i][j-1], maxVal);
            }
        }
        return dp[2][prices.length - 1];
    }

    public static void main(String[] args) {
        Day2_BuyAndSellStockWithKMostTransaction obj = new Day2_BuyAndSellStockWithKMostTransaction();

        System.out.println(obj.maxProfit(new int[]{1,2,3,4,5}));
    }
}
