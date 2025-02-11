package Level1.DPOnStrings;

public class LongestCommonSubString {
    public int longestCommonSubstr(String str1, String str2) {
        int n1= str1.length();
        int n2= str2.length();
        int[][] dp = new int[n1][n2];
        int max=0;
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                if(str1.charAt(i) == str2.charAt(j)){
                    if(i+1<n1 && j+1<n2)
                        dp[i][j]=1+dp[i+1][j+1];
                    else
                        dp[i][j]=1;
                    
                }else{
                    dp[i][j]=0;
                }
                max=Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
