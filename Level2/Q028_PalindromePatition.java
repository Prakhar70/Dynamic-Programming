package Level2;

import java.util.Arrays;

public class Q028_PalindromePatition {
    public int minCut(String s) {
        int n =s.length();
        boolean[][] isPalin = prepareInPalindromMatrix(s);
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return minCut(s, isPalin, 0, dp);
    }

    private int minCut(String s, boolean[][] isPalin, int i, int[] dp) {
        int n =s.length();
        if(isPalin[i][n-1]==true){
            return dp[i]=0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for(int idx=i;idx<n;idx++){
            if(isPalin[i][idx]==true){
                min = Math.min(min,minCut(s,isPalin,idx+1,dp));
            }

        }
        return dp[i]=min+1;
    }

    private boolean[][] prepareInPalindromMatrix(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true;
                }
            }
        }
        return dp;
    }
    public int minCutTab(String s) {
        int n =s.length();
        boolean[][] isPalin = prepareInPalindromMatrix(s);
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            if(isPalin[0][i]){
                dp[i]=0;
            }else{
                int min=Integer.MAX_VALUE;
                for(int j=0;j<i;j++){
                    if(isPalin[j+1][i]){
                        min=Math.min(min,dp[j]);
                    }
                }
                dp[i]=min+1;
            }
        }
        return dp[n-1];
    }

}
