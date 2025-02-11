package Level1.DPOnSubSequence;

public class UnboundedKnapsack {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        return unboundedKnapsack_(wt, val, n-1, W);
    }
        
    private int unboundedKnapsack_(int[] wt, int[] val, int idx, int W) {
        if(W==0){
            return 0;
        }
        if(idx==0){
            if(wt[0]<=W){
                return val[0]*(W/wt[0]);
            }else{
                return 0;
            }
        }
        int opt1 = unboundedKnapsack_(wt, val, idx-1, W);
        int opt2=0;
        if(W-wt[idx]>=0){
            opt2= val[idx]+unboundedKnapsack_(wt, val, idx, W-wt[idx]);
        }
        return Math.max(opt1, opt2);
    }

    //Tabulation
    public int unboundedKnapsackTab(int[] wt, int[] val, int n, int Wt) {
        int[][] dp = new int[n][Wt+1];
        for(int W=0;W<=Wt;W++){
            for(int idx=0;idx<n;idx++){
                if(W==0){
                    dp[idx][W]=0;
                    continue;
                }
                if(idx==0){
                    if(wt[0]<=W){
                        dp[idx][W]= val[0]*(W/wt[0]);
                    }else{
                        dp[idx][W]=0;
                    }
                    continue;
                }
                int opt1 = dp[idx-1][W];//knapsack01DP_(wt, val, idx-1, W, dp);
                int opt2=0;
                if(W-wt[idx]>=0){
                    opt2= val[idx]+dp[idx][W-wt[idx]];//knapsack01DP_(wt, val, idx-1, W-wt[idx], dp);
                }
                dp[idx][W]=Math.max(opt1, opt2);
            }
        }
        return dp[n-1][Wt];
    }

}
