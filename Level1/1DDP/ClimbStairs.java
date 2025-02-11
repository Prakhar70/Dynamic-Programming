import java.util.Arrays;

class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairsDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsDP_(n, dp);
    }

    public int climbStairsDP_(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = climbStairsDP_(n - 1, dp) + climbStairsDP_(n - 2, dp);
    }

    public int climbStairsTab(int N) {
        int[] dp = new int[N + 1];
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[N];
    }

    public int climbStairsOpti(int n) {
        int prev2 = 1;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev2+prev;
            prev2=prev;
            prev = curr;
        }
        return prev;
    }
}