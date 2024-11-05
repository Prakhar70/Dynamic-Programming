package DPOnSubSequence;

public class EqualSumPartition {
    public boolean equalPartition(int n, int[] arr) {
        int sum =0;
        for(int ele:arr){
            sum+=ele;
        }
        if(sum%2 == 1){
            return false;
        }
        return isSubsetSumTab(arr, sum/2);
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
