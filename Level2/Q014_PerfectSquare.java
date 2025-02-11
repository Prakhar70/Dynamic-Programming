package Level2;

public class Q014_PerfectSquare {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        for(int i =1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            int j=1;
            while((i-(j*j))>=0){
                min=Math.min(min,dp[i-(j*j)]);
                j++;
            }
            dp[i]=min+1;
        }
        return dp[n];
    }
}
