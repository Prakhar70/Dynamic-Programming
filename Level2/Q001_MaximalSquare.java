package Level2;

public class Q001_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxEdge = 0;
        int[][] dp = new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i == n-1 || j == m-1){
                    dp[i][j]=matrix[i][j]-'0';
                }else{
                    if(matrix[i][j] == '0'){
                        dp[i][j]=0;
                    }else{
                        int min = Integer.MAX_VALUE;
                        min = Math.min(min,dp[i+1][j]);
                        min = Math.min(min, dp[i][j+1]);
                        min=Math.min(min, dp[i+1][j+1]);
                        dp[i][j]=1+min;
                    }
                }
                maxEdge= Math.max(maxEdge,dp[i][j]);
            }
        }
        return maxEdge*maxEdge;
    }
}
