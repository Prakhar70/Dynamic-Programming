package Level1.DPOnSubSequence;

public class TargetSum {
    private static final int MODULO = 1000000007;

    public int countPartitions(int n, int diff, int[] arr) {
        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }
        int x = 0;
        x = (diff + sum);

        if (x % 2 == 1) {
            return 0;
        }
        x = x / 2;
        return perfectSumTab(arr, x);

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
        return dp[n - 1][K];
    }
    public int targetSum(int n, int target, int[] nums) {
        return countPartitions(n,target, nums);
    }
}
