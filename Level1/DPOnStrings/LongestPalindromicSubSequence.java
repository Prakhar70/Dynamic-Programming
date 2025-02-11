package Level1.DPOnStrings;

import java.util.Collection;

public class LongestPalindromicSubSequence {
    
    public int longestPalinSubseq(String s) {
        String revStr = new StringBuilder(s).reverse().toString();
        return lcsTab(revStr, s);
    }
    public int lcsTab(String str1, String str2) {
        int N1 = str1.length();
        int N2 = str2.length();
        int[][] dp = new int[N1 + 1][N2 + 1];
        for (int n1 = 0; n1 <= N1; n1++) {
            for (int n2 = 0; n2 <= N2; n2++) {
                if (n1 == 0 || n2 == 0) {
                    dp[n1][n2] = 0;
                    continue;
                }
                if (str1.charAt(n1 - 1) == str2.charAt(n2 - 1)) {
                    dp[n1][n2] = 1 + dp[n1 - 1][n2 - 1];// lcsDP(str1, str2, n1 - 1, n2 - 1, dp);
                    continue;
                }
                int opt1 = dp[n1 - 1][n2];// lcsDP(str1, str2, n1 - 1, n2, dp);
                int opt2 = dp[n1][n2 - 1];// lcsDP(str1, str2, n1, n2 - 1, dp);
                dp[n1][n2] = Math.max(opt1, opt2);

            }
        }
        return dp[N1][N2];
    }
}
