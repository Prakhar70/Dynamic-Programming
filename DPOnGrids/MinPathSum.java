package DPOnGrids;

public class MinPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int m = matrix[0].length;
        int[][] dir = {{1,-1},{1,0},{1,1}};
        int[][] dp = new int[n][m];
        for(int r= n-1;r>=0;r--){
            for(int c = 0;c<m;c++){
                int min = Integer.MAX_VALUE;
                for(int[] d:dir){
                    int row = r+d[0];
                    int col = c+d[1];
                    if(row<=n && row>=0 && col<m && col>=0){
                        min=Math.min(min, dp[row][col]);
                    }
                }
                dp[r][c]=min+matrix[r][c];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int ele:dp[0]){
            ans= Math.min(ans , ele);
        }
        return ans;
    }
}
