package Level2;

public class Q038_LongestCommonSubString {
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    if(s2.charAt(j)==s1.charAt(i)){
                        dp[i][j]=1;
                    }
                    max=Math.max(max, dp[i][j]);
                    continue;
                }
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
                max=Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
