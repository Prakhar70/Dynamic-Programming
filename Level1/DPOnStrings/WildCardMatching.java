package Level1.DPOnStrings;

public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp=new Boolean[n+1][m+1];
        return isMatch(s, p, n, m, dp);
    }

    private boolean OnlyStar(String p, int m) {

        for (int i = 0; i < m; i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    private boolean isMatch(String s, String p, int n, int m, Boolean[][] dp) {
        if (n == 0) {
            if (m == 0 || OnlyStar(p, m) == true) {
                return dp[n][m]=true;
            }
            return dp[n][m]=false;
        }
        if(m==0){
            if(n==0){
                return dp[n][m]=true;
            }
            return dp[n][m]=false;
        }
        if(dp[n][m]!=null){
            return dp[n][m];
        }
        if(s.charAt(n-1)==p.charAt(m-1)){
            return dp[n][m]=isMatch(s, p, n-1, m-1, dp);
        }
        if(p.charAt(m-1)=='?'){
            return dp[n][m]=isMatch(s, p, n-1, m-1, dp);
        }
        if(p.charAt(m-1)=='*'){
            return dp[n][m]=isMatch(s, p, n-1, m, dp)||isMatch(s, p, n-1, m-1, dp)||isMatch(s, p, n, m-1, dp);
        }
        return dp[n][m]=false;
    }
    public boolean isMatchTab(String s, String p) {
        int N = s.length();
        int M = p.length();
        Boolean[][] dp=new Boolean[N+1][M+1];
        //return isMatch(s, p, n, m, dp);
        for(int n=0;n<=N;n++){
            for(int m =0;m<=M;m++){
                if (n == 0) {
                    if (m == 0 || OnlyStar(p, m) == true) {
                        dp[n][m]=true;
                        continue;
                    }
                    dp[n][m]=false;
                    continue;
                }
                if(m==0){
                    if(n==0){
                        dp[n][m]=true;
                        continue;
                    }
                    dp[n][m]=false;
                    continue;
                }
                
                if(s.charAt(n-1)==p.charAt(m-1) || p.charAt(m-1)=='?'){
                    dp[n][m]=dp[n-1][m-1];//isMatch(s, p, n-1, m-1, dp);
                    continue;
                }
                if(p.charAt(m-1)=='*'){
                    dp[n][m]=dp[n-1][m]||dp[n-1][m-1]||dp[n][m-1];//isMatch(s, p, n-1, m, dp)||isMatch(s, p, n-1, m-1, dp)||isMatch(s, p, n, m-1, dp);
                    continue;
                }
                dp[n][m]=false;
            }
        }
        return dp[N][M];
    }

    
}
