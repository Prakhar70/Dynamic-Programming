package Level2;

public class Q033_LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        int n = s.length();
        int si=0;
        int ei=n-1;
        boolean[][] dp = new boolean[n][n];
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap==0){
                    dp[i][j]=true;
                }else if(gap==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];
                }
                if(dp[i][j]==true){
                    si=i;
                    ei=j;
                }
            }
        }
        return s.substring(si,ei+1);
    }
}
