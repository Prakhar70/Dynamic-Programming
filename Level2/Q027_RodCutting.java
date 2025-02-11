package Level2;

public class Q027_RodCutting {
    public int cutRod(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n+1];
        int[] price1 = new int[n+1];
        int k=1;
        for(int price:prices){
            price1[k++]=price;
        }
        for(int i=1;i<=n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                max=Math.max(max,price1[i-j]+dp[j]);
            }
            dp[i]=max;
        }
        return dp[n];
    }
}
