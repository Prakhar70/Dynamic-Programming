package Level1.DPOnGrids;
import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return uniquePaths_(m-1, n-1);
    }

    private int uniquePaths_(int m, int n) {
        if(m==0 && n==0){
            return 1;
        }
        int ans=0;
        if(m-1>=0){
            ans+=uniquePaths_(m-1, n);
        }
        if(n-1>=0){
            ans+=uniquePaths_(m, n-1);
        }
        return ans;
    }
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return uniquePathsDP_(m-1, n-1, dp);
    }
    private int uniquePathsDP_(int m, int n, int[][] dp) {
        if(m==0 && n==0){
            return dp[m][n]=1;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int ans=0;
        if(m-1>=0){
            ans+=uniquePathsDP_(m-1, n, dp);
        }
        if(n-1>=0){
            ans+=uniquePathsDP_(m, n-1,dp);
        }
        return dp[m][n]=ans;
    }
    public int uniquePathsTab(int M, int N) {
        int[][] dp = new int[M][N];
        for(int m=0;m<M;m++){
            for(int n=0;n<N;n++){
                if(m==0 && n==0){
                    dp[m][n]=1;
                    continue;
                }
                int ans=0;
                if(m-1>=0){
                    ans+=dp[m-1][n];
                }
                if(n-1>=0){
                    ans+=dp[m][n-1];
                }
                dp[m][n]=ans;

            }
        }
        return dp[M-1][N-1];
    }
}
