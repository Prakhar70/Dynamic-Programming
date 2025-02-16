package Level2;

import java.util.Arrays;

public class Q026_OptimalBST {
    static int optimalSearchTree(int keys[], int freq[], int n) {
        int sumSoFar = 0;
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            sumSoFar += freq[i];
            prefix[i] = sumSoFar;
        }
        sumSoFar = 0;
        int[] suffix = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sumSoFar += freq[i];
            suffix[i] = sumSoFar;
        }
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return optimalSearchTree_(freq, 0, n - 1, suffix, prefix, dp);
    }

    private static int optimalSearchTree_(int[] freq, int si, int ei, int[] suffix, int[] prefix, int[][] dp) {
        if (si == ei) {
            return dp[si][ei] = freq[si];
        }
        if (dp[si][ei] != -1) {
            return dp[si][ei];
        }
        int min = Integer.MAX_VALUE;
        for (int k = si; k <= ei; k++) {
            int ans = freq[k];
            if (k - 1 >= si) {
                ans += prefix[k - 1];
                if (si - 1 >= 0) {
                    ans -= prefix[si - 1];
                }
                ans += optimalSearchTree_(freq, si, k - 1, suffix, prefix, dp);
            }
            if (k + 1 <= ei) {
                ans += suffix[k + 1];
                if (ei + 1 < freq.length) {
                    ans -= suffix[ei + 1];
                }
                ans += optimalSearchTree_(freq, k + 1, ei, suffix, prefix, dp);
            }
            min = Math.min(min, ans);
        }
        return dp[si][ei] = min;
    }

    static int optimalSearchTreeTab(int keys[], int freq[], int n) {
        int sumSoFar = 0;
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            sumSoFar += freq[i];
            prefix[i] = sumSoFar;
        }
        sumSoFar = 0;
        int[] suffix = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sumSoFar += freq[i];
            suffix[i] = sumSoFar;
        }
        int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int si = 0, ei = gap; ei < n; si++, ei++) {
                if (si == ei) {
                    dp[si][ei] = freq[si];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int k = si; k <= ei; k++) {
                    int ans = freq[k];
                    if (k - 1 >= si) {
                        ans += prefix[k - 1];
                        if (si - 1 >= 0) {
                            ans -= prefix[si - 1];
                        }
                        ans += dp[si][k-1];
                    }
                    if (k + 1 <= ei) {
                        ans += suffix[k + 1];
                        if (ei + 1 < freq.length) {
                            ans -= suffix[ei + 1];
                        }
                        ans += dp[k+1][ei];
                    }
                    min = Math.min(min, ans);
                }
                dp[si][ei] = min;
            }
        }
        return dp[0][n-1];
    }
}
