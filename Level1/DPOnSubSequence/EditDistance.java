package Level1.DPOnSubSequence;

import java.util.Arrays;

public class EditDistance {
    public int editDistance(String start, String target) {
        int n = start.length();
        int m = target.length();
        int [][] dp=new int[n+1][m+1];
        for(int[] arr1d: dp)
            Arrays.fill(arr1d, -1);
        return editDistance(start, target, n, m, dp);
    }
    private int min(int... numbers){
        int min=Integer.MAX_VALUE;
        for(int ele:numbers){
            min=Math.min(min, ele);
        }
        return min;
    }
    private int editDistance(String start, String target, int n, int m, int[][] dp) {
        if(n==0 || m==0){
            if(n==0){
                return dp[n][m]=m;
            }else{
                return dp[n][m]=n;
            }
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(start.charAt(n-1)==target.charAt(m-1)){
            return dp[n][m]=editDistance(start, target, n-1, m-1, dp);
        }
        int insert = editDistance(start, target, n, m-1, dp);
        int delete = editDistance(start, target, n-1, m, dp);
        int replace = editDistance(start, target, n-1, m-1, dp);
        return dp[n][m]=1+min(insert, delete, replace);
       
    }
    public int editDistanceTab(String start, String target) {
        int N = start.length();
        int M = target.length();
        int [][] dp=new int[N+1][M+1];
        for(int n =0;n<=N;n++){
            for(int m=0;m<=M;m++){
                if(n==0 || m==0){
                    if(n==0){
                        dp[n][m]=m;
                        
                    }else{
                        dp[n][m]=n;
                    }
                    continue;
                }
                
                if(start.charAt(n-1)==target.charAt(m-1)){
                    dp[n][m]=dp[n-1][m-1];//editDistance(start, target, n-1, m-1, dp);
                    continue;
                }
                int insert = dp[n][m]=dp[n][m-1];//editDistance(start, target, n, m-1, dp);
                int delete = dp[n][m]=dp[n-1][m];//editDistance(start, target, n-1, m, dp);
                int replace = dp[n][m]=dp[n-1][m-1];//editDistance(start, target, n-1, m-1, dp);
                dp[n][m]=1+min(insert, delete, replace);
            }
        }
        return dp[N][M];
    }
}
