package Level2;

public class Q027_RodCutting {
    public int cutRod(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n+1];
        int[] price1 = new int[n+1];
        int i=1;
        for(int price:prices){
            price1[i++]=price;
        }
        for(i=1;i<=n;i++){
            dp[i]=0;
            for(int k=1;k<=i;k++){
                dp[i]=Math.max(dp[i],price1[k]+dp[i-k]);
            }
        }
        return dp[n];
    }
}
