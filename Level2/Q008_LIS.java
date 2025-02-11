package Level2;

public class Q008_LIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis = 0;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=0;
            for(int j = i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
            lis=Math.max(lis, dp[i]);
        }
        return lis;
    }
}
