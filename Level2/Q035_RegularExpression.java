package Level2;

public class Q035_RegularExpression {
    public boolean isMatch(String s, String p) {
        int sei = s.length() - 1;
        int pei = p.length() - 1;
        Boolean[][] dp = new Boolean[sei + 2][pei + 2];
        return isMatch(s, p, 0, sei, 0, pei, dp);
    }

    private boolean isMatch(String str, String pat, int ssi, int sei, int psi, int pei, Boolean[][] dp) {
        if (dp[ssi][psi] != null) {
            return dp[ssi][psi];
        }
        if (psi + 1 <= pei) {
            if (pat.charAt(psi + 1) == '*') {
                if (pat.charAt(psi) != '.') {
                    int k = ssi;
                    boolean flag = isMatch(str, pat, k, sei, psi + 2, pei, dp);
                    while (k <= sei && str.charAt(k) == pat.charAt(psi)) {
                        flag = flag || isMatch(str, pat, k + 1, sei, psi + 2, pei, dp);
                        k++;
                    }
                    return dp[ssi][psi] = flag;
                } else {
                    int k = ssi;
                    boolean flag = isMatch(str, pat, k, sei, psi + 2, pei, dp);
                    while (k <= sei) {
                        flag = flag || isMatch(str, pat, k + 1, sei, psi + 2, pei, dp);
                        k++;
                    }
                    return dp[ssi][psi] = flag;
                }
            }
        }
        if (psi == pei + 1 || ssi == sei + 1) {
            if (psi == pei + 1 && ssi == sei + 1) {
                return dp[ssi][psi] = true;
            }
            return dp[ssi][psi] = false;
        }
        if (pat.charAt(psi) == '.' || pat.charAt(psi) == str.charAt(ssi)) {
            return dp[ssi][psi] = isMatch(str, pat, ssi + 1, sei, psi + 1, pei, dp);
        }
        return dp[ssi][psi] = false;
    }
}
