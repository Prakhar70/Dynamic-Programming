public class NinjaTraining {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        int ans = 0;
        int[][] dp = new int[n][3];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < 3; c++) {
                if (r == 0) {

                    dp[r][c] = matrix[r][c];
                    ans = Math.max(ans, dp[r][c]);
                    continue;
                }
                dp[r][c] = 0;
                for (int i = 0; i < 3; i++) {
                    if (i != c) {
                        dp[r][c] = Math.max(dp[r][c], dp[r-1][i]);
                    }
                }
                dp[r][c] += matrix[r][c];
                ans = Math.max(ans, dp[r][c]);
            }
        }
        
        return ans;
    }
}
