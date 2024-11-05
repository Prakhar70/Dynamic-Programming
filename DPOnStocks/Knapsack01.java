package DPOnStocks;

import java.util.Arrays;
public class Knapsack01 {
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        return knapsack01_(wt, val, n-1, W);
    }
        
    private int knapsack01_(int[] wt, int[] val, int idx, int W) {
        if(W==0){
            return 0;
        }
        if(idx==0){
            if(wt[0]<=W){
                return val[0];
            }else{
                return 0;
            }
        }
        int opt1 = knapsack01_(wt, val, idx-1, W);
        int opt2=0;
        if(W-wt[idx]>=0){
            opt2= val[idx]+knapsack01_(wt, val, idx-1, W-wt[idx]);
        }
        return Math.max(opt1, opt2);
    }


    public int knapsack01DP(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];
        for(int[] arr1d:dp){
            Arrays.fill(arr1d, -1);
        }
        return knapsack01DP_(wt, val, n-1, W, dp);
    }
        
    private int knapsack01DP_(int[] wt, int[] val, int idx, int W, int[][] dp) {
        if(W==0){
            return dp[idx][W]=0;
        }
        if(idx==0){
            if(wt[0]<=W){
                return dp[idx][W]=val[0];
            }else{
                return dp[idx][W]=0;
            }
        }
        if(dp[idx][W]!=-1){
            return dp[idx][W];
        }
        int opt1 = knapsack01DP_(wt, val, idx-1, W, dp);
        int opt2=0;
        if(W-wt[idx]>=0){
            opt2= val[idx]+knapsack01DP_(wt, val, idx-1, W-wt[idx], dp);
        }
        return dp[idx][W]=Math.max(opt1, opt2);
    }

    public int knapsack01Tab(int[] wt, int[] val, int n, int Wt) {
        int[][] dp = new int[n][Wt+1];
        for(int W=0;W<=Wt;W++){
            for(int idx=0;idx<n;idx++){
                if(W==0){
                    dp[idx][W]=0;
                    continue;
                }
                if(idx==0){
                    if(wt[0]<=W){
                        dp[idx][W]=val[0];
                    }else{
                        dp[idx][W]=0;
                    }
                    continue;
                }
                int opt1 = dp[idx-1][W];//knapsack01DP_(wt, val, idx-1, W, dp);
                int opt2=0;
                if(W-wt[idx]>=0){
                    opt2= val[idx]+dp[idx-1][W-wt[idx]];//knapsack01DP_(wt, val, idx-1, W-wt[idx], dp);
                }
                dp[idx][W]=Math.max(opt1, opt2);
            }
        }
        return dp[n-1][Wt];
    }

}
