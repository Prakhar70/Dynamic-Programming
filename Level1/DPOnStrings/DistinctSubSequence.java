package Level1.DPOnStrings;

import java.util.Arrays;

public class DistinctSubSequence {
    private static final int MODULO = 1000000007;
    public int distinctSubsequences(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr1d: dp){
            Arrays.fill(arr1d, -1);
        }
        return distinctSubsequences(s, t, n, m, dp);
    }

    private int distinctSubsequences(String s, String t, int n, int m, int[][] dp) {
        if(m==0){
            return dp[n][m]=1;
        }
        if(n==0){
            return dp[n][m]=0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s.charAt(n-1)==t.charAt(m-1)){
            return dp[n][m]=(distinctSubsequences(s, t, n-1, m-1, dp)+distinctSubsequences(s, t, n-1,m, dp))%MODULO;
        }
        return dp[n][m]=distinctSubsequences(s, t, n-1,m, dp);
    }
    public int distinctSubsequencesTab(String s, String t) {
        int N = s.length();
        int M = t.length();
        int[][] dp = new int[N+1][M+1];

        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                if(m==0){
                    dp[n][m]=1;
                    continue;
                }
                if(n==0){
                    dp[n][m]=0;
                    continue;
                }
                if(s.charAt(n-1)==t.charAt(m-1)){
                    dp[n][m]=(dp[n-1][m-1]+ dp[n-1][m])%MODULO;
                    continue;
                }
                dp[n][m]=dp[n-1][m];
            }
        }
        return dp[N][M];
    }
}