package DPOnSubSequence;

public class TargetSumSubset {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][target + 1];
        return isSubsetSum(arr, target, n - 1, dp);
    }

    private boolean isSubsetSum(int[] arr, int target, int idx, Boolean[][] dp) {

        if (target == 0) {
            return dp[idx][target] = true;
        }
        if (idx == 0) {
            return dp[idx][target] = arr[idx] == target;
        }
        if (dp[idx][target] != null) {
            return dp[idx][target];
        }
        boolean notPick = isSubsetSum(arr, target, idx - 1, dp);
        boolean pick = false;
        if (target - arr[idx] >= 0)
            pick = isSubsetSum(arr, target - arr[idx], idx - 1, dp);

        return dp[idx][target] = notPick || pick;
    }
    private boolean isSubsetSumTab(int[] arr, int Target) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][Target + 1];
        for(int idx =0;idx<n;idx++){
            for(int target = 0;target<=Target; target++){
                if (target == 0) {
                    dp[idx][target] = true;
                    continue;
                }
                if (idx == 0) {
                    dp[idx][target] = arr[idx] == target;
                    continue;
                }
               
                boolean notPick = dp[idx-1][target];
                boolean pick = false;
                if (target - arr[idx] >= 0)
                    pick = dp[idx-1][target-arr[idx]];
        
                dp[idx][target] = notPick || pick;
            }
        }
        return dp[n-1][Target];
    }
}
