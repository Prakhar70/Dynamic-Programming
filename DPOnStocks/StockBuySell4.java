package DPOnStocks;

public class StockBuySell4 {
    public int stockBuySellTab(int[] arr, int n, int K) {
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
