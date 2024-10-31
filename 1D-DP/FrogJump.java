import java.util.Arrays;

public class FrogJump {
    public int frogJump(int[] heights) {
        int n = heights.length;
        return frogJump_(heights, n - 1);
    }

    private int frogJump_(int[] heights, int idx) {
        if (idx == 0) {
            return 0;
        }
        if (idx == 1) {
            return Math.abs(heights[1] - heights[0]);
        }
        int jumpTwo = frogJump_(heights, idx - 2) + Math.abs(heights[idx] - heights[idx - 2]);
        int jumpOne = frogJump_(heights, idx - 1) + Math.abs(heights[idx] - heights[idx - 1]);
        return Math.min(jumpOne, jumpTwo);
    }

    public int frogJumpDP(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJumpDP_(heights, dp, n - 1);
    }

    private int frogJumpDP_(int[] heights, int[] dp, int idx) {
        if (idx == 0) {
            return dp[idx] = 0;
        }
        if (idx == 1) {
            return dp[idx] = Math.abs(heights[1] - heights[0]);
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int jumpTwo = frogJumpDP_(heights, dp, idx - 2) + Math.abs(heights[idx] - heights[idx - 2]);
        int jumpOne = frogJumpDP_(heights, dp, idx - 1) + Math.abs(heights[idx] - heights[idx - 1]);
        return dp[idx] = Math.min(jumpOne, jumpTwo);
    }

    private int frogJumpTab(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        for (int idx = 0; idx <= n - 1; idx++) {
            if (idx == 0) {
                dp[idx] = 0;
                continue;
            }
            if (idx == 1) {
                dp[idx] = Math.abs(heights[1] - heights[0]);
                continue;
            }
            int jumpTwo = dp[idx - 2] + Math.abs(heights[idx] - heights[idx - 2]);
            int jumpOne = dp[idx - 1] + Math.abs(heights[idx] - heights[idx - 1]);
            dp[idx] = Math.min(jumpOne, jumpTwo);
        }
        return dp[n - 1];
    }

    private int frogJumpOpti(int[] heights) {

        int n = heights.length;
        if (n == 1) {
            return 0;
        }
        int prev2 = 0;
        int prev = Math.abs(heights[1] - heights[0]);

        for (int idx = 2; idx <= n - 1; idx++) {

            int jumpTwo = prev2 + Math.abs(heights[idx] - heights[idx - 2]);
            int jumpOne = prev + Math.abs(heights[idx] - heights[idx - 1]);
            int curr = Math.min(jumpOne, jumpTwo);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

}
