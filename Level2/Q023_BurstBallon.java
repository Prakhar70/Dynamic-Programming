package Level2;

import java.util.Arrays;

public class Q023_BurstBallon {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] d:dp)
            Arrays.fill(d,-1);
        return maxCoins(nums, 0, n - 1, dp);
    }

    private int maxCoins(int[] nums, int si, int ei,int[][] dp) {
        if(dp[si][ei]!=-1){
            return dp[si][ei];
        }
        int n=nums.length;
        int max=0;
        for(int idx=si;idx<=ei;idx++){
            int left=0,right=0;
            if(idx-1>=si)
                left=maxCoins(nums,si,idx-1,dp);
            if(idx+1<=ei)
                right=maxCoins(nums,idx+1,ei,dp);
            int self=nums[idx];
            if(si-1>=0){
                self*=nums[si-1];
            }
            if(ei+1<n){
                self*=nums[ei+1];
            }
            max=Math.max(max,left+right+self);
        }
        return dp[si][ei]=max;
    }
    public int maxCoinsTab(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int gap=0;gap<n;gap++){
            for(int si=0,ei=gap;ei<n;si++,ei++){
                int max=0;
                for(int idx=si;idx<=ei;idx++){
                    int left=0,right=0;
                    if(idx-1>=si)
                        left=dp[si][idx-1];//maxCoins(nums,si,idx-1,dp);
                    if(idx+1<=ei)
                        right=dp[idx+1][ei];//maxCoins(nums,idx+1,ei,dp);
                    int self=nums[idx];
                    if(si-1>=0){
                        self*=nums[si-1];
                    }
                    if(ei+1<n){
                        self*=nums[ei+1];
                    }
                    max=Math.max(max,left+right+self);
                }
                dp[si][ei]=max;
            }
        }
        return dp[0][n-1];
    }
}
