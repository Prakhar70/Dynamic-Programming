package Level1.LIS;
class LIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }    
            }
            dp[i]++;
            if(dp[i]>ans){
                ans=dp[i];
            }
        }
        return ans;
    }
}