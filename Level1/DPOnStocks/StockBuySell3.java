package Level1.DPOnStocks;

import java.util.Arrays;

public class StockBuySell3 {
    public int stockBuySell(int[] arr, int n) {
        int k = 2;
        return stockBuySell_(arr, 0, 0, k);
    }

    private int stockBuySell_(int[] arr, int ind, int buy, int k) {
        int n = arr.length;
        if (k == 0 || ind == n) {
            return 0;
        }

        if (buy == 1) {
            return Math.max(arr[ind] + stockBuySell_(arr, ind + 1, 0, k - 1), stockBuySell_(arr, ind + 1, 1, k));
        }
        return Math.max(-arr[ind] + stockBuySell_(arr, ind + 1, 1, k), stockBuySell_(arr, ind + 1, 0, k));
    }

    public int stockBuySellDP(int[] arr, int n) {
        int k = 2;
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int[][] d2arr : dp) {
            for (int[] d1arr : d2arr) {
                Arrays.fill(d1arr, -1);
            }
        }
        return stockBuySellDP_(arr, 0, 0, k, dp);
    }

    private int stockBuySellDP_(int[] arr, int ind, int buy, int k, int[][][] dp) {
        int n = arr.length;
        if (k == 0 || ind == n) {
            return dp[ind][buy][k] = 0;
        }
        if (dp[ind][buy][k] != -1) {
            return dp[ind][buy][k];
        }

        if (buy == 1) {
            return dp[ind][buy][k] = Math.max(arr[ind] + stockBuySellDP_(arr, ind + 1, 0, k - 1, dp),
                    stockBuySellDP_(arr, ind + 1, 1, k, dp));
        }
        return dp[ind][buy][k] = Math.max(-arr[ind] + stockBuySellDP_(arr, ind + 1, 1, k, dp),
                stockBuySellDP_(arr, ind + 1, 0, k, dp));
    }

    public int stockBuySellTab(int[] arr, int n) {
        int K = 2;
        int[][][] dp = new int[n + 1][2][K + 1];

        for (int ind = n; ind >=0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int k = 0; k <= K; k++) {
                    if (k == 0 || ind == n) {
                        dp[ind][buy][k] = 0;
                        continue;
                    }
                    if (buy == 1) {
                        dp[ind][buy][k] = Math.max(arr[ind] + dp[ind + 1][0][k - 1], dp[ind + 1][1][k]);
                        continue;
                    }
                    dp[ind][buy][k] = Math.max(-arr[ind] + dp[ind + 1][1][k], dp[ind + 1][0][k]);
                }
            }
        }
        return dp[0][0][K];

    }

}
