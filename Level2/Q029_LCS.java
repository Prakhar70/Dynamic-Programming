package Level2;

import java.util.Arrays;

public class Q029_LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return lcs(text1, text2, 0, 0, dp);
    }

    private int lcs(String text1, String text2, int si1, int si2, int[][] dp) {
        if(si1 == text1.length() || si2 == text2.length()){
            return dp[si1][si2]=0;
        }
        if(dp[si1][si2]==-1){
            return dp[si1][si2];
        }
        if(text1.charAt(si1)==text2.charAt(si2)){
            return dp[si1][si2]=1+lcs(text1, text2, si1+1, si2+1,dp);
        }
        return dp[si1][si2]=Math.max(lcs(text1, text2, si1+1, si2, dp), lcs(text1, text2, si1, si2+1,dp));
    }

    public int longestCommonSubsequenceTab(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
