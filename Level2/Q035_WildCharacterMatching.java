package Level2;

public class Q035_WildCharacterMatching {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        boolean[][] dp = new boolean[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                    continue;
                }
                if(i==0){
                    dp[i][j]=false;
                    continue;
                }
                if(j==0){
                    if(p.charAt(i-1)=='*'){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=false;
                    }
                    continue;
                }
                if(p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(i-1)=='*'){
                    dp[i][j]=false;
                    for(int k=0;k<=j;k++){
                        if(dp[i-1][k]==true){
                            dp[i][j]=true;
                            break;
                        }
                    }
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
}
