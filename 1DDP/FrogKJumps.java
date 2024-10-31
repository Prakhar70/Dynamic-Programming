import java.util.Arrays;

public class FrogKJumps {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        return frogJump_(heights, k, n - 1);
    }

    private int frogJump_(int[] heights, int k, int idx) {

        if (idx == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; idx - i >= 0 && i <= k; i++) {
            int jumpi = Math.abs(heights[idx] - heights[idx - i]) + frogJump_(heights, k, idx - i);
            min = Math.min(min, jumpi);
        }
        return min;
    }

    public int frogJumpDP(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJumpDP_(heights, k, dp, n - 1);

    }

    private int frogJumpDP_(int[] heights, int k, int[] dp, int idx) {
        if (idx == 0) {
            return dp[idx] = 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; idx - i >= 0 && i <= k; i++) {
            int jumpi = Math.abs(heights[idx] - heights[idx - i]) + frogJumpDP_(heights, k, dp, idx - i);
            min = Math.min(min, jumpi);
        }
        return dp[idx] = min;
    }

    public int frogJumpTab(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        for (int idx = 0; idx < n; idx++) {
            if (idx == 0) {
                dp[idx] = 0;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; idx - i >= 0 && i <= k; i++) {
                int jumpi = Math.abs(heights[idx] - heights[idx - i]) + dp[idx - i];
                min = Math.min(min, jumpi);
            }
            dp[idx]=min;
        }
        return dp[n-1];
    }
}
