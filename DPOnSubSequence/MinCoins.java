package DPOnSubSequence;

import java.util.Arrays;

public class MinCoins {
    public int MinimumCoins(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] arr1d : dp) {
            Arrays.fill(arr1d, -1);
        }
        int ans = minCoins(coins, amount, n - 1, dp);
        if (ans != (int) 1e9) {
            return ans;
        }
        return -1;
    }

    private int minCoins(int[] coins, int amt, int idx, int[][] dp) {
        if (amt == 0) {
            return dp[idx][amt] = 0;
        }
        if (idx == 0) {
            if (amt % coins[0] == 0)
                return dp[idx][amt] = amt / coins[0];
            else
                return dp[idx][amt] = (int) 1e9;
        }
        if (dp[idx][amt] != -1) {
            return dp[idx][amt];
        }
        int notPick = minCoins(coins, amt, idx - 1, dp);
        int pick = (int) 1e9;
        if (amt - coins[idx] >= 0)
            pick = 1 + minCoins(coins, amt - coins[idx], idx, dp);
        return dp[idx][amt] = Math.min(notPick, pick);
    }

    public int MinimumCoinsTab(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int amt = 0; amt <= amount; amt++){
            for (int idx = 0; idx < n; idx++){
                if (amt == 0) {
                    dp[idx][amt] = 0;
                    continue;
                }
                if (idx == 0) {
                    if (amt % coins[0] == 0)
                        dp[idx][amt] = amt / coins[0];
                    else
                        dp[idx][amt] = (int) 1e9;
                    continue;
                }

                int notPick = dp[idx - 1][amt];// minCoins(coins, amt, idx - 1, dp);
                int pick = (int) 1e9;
                if (amt - coins[idx] >= 0)
                    pick = 1 + dp[idx][amt - coins[idx]];// minCoins(coins, amt - coins[idx], idx, dp);
                dp[idx][amt] = Math.min(notPick, pick);
            }
        }

        int ans = dp[n-1][amount];
        if (ans != (int) 1e9) {
            return ans;
        }
        return -1;
    }

}
