package Level1.DPOnSubSequence;

import java.util.Arrays;

public class RodCutting {
    public int rodCutting(int price[], int n) {
        return rodCutting_(price, n);
    }

    private int rodCutting_(int[] prices, int len) {
        if (len == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int k = 1; k <= len; k++) {
            int price = prices[k - 1] + (rodCutting(prices, len - k));
            max = Math.max(max, price);
        }
        return max;
    }

    public int rodCuttingDP(int price[], int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return rodCutting_(price, n, dp);
    }

    private int rodCutting_(int[] prices, int len, int[] dp) {
        if (len == 0) {
            return dp[len] = 0;
        }
        if (dp[len] != -1) {
            return dp[len];
        }
        int max = Integer.MIN_VALUE;
        for (int k = 1; k <= len; k++) {
            int price = prices[k - 1] + (rodCutting_(prices, len - k, dp));
            max = Math.max(max, price);
        }
        return dp[len] = max;
    }

    public int rodCuttingTab(int prices[], int n) {
        int[] dp = new int[n + 1];
        for (int len = 0; len <= n; len++) {
            if (len == 0) {
                dp[len] = 0;
                continue;
            }
            int max = Integer.MIN_VALUE;
            for (int k = 1; k <= len; k++) {
                int price = prices[k - 1] + dp[len-k];//(rodCutting_(prices, len - k, dp));
                max = Math.max(max, price);
            }
            dp[len] = max;
        }
        return dp[n];
    }

    
}
