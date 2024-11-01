package DPOnGrids;

import java.util.Arrays;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        return uniquePaths_(m - 1, n - 1, matrix);
    }

    private int uniquePaths_(int m, int n, int[][] matrix) {
        if (matrix[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        int ans = 0;
        if (m - 1 >= 0) {
            ans += uniquePaths_(m - 1, n, matrix);
        }
        if (n - 1 >= 0) {
            ans += uniquePaths_(m, n - 1, matrix);
        }
        return ans;
    }

    public int uniquePathsWithObstaclesDP(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return uniquePathsDP_(m - 1, n - 1, matrix, dp);
    }

    private int uniquePathsDP_(int m, int n, int[][] matrix, int[][] dp) {
        if (matrix[m][n] == 1) {
            return dp[m][n] = 0;
        }
        if (m == 0 && n == 0) {
            return dp[m][n] = 1;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int ans = 0;
        if (m - 1 >= 0) {
            ans += uniquePathsDP_(m - 1, n, matrix, dp);
        }
        if (n - 1 >= 0) {
            ans += uniquePathsDP_(m, n - 1, matrix, dp);
        }
        return dp[m][n] = ans;
    }

    public int uniquePathsWithObstaclesTab(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] dp = new int[M][N];
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if (matrix[m][n] == 1) {
                    dp[m][n] = 0;
                    continue;
                }
                if (m == 0 && n == 0) {
                    dp[m][n] = 1;
                    continue;
                }
                int ans = 0;
                if (m - 1 >= 0) {
                    ans += dp[m - 1][n];
                }
                if (n - 1 >= 0) {
                    ans += dp[m][n - 1];
                }
                dp[m][n] = ans;

            }
        }
        return dp[M - 1][N - 1];
    }
}
