package DPOnSubSequence;

import java.util.Arrays;

class CountSumSubset {
    private static final int MODULO = 1000000007;

    public int perfectSum(int[] arr, int K) {
        int n = arr.length;
        return perfectSum(arr, K, n - 1);
    }

    private int perfectSum(int[] arr, int target, int idx) {
        if (target == 0) {
            return 1;
        }
        if (idx == 0) {
            return arr[0] == target ? 1 : 0;
        }
        int cn1 = perfectSum(arr, target, idx - 1);
        int cn2 = 0;
        if (target - arr[idx] >= 0)
            cn2 = perfectSum(arr, target - arr[idx], idx - 1);
        return (cn1 + cn2) % MODULO;
    }

    public int perfectSumDP(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n][K + 1];
        for (int[] arr1 : dp) {
            Arrays.fill(arr1, -1);
        }
        return perfectSumDP(arr, K, n - 1, dp);

    }

    private int perfectSumDP(int[] arr, int target, int idx, int[][] dp) {
        if (target == 0) {
            return dp[idx][target] = 1;
        }
        if (idx == 0) {
            return dp[idx][target] = (arr[0] == target ? 1 : 0);
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }

        int cn1 = perfectSumDP(arr, target, idx - 1, dp);
        int cn2 = 0;
        if (target - arr[idx] >= 0)
            cn2 = perfectSumDP(arr, target - arr[idx], idx - 1, dp);
        return dp[idx][target] = (cn1 + cn2) % MODULO;
    }

    public int perfectSumTab(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n][K + 1];
        
        for (int idx = 0; idx < n; idx++) {
            for (int target = 0; target <= K; target++) {
                if (target == 0) {
                    dp[idx][target] = 1;
                    continue;
                }
                if (idx == 0) {
                    dp[idx][target] = (arr[0] == target ? 1 : 0);
                    continue;
                }
                int cn1 = dp[idx - 1][target];
                int cn2 = 0;
                if (target - arr[idx] >= 0)
                    cn2 = dp[idx - 1][target - arr[idx]];
                dp[idx][target] = (cn1 + cn2) % MODULO;
            }
        }
        return dp[n-1][K];
    }
}