package Level1.DPOnSubSequence;

public class MinSumPartition {
    public int minDifference(int[] arr, int n) {
        int sum=0;
        for(int ele:arr){
            sum+=ele;
        }
        Boolean[][] isSubSetSum=isSubsetSumTab(arr, sum);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(isSubSetSum[n-1][i] == true){
                min=Math.min(min, Math.abs(i-(sum-i)));
            }
        }
        return min;
    }
    private Boolean[][] isSubsetSumTab(int[] arr, int Target) {
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
        return dp;
    }
}
