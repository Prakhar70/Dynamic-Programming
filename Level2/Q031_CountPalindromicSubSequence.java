package Level2;

public class Q031_CountPalindromicSubSequence {
    int countPS(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int gap =0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap == 0){
                    dp[i][j]=1;
                    continue;
                }
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i][j-1]+dp[i+1][j]+1;
                }else{
                    dp[i][j]=dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];
                }
            }
        }
        return dp[0][n-1];
    }
}
