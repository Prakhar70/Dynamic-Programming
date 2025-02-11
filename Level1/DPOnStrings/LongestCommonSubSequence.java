package Level1.DPOnStrings;

import java.util.Arrays;

public class LongestCommonSubSequence {
    public int lcs(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        return lcs(str1, str2, n1, n2);

    }

    private int lcs(String str1, String str2, int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        }
        if (str1.charAt(n1 - 1) == str2.charAt(n2 - 1)) {
            return 1 + lcs(str1, str2, n1 - 1, n2 - 1);
        }
        int opt1 = lcs(str1, str2, n1 - 1, n2);
        int opt2 = lcs(str1, str2, n1, n2 - 1);
        return Math.max(opt1, opt2);

    }

    public int lcsDP(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int[] arr1d : dp) {
            Arrays.fill(arr1d, -1);
        }
        return lcsDP(str1, str2, n1, n2, dp);

    }

    private int lcsDP(String str1, String str2, int n1, int n2, int[][] dp) {
        if (n1 == 0 || n2 == 0) {
            return dp[n1][n2] = 0;
        }
        if (str1.charAt(n1 - 1) == str2.charAt(n2 - 1)) {
            return dp[n1][n2] = 1 + lcsDP(str1, str2, n1 - 1, n2 - 1, dp);
        }
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        int opt1 = lcsDP(str1, str2, n1 - 1, n2, dp);
        int opt2 = lcsDP(str1, str2, n1, n2 - 1, dp);
        return dp[n1][n2] = Math.max(opt1, opt2);

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
