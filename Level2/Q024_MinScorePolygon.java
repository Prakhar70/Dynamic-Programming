package Level2;

import java.util.Arrays;

public class Q024_MinScorePolygon {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        return minScoreTriangulation(values, 0, n - 1);
    }

    private int minScoreTriangulation(int[] arr, int si, int ei) {
        if(ei-si+1<3){
            return 0;
        }
        if(ei-si+1==3){
            return arr[ei]*arr[si]*arr[si+1];
        }
        int min = Integer.MAX_VALUE;
        for(int k=si+1;k<=ei-1;k++){
            int ans=arr[si]*arr[ei]*arr[k];
            ans+=minScoreTriangulation(arr, si, k);
            ans+=minScoreTriangulation(arr, k, ei);
            min=Math.min(min,ans);
        }
        return min;
    }
    public int minScoreTriangulationDP(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return minScoreTriangulationDP(values, 0, n - 1, dp);
    }

    private int minScoreTriangulationDP(int[] arr, int si, int ei, int[][] dp) {
        if(ei-si+1<3){
            return dp[si][ei]=0;
        }
        if(ei-si+1==3){
            return dp[si][ei]=arr[ei]*arr[si]*arr[si+1];
        }
        if(dp[si][ei]!=-1){
            return dp[si][ei];
        }
        int min = Integer.MAX_VALUE;
        for(int k=si+1;k<=ei-1;k++){
            int ans=arr[si]*arr[ei]*arr[k];
            ans+=minScoreTriangulationDP(arr, si, k,dp);
            ans+=minScoreTriangulationDP(arr, k, ei,dp);
            min=Math.min(min,ans);
        }
        return dp[si][ei]=min;
    }
    public int minScoreTriangulationTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int gap=0;gap<n;gap++){
            for(int si=0,ei=gap;ei<n;si++,ei++){
                if(ei-si+1<3){
                    dp[si][ei]=0;
                    continue;
                }
                if(ei-si+1==3){
                    dp[si][ei]=arr[ei]*arr[si]*arr[si+1];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int k=si+1;k<=ei-1;k++){
                    int ans=arr[si]*arr[ei]*arr[k];
                    ans+=dp[si][k];//minScoreTriangulationDP(arr, si, k,dp);
                    ans+=dp[k][ei];//minScoreTriangulationDP(arr, k, ei,dp);
                    min=Math.min(min,ans);
                }
                dp[si][ei]=min;
            }
        }
        return dp[0][n-1];
    }
}

