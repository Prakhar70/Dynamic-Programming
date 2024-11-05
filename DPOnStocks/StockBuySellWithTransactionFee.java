package DPOnStocks;

import java.util.Arrays;

public class StockBuySellWithTransactionFee {
    public int stockBuySell(int[] arr, int n, int fee) {
        return stockBuySell_(arr, 0, 0, fee);
    }

    private int stockBuySell_(int[] arr, int ind, int buy, int fee) {
        int n = arr.length;
        if (ind == n) {
            return 0;
        }
        if (buy == 1) {
            return Math.max(arr[ind] - fee + stockBuySell_(arr, ind + 1, 0, fee), stockBuySell_(arr, ind + 1, 1, fee));
        }
        return Math.max(-arr[ind] + stockBuySell_(arr, ind + 1, 1, fee), stockBuySell_(arr, ind + 1, 0, fee));
    }

    public int stockBuySellDP(int[] arr, int n, int fee) {
        int[][] dp = new int[n + 1][2];
        for (int[] d1arr : dp) {
            Arrays.fill(d1arr, -1);
        }
        return stockBuySellDP_(arr, 0, 0, fee, dp);
    }

    private int stockBuySellDP_(int[] arr, int ind, int buy, int fee, int[][] dp) {
        int n = arr.length;
        if (ind == n) {
            return dp[ind][buy] = 0;

        }
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        if (buy == 1) {
            return dp[ind][buy] = Math.max(arr[ind] - fee + stockBuySellDP_(arr, ind + 1, 0, fee, dp),
                    stockBuySellDP_(arr, ind + 1, 1, fee, dp));
        }
        return dp[ind][buy] = Math.max(-arr[ind] + stockBuySellDP_(arr, ind + 1, 1, fee, dp),
                stockBuySellDP_(arr, ind + 1, 0, fee, dp));
    }
    public  int stockBuySellTab(int[] arr, int n, int fee) {

        int[][] dp = new int[n + 1][2];
        for (int ind = n; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (ind == n) {
                    dp[ind][buy] = 0;
                    continue;
                }

                if (buy == 1) {
                    dp[ind][buy] = Math.max(arr[ind] - fee + dp[ind + 1][0],dp[ind + 1][1]);
                    continue;
                }
                dp[ind][buy] = Math.max(-1 * arr[ind] + dp[ind + 1][1],
                        dp[ind + 1][0]);
            }
        }
        return dp[0][0];
    }

}
