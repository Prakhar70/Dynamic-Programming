package Level2;

public class Q041_ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        Boolean[][][][] dp = new Boolean[n][n][n][n];
        return isScramble(s1, 0, n - 1, s2, 0, n - 1, dp);
    }

    private boolean isScramble(String s1, int si1, int ei1, String s2, int si2, int ei2, Boolean[][][][] dp) {
        if (s1.substring(si1, ei1 + 1).equals(s2.substring(si2, ei2 + 1))) {
            return dp[si1][ei1][si2][ei2] = true;
        }
        if (dp[si1][ei1][si2][ei2] != null) {
            return dp[si1][ei1][si2][ei2];
        }
        for (int len = 1; len < ei1 - si1 + 1; len++) {
            boolean nonReverse = isScramble(s1, si1, si1 + len - 1, s2, si2, si2 + len - 1, dp)
                    && isScramble(s1, si1 + len, ei1, s2, si2 + len, ei2, dp);
            boolean reverse = isScramble(s1, si1, si1 + len - 1, s2, ei2 - len + 1, ei2, dp)
                    && isScramble(s1, si1 + len, ei1, s2, si2, ei2 - len, dp);
            boolean ans = dp[si1][ei1][si2][ei2] = nonReverse || reverse;
            if (ans == true)
                return dp[si1][ei1][si2][ei2] = ans;
        }
        return dp[si1][ei1][si2][ei2] = false;
    }

    public boolean isScramble3d(String s1, String s2) {
        int n = s1.length();
        Boolean[][][] dp = new Boolean[n][n][n+1];
        return isScramble3d(s1, s2, 0, 0, n, dp);
    }

    private boolean isScramble3d(String s1, String s2, int i, int j, int len, Boolean dp[][][]) {
        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            return dp[i][j][len]=true;
        }
        if(dp[i][j][len]!=null){
            return dp[i][j][len];
        }
        for (int k = 1; k < len; k++) {
            boolean nonReverse = isScramble3d(s1, s2, i, j, k, dp) && isScramble3d(s1, s2, i + k, j + k, len - k,dp);
            boolean reverse = isScramble3d(s1, s2, i, j + len - k, k, dp) && isScramble3d(s1, s2, i + k, j, len - k, dp);
            boolean ans = dp[i][j][len]=nonReverse || reverse;
            if(ans == true ){
                return true;
            }
        }
        return dp[i][j][len]=false;
    }
}
