package Level2;

import java.util.Collection;

public class Q030_LPS {
    public int longestPalindromeSubseq(String s) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        return longestCommonSubsequence(s, sb.toString());
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                    continue;
                }
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int longestPalindromeSubseqTab(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int gap = 0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap == 1){
                    dp[i][j]=1;
                    continue;
                }
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=2+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];

    }
}
