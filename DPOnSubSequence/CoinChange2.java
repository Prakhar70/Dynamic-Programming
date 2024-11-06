package DPOnSubSequence;

import java.util.Arrays;

public class CoinChange2 {
    private static final int MODULO = 1000000007;
    public int count(int[] coins, int N, int amount) {

        return count_(coins, N - 1, amount);
    }

    private int count_(int[] coins, int idx, int tar) {
        if (tar == 0) {
            return 1;
        }
        if (idx == 0) {
            if (tar % coins[idx] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int notPick = count_(coins, idx - 1, tar);
        int pick = 0;
        if (tar - coins[idx] >= 0) {
            pick = count_(coins, idx, tar - coins[idx]);
        }
        return pick + notPick;
    }

    // DP
    public int countDP(int[] coins, int N, int amount) {

        int[][] dp = new int[N][amount + 1];
        for (int[] arr1d : dp) {
            Arrays.fill(arr1d, -1);
        }
        return countDP_(coins, N - 1, amount, dp);
    }

    private int countDP_(int[] coins, int idx, int tar, int[][] dp) {
        if (tar == 0) {
            return dp[idx][tar] = 1;
        }
        if (idx == 0) {
            if (tar % coins[idx] == 0) {
                return dp[idx][tar] = 1;
            } else {
                return dp[idx][tar] = 0;
            }
        }
        if (dp[idx][tar] != -1) {
            return dp[idx][tar];
        }
        int notPick = countDP_(coins, idx - 1, tar, dp);
        int pick = 0;
        if (tar - coins[idx] >= 0) {
            pick = countDP_(coins, idx, tar - coins[idx], dp);
        }
        return dp[idx][tar] = (pick + notPick)%MODULO;
    }
    //Tabulation
    public int countTab(int[] coins, int N, int amount) {

        int[][] dp = new int[N][amount + 1];
        for(int idx=0;idx<N;idx++){
            for(int tar=0;tar<=amount;tar++){
                if (tar == 0) {
                    dp[idx][tar] = 1;
                    continue;
                }
                if (idx == 0) {
                    if (tar % coins[idx] == 0) {
                        dp[idx][tar] = 1;
                    } else {
                        dp[idx][tar] = 0;
                    }
                    continue;
                }
                
                int notPick = dp[idx-1][tar];//countDP_(coins, idx - 1, tar, dp);
                int pick = 0;
                if (tar - coins[idx] >= 0) {
                    pick =dp[idx][tar-coins[idx]];// countDP_(coins, idx, tar - coins[idx], dp);
                }
                dp[idx][tar] = (pick + notPick)%MODULO;
            }
        }
        return dp[N-1][amount];
    }
}
