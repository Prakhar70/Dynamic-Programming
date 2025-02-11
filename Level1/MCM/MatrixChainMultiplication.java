package Level1.MCM;

import java.util.Arrays;

public class MatrixChainMultiplication {
    static int matrixMultiplication(int N, int arr[]) {
        return matrixMultiplication(arr, 0, N - 2);
    }

    private static int matrixMultiplication(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int l1 = matrixMultiplication(arr, i, k);
            int l2 = matrixMultiplication(arr, k + 1, j);
            int m1 = arr[i] * arr[k + 1] * arr[j + 1];
            mini = Math.min(mini, l1 + l2 + m1);
        }
        return mini;
    }

    static int matrixMultiplicationDP(int N, int arr[]) {
        int[][] dp = new int[N][N];
        for (int[] arr1d : dp) {
            Arrays.fill(arr1d, -1);
        }
        return matrixMultiplicationDP(arr, 0, N - 2, dp);
    }

    private static int matrixMultiplicationDP(int[] arr, int i, int j, int[][] dp) {
        if (i == j) {
            return dp[i][j] = 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int l1 = matrixMultiplicationDP(arr, i, k, dp);
            int l2 = matrixMultiplicationDP(arr, k + 1, j, dp);
            int m1 = arr[i] * arr[k + 1] * arr[j + 1];
            mini = Math.min(mini, l1 + l2 + m1);
        }
        return dp[i][j] = mini;
    }

    static int matrixMultiplicationTab(int N, int arr[]) {
        int[][] dp = new int[N - 1][N - 1];

        for (int gap = 0; gap < N; gap++) {
            for (int i = 0, j = gap; j < N; i++, j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int l1 = dp[i][k];
                    int l2 = dp[k + 1][j];
                    int m1 = arr[i] * arr[k + 1] * arr[j + 1];
                    mini = Math.min(mini, l1 + l2 + m1);
                }
                dp[i][j] = mini;
            }
        }
        return dp[0][N - 2];
    }

}
