package Level2;

public class Q010_MaxSumIS {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        int lsis = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    max=Math.max(max, dp[j]);
                }
            }
            dp[i]=arr[i]+max;
            lsis= Math.max(lsis,dp[i]);
        }
        return lsis;
    }
}
